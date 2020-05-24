/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pietrodeocre
 */
public class ClienteDaoJDBC {
    
    
    /*
    Variables estaticas que contienen las acciones a la base de datos
    */
    private static final String SQL_SELECT = "SELECT * FROM cliente";
    
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cliente WHERE id_cliente = ?";
    
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, telefono, saldo)"
            + " VALUES(?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE cliente "
            + "SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
    
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    public List<Cliente> listar() {

        //Preparamos las variables que necesitamos para la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        //Creamos una para contener los objetos de tipo cliente
        List<Cliente> clientes = new ArrayList<>();
        try {
            //Iniciamos nuestra conexion
            conn = Conexion.getConnection();
            //Inicializamos el metodo statement para dar la sentencia sql que vamso a usar
            stmt = conn.prepareStatement(SQL_SELECT);
            //Inicializamos rs para recivir los resultados
            rs = stmt.executeQuery();
            //iteramos los elementos del rs
            while(rs.next()){
                //Recuperamos cada uno de los campos por su nombre
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                //Creamos el objeto cliente 
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                //Lo añadimos a la lista de clientes
                clientes.add(cliente);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            //Cerramos conexiones
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
        
    }
    
    public Cliente encontrar(Cliente cliente) {

        //Preparamos las variables que necesitamos para la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            //Iniciamos nuestra conexion
            conn = Conexion.getConnection();
            //Inicializamos el metodo statement para dar la sentencia sql que vamso a usar
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            
            stmt.setInt(1, cliente.getIdCliente());

            //Inicializamos rs para recivir los resultados
            rs = stmt.executeQuery();

            //Si existe nuestro cliente id nos posicionamos en el primer registro
            //Y nos aseguramos que siempre recivimos un solo registro
            rs.absolute(1);
            
            //Recuperamos cada uno de los campos por su nombre
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");
            //Creamos el objeto cliente 
            cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
        
    }
    
    public int insertar(Cliente cliente){
        
        
        //Preparamos las variables que necesitamos para la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            //Iniciamos nuestra conexion
            conn = Conexion.getConnection();
            //Inicializamos el metodo statement para dar la sentencia sql que vamso a usar
            stmt = conn.prepareStatement(SQL_INSERT);
            
            /*
            Cuando antes pusimos los ? en las sentencias SQL de las variables estaticas
            pues esos ? ahora corresponden al primer parametro de los set siguientes
            por eso proporcionamos la posicion en que deben colocar los parametros
            dentro de la sentencia sql con los ? por ejemplo
            INSERT INTO cliente (nombre, apellido, telefono, saldo)VALUES(?, ?, ?, ?, ?)
            el primer ? de VALUES corresponde al stmt.setString(1, cliente.getNombre())
            Por que pusimos que iba en la posicion 1
            */
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
        
    }
    
    public int actualizar(Cliente cliente){
        
        //Preparamos las variables que necesitamos para la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            //Iniciamos nuestra conexion
            conn = Conexion.getConnection();
            //Inicializamos el metodo statement para dar la sentencia sql que vamso a usar
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            /*
            Cuando antes pusimos los ? en las sentencias SQL de las variables estaticas
            pues esos ? ahora corresponden al primer parametro de los set siguientes
            */
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;

    }
    
    public int eliminar(Cliente cliente){
        
        //Preparamos las variables que necesitamos para la conexion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            //Iniciamos nuestra conexion
            conn = Conexion.getConnection();
            //Inicializamos el metodo statement para dar la sentencia sql que vamso a usar
            stmt = conn.prepareStatement(SQL_DELETE);
            
            //Añadimos parametro del id a borrar
            stmt.setInt(1, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
        
    }

}
