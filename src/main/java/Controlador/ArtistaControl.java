/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ArtistaDao;
import Dato.ArtistasCL;
import java.io.IOException;
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
public class ArtistaControl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Artista.jsp";
    private static String LIST_USER = "/ArtistasLista.jsp";
    private ArtistaDao dao;

    public ArtistaControl() throws URISyntaxException {
        super();
        dao = new ArtistaDao();
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
            request.setAttribute("ListaJsp", dao.getAll());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int variableID = Integer.parseInt(request.getParameter("JspAcID"));
            ArtistasCL tabla = dao.getById(variableID);
            ///primero va la tabla de sql
            request.setAttribute("JspED", tabla);
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
        ArtistasCL newObjeto = new ArtistasCL();
        newObjeto.setNombre(request.getParameter("NombreHtml"));

        String variableID = request.getParameter("IdBDHtml");

        if (variableID == null || variableID.isEmpty()) {
            dao.add(newObjeto);
        } else {
            newObjeto.setId(Integer.parseInt(variableID));
            int variableID2 = Integer.parseInt(request.getParameter("IdBDHtml"));
            dao.update(newObjeto, variableID2);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("ListaJsp", dao.getAll());
        view.forward(request, response);
    }
}
