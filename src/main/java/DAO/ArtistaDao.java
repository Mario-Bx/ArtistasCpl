/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.ArtistasCL;
import Servicios.*;
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
 * @author LabingXEON
 */
public class ArtistaDao {

    private Connection connection;

    public ArtistaDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void add(ArtistasCL newclArturoJc) {
        try {
            /// sentencia para insertar en la tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into ArtistasBD(Nombre) values (?)");
            // parametros de inicio para agregar...
            preparedStatement.setString(1, newclArturoJc.getNombre());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int TablaDl) {
        try {
            System.out.println("Entro a eliminar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from ArtistasBD where ID_Artistas=?");
            // Parameters start with 1
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ArtistasCL tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update ArtistasBD set Nombre=? where ID_Artistas=" + cs);
            // Parameters start with 1
            preparedStatement.setString(1, tablaUP.getNombre());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ArtistasCL> getAll() {
        List<ArtistasCL> artistaListas = new ArrayList<ArtistasCL>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from ArtistasBD");

            while (rs.next()) {
                ArtistasCL newclClienteJc = new ArtistasCL();
                newclClienteJc.setId(rs.getInt("ID_Artistas"));
                newclClienteJc.setNombre(rs.getString("nombre"));

                artistaListas.add(newclClienteJc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artistaListas;
    }

    public ArtistasCL getById(int artistaId) {
        ArtistasCL newclClienteJc = new ArtistasCL();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from ArtistasBD where ID_Artistas=?");
            preparedStatement.setInt(1, artistaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                newclClienteJc.setId(rs.getInt("ID_Artistas"));
                newclClienteJc.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newclClienteJc;
    }

}
