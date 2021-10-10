package Graficos;

import Datos.ModeloPokemon;
import Datos.ModeloUsuarios;
import Metodos.AgFavoritos;
import Metodos.TraerInfo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Consola extends javax.swing.JFrame {
    
    private final String dafault = "*********";
    TraerInfo metodo = new TraerInfo();
    ModeloPokemon m = new ModeloPokemon();
    ModeloUsuarios mu = new ModeloUsuarios();
    AgFavoritos g = new AgFavoritos();
    private ResultSet rs;
    
    int contador = 0;
    BufferedImage buffer1 = null;
    Image imagen1 = null;
    
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) PokemonImagen.getGraphics(); 
        g2.drawImage(buffer1, 0, 0, PokemonImagen.getWidth(), PokemonImagen.getHeight(), null);
        
    }
    
    public Consola() {
        initComponents();
        Imagen();
        
    }
    
    public void Imagen() {
        try {
            //imagen1 = ImageIO.read(getClass().getResource("/imagenes/back-white.png"));
            imagen1 = ImageIO.read(new File("C:\\Users\\Anner\\Documents\\imagenes\\black-white.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        buffer1 = (BufferedImage) PokemonImagen.createImage(
                PokemonImagen.getWidth(),
                PokemonImagen.getHeight());
        
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
    }
    
    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;
        
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                PokemonImagen.getWidth(),
                PokemonImagen.getHeight());
        
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel 
                0, // posicion Y inicial dentro del jpanel
                PokemonImagen.getWidth(), //ancho del jpanel
                PokemonImagen.getHeight(), //alto del jpanel
                columna * 96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila * 96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna * 96 + 96, //posicion final X
                fila * 96 + 96, //posicion final Y
                null //si no lo pones no va
        );
        
        repaint();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Laltura = new javax.swing.JLabel();
        Lnombre = new javax.swing.JLabel();
        Lpeso = new javax.swing.JLabel();
        Lespecie = new javax.swing.JLabel();
        Lcolor = new javax.swing.JLabel();
        Lhabitad = new javax.swing.JLabel();
        Lexperiencia = new javax.swing.JLabel();
        btnInciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PokemonImagen = new javax.swing.JPanel();
        Lid = new javax.swing.JLabel();
        btnRetroceder = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnAgfav = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        btneliminarfav = new javax.swing.JButton();
        FieldBusqueda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnFiltros = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        LGeneracion = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Laltura.setText("***");
        getContentPane().add(Laltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        Lnombre.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        Lnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lnombre.setText("Nombre");
        getContentPane().add(Lnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 260, 30));

        Lpeso.setText("***");
        getContentPane().add(Lpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        Lespecie.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        Lespecie.setText("especie");
        getContentPane().add(Lespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 70, 20));

        Lcolor.setText("***");
        getContentPane().add(Lcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        Lhabitad.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        Lhabitad.setText("habitad");
        getContentPane().add(Lhabitad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 60, 20));

        Lexperiencia.setText("***");
        getContentPane().add(Lexperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        btnInciar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anner\\Documents\\imagenes\\botonderecha.png")); // NOI18N
        btnInciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 40, 30));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIBRAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 50, 20));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COLOR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 40, 20));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PIES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 40));

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("XP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 40, 20));

        PokemonImagen.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PokemonImagenLayout = new javax.swing.GroupLayout(PokemonImagen);
        PokemonImagen.setLayout(PokemonImagenLayout);
        PokemonImagenLayout.setHorizontalGroup(
            PokemonImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        PokemonImagenLayout.setVerticalGroup(
            PokemonImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        getContentPane().add(PokemonImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 230, 110));

        Lid.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        Lid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lid.setText("*");
        getContentPane().add(Lid, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 30, 20));

        btnRetroceder.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anner\\Documents\\imagenes\\botonizquierdo.png")); // NOI18N
        btnRetroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 40, 30));

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("FAVORITOS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 90, -1));

        btnAgfav.setText("+");
        btnAgfav.setActionCommand("");
        btnAgfav.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAgfav.setFocusCycleRoot(true);
        btnAgfav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgfavActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgfav, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 30, 40));

        labelUsuario.setText("Usuario");
        getContentPane().add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 130, -1));

        btneliminarfav.setText("-");
        btneliminarfav.setActionCommand("");
        btneliminarfav.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btneliminarfav.setFocusCycleRoot(true);
        btneliminarfav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarfavActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminarfav, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 30, 40));
        getContentPane().add(FieldBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 160, 30));

        jLabel5.setText("BUSCA A TU POKEMON");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, -1, 30));

        btnFiltros.setText("Mas Funcioes");
        btnFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 120, -1));

        jLabel7.setText("Gener");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        LGeneracion.setText("***");
        getContentPane().add(LGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        fondo.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Anner\\Documents\\imagenes\\fondoConsola.png")); // NOI18N
        fondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void btnInciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInciarActionPerformed
         
         dibujaElPokemonQueEstaEnLaPosicion(contador);
         metodo.TraerInformacion(contador);
         metodo.asignar(Lnombre, Laltura, Lpeso, Lespecie, Lcolor, Lhabitad, Lexperiencia, Lid, LGeneracion);
         contador++;

     }//GEN-LAST:event_btnInciarActionPerformed

     private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
         contador--;
         dibujaElPokemonQueEstaEnLaPosicion(contador);
         metodo.TraerInformacion(contador);
         metodo.asignar(Lnombre, Laltura, Lpeso, Lespecie, Lcolor, Lhabitad, Lexperiencia, Lid, LGeneracion);
         //contador--;
     }//GEN-LAST:event_btnRetrocederActionPerformed

     private void btnAgfavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgfavActionPerformed
         // TODO add your handling code here:  
         mu.setCorreo(mu.getCorreo());
         m.setId(Integer.valueOf(Lid.getText()));
         g.FavoritosAg(m, mu);
     }//GEN-LAST:event_btnAgfavActionPerformed

    private void btneliminarfavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarfavActionPerformed
        // TODO add your handling code here:
        g.FavoritosEl(Lid);
        
    }//GEN-LAST:event_btneliminarfavActionPerformed
    
    private void resultadoEncontrado(ResultSet rs) {
        try {
            Lid.setText(rs.getString(1));
            Lnombre.setText(rs.getString(2));
            Laltura.setText(rs.getString(10));
            Lpeso.setText(rs.getString(11));
            Lespecie.setText(rs.getString(12));
            Lcolor.setText(rs.getString(13));
            Lhabitad.setText(rs.getString(15));
            Lexperiencia.setText(rs.getString(18));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    private void resultadoNoEncontrado(String relleno) {
        Lid.setText(relleno);
        Lnombre.setText(relleno);
        Laltura.setText(relleno);
        Lpeso.setText(relleno);
        Lespecie.setText(relleno);
        Lcolor.setText(relleno);
        Lhabitad.setText(relleno);
        Lexperiencia.setText(relleno);
        dibujaElPokemonQueEstaEnLaPosicion(-1);
    }
    
    private void llenarLabeles(ResultSet rs) {
        try {
            if (rs.next()) {
                resultadoEncontrado(rs);
            } else {
                resultadoNoEncontrado(dafault);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ResultSet rs = metodo.ejecutarConsulta(FieldBusqueda);
        llenarLabeles(rs);
        if (!Objects.equals(Lid.getText(), dafault)) {
            try {
                contador = Integer.valueOf(rs.getString(1));
                dibujaElPokemonQueEstaEnLaPosicion(contador - 1);
            } catch (SQLException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrosActionPerformed
        // TODO add your handling code here:
        
        Filtros filtro = new Filtros();
        filtro.setVisible(true);
    }//GEN-LAST:event_btnFiltrosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consola().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FieldBusqueda;
    private javax.swing.JLabel LGeneracion;
    private javax.swing.JLabel Laltura;
    private javax.swing.JLabel Lcolor;
    private javax.swing.JLabel Lespecie;
    private javax.swing.JLabel Lexperiencia;
    private javax.swing.JLabel Lhabitad;
    public javax.swing.JLabel Lid;
    private javax.swing.JLabel Lnombre;
    private javax.swing.JLabel Lpeso;
    private javax.swing.JPanel PokemonImagen;
    private javax.swing.JButton btnAgfav;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFiltros;
    private javax.swing.JButton btnInciar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btneliminarfav;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
