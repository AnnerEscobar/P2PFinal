package Metodos;

import Conexion.Conexion;
import Datos.ModeloPokemon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TraerInfo {

    ModeloPokemon model = new ModeloPokemon();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<ModeloPokemon> TraerInformacion(int contador) {

        List<ModeloPokemon> ListaPokemon = new ArrayList<>();

        try {

            String sql = "select *from pokemon where id=" + (contador + 1);
            conn = Conexion.OpenConection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {

                model.setId(rs.getInt(1));
                model.setName(rs.getString(2));
                model.setHeight(rs.getString(10));
                model.setWeight(rs.getString(11));
                model.setSpecies(rs.getString(12));
                model.setColor(rs.getString(13));
                model.setHabitat(rs.getString(15));
                model.setBase_experience(rs.getString(18));
                model.setGeneration_id(rs.getString(5));

            } else {

                model.setId(model.getId());
                model.setName("NO TENGO INFORAMCION");
                model.setHeight("***");
                model.setWeight("***");
                model.setSpecies("***");
                model.setColor("***");
                model.setHabitat("***");
                model.setBase_experience("***");

            }
            ListaPokemon.add(model);

            System.out.println(model.getName());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "No se pudo desplegar tu informacion");
        } finally {
            Conexion.CloseConection(stmt);
            Conexion.CloseConection(conn);
            Conexion.CloseConection(rs);
        }

        return ListaPokemon;
    }

    public ResultSet ejecutarConsulta(JTextField nombre) {
        String query = "SELECT *FROM pokemon where name = '" + nombre.getText().substring(0, 1).toUpperCase() + nombre.getText().substring(1).toLowerCase() + "'";
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            conn = Conexion.OpenConection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rs;
    }

    public void ejecutarConsultaCombo(JComboBox combo, JTable Jtable) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("name");
        modelo.addColumn("generation_id");
        modelo.addColumn("height");
        Jtable.setModel(modelo);

        String query = "SELECT *FROM pokemon where habitat = '" + combo.getSelectedItem().toString() + "'";
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = Conexion.OpenConection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            String[] info = new String[4];
            while (rs.next()) {
                //contador=Integer.valueOf(resultadoConsulta.getString(1))-1;
                info[0] = rs.getString(1);
                info[1] = rs.getString(2);
                info[2] = rs.getString(5);
                info[3] = rs.getString(10);
                modelo.addRow(info);
            }
            /*else {
                nombrePokemon.setText("Este chucho no esta en el pokedex");
            }*/

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
    }

    public void CargaCombo(JComboBox combo) {

        String cuerito = "SELECT distinct(habitat) as habitat FROM pokemon order by 1";
        try {
            conn = Conexion.OpenConection();
            stmt = conn.prepareStatement(cuerito);
            rs = stmt.executeQuery();

            while (rs.next()) {
                combo.addItem(rs.getString("habitat"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
    }

    public void asignar(JLabel Lnombre, JLabel Laltura, JLabel Lpeso, JLabel Lespecie, JLabel Lcolor, JLabel Lhabitad, JLabel Lexperiencia, JLabel Lid, JLabel LGeneracion) {

        Lnombre.setText(model.getName());
        Laltura.setText(model.getHeight());
        Lpeso.setText(model.getWeight());
        Lespecie.setText(model.getSpecies());
        Lcolor.setText(model.getColor());
        Lhabitad.setText(model.getHabitat());
        Lexperiencia.setText(model.getBase_experience());
        Lid.setText(String.valueOf(model.getId()));
        LGeneracion.setText(model.getGeneration_id());

    }

       
}
