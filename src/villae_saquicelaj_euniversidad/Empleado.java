/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package villae_saquicelaj_euniversidad;

import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonna
 */
public class Empleado {

    private Connection con;
    private String contrasena;

    public boolean conectar() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", contrasena);
            JOptionPane.showMessageDialog(null, "Se ha conectado");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al ingresar con la base de datos");
            return false;
        }
    }

    public ResultSet agregar() {
        try {
            PreparedStatement sentencia = con.prepareStatement("SELECT * "
                    + "FROM Revista "
                    + "where id_Revista = ?");
            //sentencia.setInt(1, idRevista);
            ResultSet listado = sentencia.executeQuery();

            /*while(listado.next())
            {
                System.out.println (listado.getString("titulo"));
            }*/
            return listado;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet buscarEmpleado(int cedula) {

        try {
            PreparedStatement sentencia = con.prepareStatement("SELECT * "
                    + "FROM Empleado "
                    + "where cedula = ?");
            sentencia.setInt(1, cedula);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
