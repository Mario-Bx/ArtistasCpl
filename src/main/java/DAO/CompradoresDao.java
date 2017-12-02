/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.CompradoresJC;
import Servicios.Conexion;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario-Bx
 */
public class CompradoresDao {

    private Connection connection;

    public CompradoresDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void add(CompradoresJC tablaAdd) {
        try {
            System.out.println("Entro a Agregar");
            //se declara la consulta de Insercion en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into CompradoresBD(nombre) values (?)");
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setString(1, tablaAdd.getNombre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int TablaDl) {
        try {
            System.out.println("Entro a eliminar");
            //se declara la consulta de Eliminar en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from CompradoresBD where ID_Compradores=?");
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CompradoresJC tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            //se declara la consulta de Actualizar en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update CompradoresBD set nombre=? where ID_Compradores=" + cs);
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setString(1, tablaUP.getNombre());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CompradoresJC> getAll() {
        List<CompradoresJC> tablaLista = new ArrayList<CompradoresJC>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from CompradoresBD");
            while (rs.next()) {
                CompradoresJC tablaLI = new CompradoresJC();
                tablaLI.setID_Compradores(rs.getInt("ID_Compradores"));
                tablaLI.setNombre(rs.getString("nombre"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaLista;
    }

    public CompradoresJC getById(int tablaId) {
        CompradoresJC tabla = new CompradoresJC();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from CompradoresBD where ID_Compradores=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setID_Compradores(rs.getInt("ID_Compradores"));
                tabla.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tabla;
    }

}
