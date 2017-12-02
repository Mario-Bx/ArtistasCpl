/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dato.MedioPagoJc;
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
public class MedioPagoDao {

    private Connection connection;

    public MedioPagoDao() throws URISyntaxException {
        connection = Conexion.getConnection();
    }

    public void add(MedioPagoJc tablaAdd) {
        try {
            System.out.println("Entro a Agregar");
            //se declara la consulta de Insercion en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into MedioPagoBD(nombre) values (?)");
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setString(2, tablaAdd.getNombre());
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
                    .prepareStatement("delete from MedioPagoBD where ID_Medio=?");
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setInt(1, TablaDl);
            preparedStatement.executeUpdate();
            System.out.println("Elimino La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(MedioPagoJc tablaUP, int cs) {
        try {
            System.out.println("Entro a Acturalizar");
            //se declara la consulta de Actualizar en la respectiva tabla
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update MedioPagoBD set nombre=? where ID_Medio=" + cs);
            ///Cada "?" lleva su indice consecutivo
            preparedStatement.setString(2, tablaUP.getNombre());
            preparedStatement.executeUpdate();
            System.out.println("Actualizo La Tabla");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MedioPagoJc> getAll() {
        List<MedioPagoJc> tablaLista = new ArrayList<MedioPagoJc>();
        try {
            System.out.println("Emplezando a Listar");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from MedioPagoBD");
            while (rs.next()) {
                MedioPagoJc tablaLI = new MedioPagoJc();
                tablaLI.setID_Medio(rs.getInt("ID_Medio"));
                tablaLI.setNombre(rs.getString("ID_ArtistaFK"));
                tablaLista.add(tablaLI);
            }
            System.out.println("Se Termino de  Listar");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tablaLista;
    }

    public MedioPagoJc getById(int tablaId) {
        MedioPagoJc tabla = new MedioPagoJc();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from MedioPagoBD where ID_Medio=?");
            preparedStatement.setInt(1, tablaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                tabla.setID_Medio(rs.getInt("ID_Medio"));
                tabla.setNombre(rs.getString("ID_ArtistaFK"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tabla;
    }

}
