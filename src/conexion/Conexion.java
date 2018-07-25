/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection cnx;
    private boolean conect = false;

    public void Conectar() {
        try {
            String driver = "org.postgresql.Driver";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:postgresql://localhost:5432/PruebasLocal";
            Properties info = new Properties();
            info.setProperty("user", "postgres");
            info.setProperty("password", "postgres");
            cnx = DriverManager.getConnection(url, info);
        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "1. La base de datos no se encuentra lista",
                  "Error de Base de Datos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.err.println("-----------SQLException------------\n");
            System.err.println("Mensaje:" + e.getMessage());
            System.err.println("Estado SQL:" + e.getSQLState());
            System.err.println("Codigo de Error:" + e.getErrorCode());
        }
    }

    public void CloseConection() {
        try {
            cnx.close();
            conect = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConectado() {
        return conect;
    }

    public Connection getConexion() {
        return this.cnx;
    }
}