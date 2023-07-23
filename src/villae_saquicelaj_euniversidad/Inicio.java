/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package villae_saquicelaj_euniversidad;

/**
 *
 * @author Jonna
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VentanaCarga vCarga = new VentanaCarga();
        VentanaEmpleadosU vEmpleados = new VentanaEmpleadosU();
        Empleado empleado = new Empleado();
        
        vCarga.setvEmpleados(vEmpleados);
        vCarga.setVisible(true);
        vEmpleados.setEmpleado(empleado);       
        
    }
    
}
