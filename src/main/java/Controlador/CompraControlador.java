/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CompraDao;
import Dato.CompraJc;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario-Bx
 */
public class CompraControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Compra.jsp";
    private static String LIST_USER = "/CompraLista.jsp";
    private CompraDao dao;

    public CompraControlador() throws URISyntaxException {
        super();
        dao = new CompraDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            System.out.println("Entro a la accion");
            int variableID = Integer.parseInt(request.getParameter("JspAcID"));
            dao.delete(variableID);
            forward = LIST_USER;
            ///(Parametro jsp),(Metodo Para el Parametro)
            request.setAttribute("ListadoJsp", dao.getAll());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int variableID = Integer.parseInt(request.getParameter("JspAcID"));
            CompraJc tabla = dao.getById(variableID);
            ///primero va la tabla de sql
            request.setAttribute("TablaJsp", tabla);
        } else if (action.equalsIgnoreCase("ListarDatosJspAC")) {
            forward = LIST_USER;
            request.setAttribute("ListaJsp", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompraJc newObjeto = new CompraJc();
        newObjeto.setID_CompradorFK(Integer.parseInt(request.getParameter("FkCompradorHtml")));
        newObjeto.setID_GaleriaFK(Integer.parseInt(request.getParameter("FkGaleriaHtml")));
        newObjeto.setID_MedioPagoFK(Integer.parseInt(request.getParameter("FkMedioHtml")));

        String variableID = request.getParameter("IdBDHtml");

        if (variableID == null || variableID.isEmpty()) {
            dao.add(newObjeto);
        } else {
            newObjeto.setID_Compra(Integer.parseInt(variableID));
            int variableID2 = Integer.parseInt(request.getParameter("IdBDHtml"));
            dao.update(newObjeto, variableID2);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("TablaListaJsp", dao.getAll());
        view.forward(request, response);
    }

}
