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

    public ResultSet generarCBContato() {
        try {
            PreparedStatement sentencia = con.prepareStatement("SELECT * "
                    + "FROM tipocontrato ");
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void agregar(int cedula, String nombre, String apellido, String telf, String salario, int tipoContrato) {
        try {
            PreparedStatement sentencia = con.prepareStatement("INSERT INTO empleado "
                    + "VALUES(?,?,?,?,?,?)");
            sentencia.setInt(1, cedula);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setString(4, telf);
            sentencia.setString(5, salario);
            sentencia.setInt(6, tipoContrato);

//            ResultSet listado = sentencia.executeQuery();
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha agregado con exito");

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al agregar al empleado");
        }

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

    public void modificar(int cedula, String nombre, String apellido, String telf, String salario) {
        try {
            PreparedStatement sentencia = con.prepareStatement("UPDATE empleado SET "
                    + "nombre = ?,"
                    + "apellido = ?,"
                    + "telefono = ?,"
                    + "salario = ?"                    
                    + "WHERE cedula = ?");

            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, telf);
            sentencia.setString(4, salario);           
            sentencia.setInt(5, cedula);

            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente :)");

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Fallo al actualizar los datos :(");
        }
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
