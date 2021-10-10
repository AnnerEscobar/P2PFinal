package Metodos;

import Conexion.Conexion;
import com.itextpdf.text.Document;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class Correo {

    public void EnviarC() throws AddressException, MessagingException, IOException {
        String correo = "aescobarc13@miumg.edu.gt";
        String contra = "$5J/Cs94";
        String correoDestino = "anner123escobar@gmail.com";

        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);
        MimeMessage mensaje = new MimeMessage(s);
        BodyPart texto = new MimeBodyPart();
        texto.setText("Correo enviado desde java");
        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.attachFile("C:\\Users\\Anner\\Documents\\imagen\\Nomina_Empleados.pdf");
        //adjunto.setFileName("Nomina_Empleadods.pdf");
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(texto);
        m.addBodyPart(adjunto);

        mensaje.setFrom(new InternetAddress(correo));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
        mensaje.setSubject("REPORTE DE LOS POKEMON");
        mensaje.setContent(m);

        Transport t = s.getTransport("smtp");

        t.connect(correo, contra);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
        JOptionPane.showMessageDialog(null, "Correcto");
    }

    public boolean GenerarPdf() {
        boolean correcto = true;

        Document doc = new Document();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String rutaArchivo = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(rutaArchivo + "/Documents/imagen/Nomina_Empleados.pdf"));
            doc.open();

            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Name");
            tabla.addCell("generation_id");
            tabla.addCell("height");
            tabla.addCell("species");
            tabla.addCell("habitat");
            tabla.addCell("capture_rate");
            tabla.addCell("base_happiness");

            try {
                conn = Conexion.OpenConection();
                stmt = conn.prepareStatement("Select *from pokemon");
                rs = stmt.executeQuery();

                while (rs.next()) {

                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(5));
                    tabla.addCell(rs.getString(10));
                    tabla.addCell(rs.getString(12));
                    tabla.addCell(rs.getString(15));
                    tabla.addCell(rs.getString(17));
                    tabla.addCell(rs.getString(19));

                }
                doc.add(tabla);
                doc.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Conexion Fallida " + e);
            } finally {
                Conexion.CloseConection(stmt);
                Conexion.CloseConection(conn);
                Conexion.CloseConection(rs);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tu reporte no fue generado " + e);
        }
        return correcto;
    }
}
