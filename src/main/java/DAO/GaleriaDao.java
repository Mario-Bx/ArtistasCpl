/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.ArtistasCL;
import Dato.GaleriaJc;
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
public class GaleriaDao {

    private Connection connection;

    public GaleriaDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void add(GaleriaJc tablaAdd) {
        try {
            System.out.println("Entro a Agregar");
            //se declara la consulta de Insercion en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into GaleriaBD(ID_ArtistaFK, nombre, estilo, tecnica, Valor) values (?,?,?,?,?)");
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setInt(1, tablaAdd.getID_ArtistaFK());
            preparedStatement.setString(2, tablaAdd.getNombre());
            preparedStatement.setString(3, tablaAdd.getEstilo());
            preparedStatement.setString(4, tablaAdd.getTecnica());
            preparedStatement.setInt(5, tablaAdd.getValor());
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
                    .prepareStatement("delete from GaleriaBD where ID_Galeria=?");
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(GaleriaJc tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            //se declara la consulta de Actualizar en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update GaleriaBD set ID_ArtistaFK=?, nombre=?, estilo=?, tecnica=?, Valor where ID_Galeria=" + cs);
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setInt(1, tablaUP.getID_ArtistaFK());
            preparedStatement.setString(2, tablaUP.getNombre());
            preparedStatement.setString(3, tablaUP.getEstilo());
            preparedStatement.setString(4, tablaUP.getTecnica());
            preparedStatement.setInt(5, tablaUP.getValor());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GaleriaJc> getAll() {
        List<GaleriaJc> tablaLista = new ArrayList<GaleriaJc>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from GaleriaBD");
            while (rs.next()) {
                GaleriaJc tablaLI = new GaleriaJc();
                tablaLI.setID_Galeria(rs.getInt("ID_Galeria"));
                tablaLI.setNombre(rs.getString("ID_ArtistaFK"));
                tablaLI.setEstilo(rs.getString("nombre"));
                tablaLI.setTecnica(rs.getString("estilo"));
                tablaLI.setTecnica(rs.getString("tecnica"));
                tablaLI.setValor(rs.getInt("Valor"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tablaLista;
    }

    public GaleriaJc getById(int tablaId) {
        GaleriaJc tabla = new GaleriaJc();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from GaleriaBD where ID_Galeria=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setID_Galeria(rs.getInt("ID_Galeria"));
                tabla.setNombre(rs.getString("ID_ArtistaFK"));
                tabla.setEstilo(rs.getString("nombre"));
                tabla.setTecnica(rs.getString("estilo"));
                tabla.setTecnica(rs.getString("tecnica"));
                tabla.setValor(rs.getInt("Valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tabla;
    }

    public List<ArtistasCL> getAllArtistas() {
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

}
