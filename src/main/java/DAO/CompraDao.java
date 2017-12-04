/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.CompraJc;
import Dato.CompradoresJC;
import Dato.GaleriaJc;
import Dato.MedioPagoJc;
import Servicios.Conexion;
import Servicios.DbUtil;
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
public class CompraDao {

    private Connection connection;

    public CompraDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void add(CompraJc tablaAdd) {
        try {
            System.out.println("Entro a Agregar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into CompraBD(ID_CompradorFK, ID_GaleriaFK, ID_MedioPagoFK) values (?,?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1, tablaAdd.getID_CompradorFK());
            preparedStatement.setInt(2, tablaAdd.getID_GaleriaFK());
            preparedStatement.setInt(3, tablaAdd.getID_MedioPagoFK());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int TablaDl) {
        try {
            System.out.println("Entro a eliminar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from CompraBD where ID_Compra=?");
            // Parameters start with 1
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CompraJc tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update CompraBD set ID_CompradorFK=?, ID_GaleriaFK=?, ID_MedioPagoFK=? where ID_Compra=" + cs);
            // Parameters start with 1
            preparedStatement.setInt(1, tablaUP.getID_CompradorFK());
            preparedStatement.setInt(2, tablaUP.getID_GaleriaFK());
            preparedStatement.setInt(3, tablaUP.getID_MedioPagoFK());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CompraJc> getAll() {
        List<CompraJc> tablaLista = new ArrayList<CompraJc>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from CompraBD");
            while (rs.next()) {
                CompraJc tablaLI = new CompraJc();
                tablaLI.setID_Compra(rs.getInt("ID_Compra"));
                tablaLI.setID_CompradorFK(rs.getInt("ID_CompradorFK"));
                tablaLI.setID_GaleriaFK(rs.getInt("ID_GaleriaFK"));
                tablaLI.setID_MedioPagoFK(rs.getInt("ID_MedioPagoFK"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaLista;
    }

    public CompraJc getById(int tablaId) {
        CompraJc tabla = new CompraJc();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from CompraBD where ID_Compra=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setID_Compra(rs.getInt("ID_Compra"));
                tabla.setID_CompradorFK(rs.getInt("ID_CompradorFK"));
                tabla.setID_GaleriaFK(rs.getInt("ID_GaleriaFK"));
                tabla.setID_MedioPagoFK(rs.getInt("ID_MedioPagoFK"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tabla;
    }

    public List<CompradoresJC> getAllComprador() {
        List<CompradoresJC> squemaLista = new ArrayList<CompradoresJC>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from CompradoresBD");
            while (rs.next()) {
                CompradoresJC squema = new CompradoresJC();
                squema.setID_Compradores(rs.getInt("ID_Compradores"));
                squema.setNombre(rs.getString("nombre"));
                squemaLista.add(squema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return squemaLista;
    }

    public List<GaleriaJc> getAllGaleria() {
        List<GaleriaJc> squemaLista = new ArrayList<GaleriaJc>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from GaleriaBD");
            while (rs.next()) {
                GaleriaJc squema = new GaleriaJc();
                squema.setID_Galeria(rs.getInt("ID_Galeria"));
                squema.setNombre(rs.getString("nombre"));
                squemaLista.add(squema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return squemaLista;
    }

    public List<MedioPagoJc> getAllPago() {
        List<MedioPagoJc> squemaLista = new ArrayList<MedioPagoJc>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from MedioPagoBD");
            while (rs.next()) {
                MedioPagoJc squema = new MedioPagoJc();
                squema.setID_Medio(rs.getInt("ID_Medio"));
                squema.setNombre(rs.getString("nombre"));
                squemaLista.add(squema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return squemaLista;
    }

}
