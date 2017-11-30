/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ArtistaDao;
import Dato.ArtistasCL;
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
 * @author LabingXEON
 */
public class ArtistaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Artista.jsp";
    private static String LIST_USER = "/ArtistaLista.jsp";
    private ArtistaDao dao;

    public ArtistaController() throws URISyntaxException {
        super();
        dao = new ArtistaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            System.out.println("Entro a la accion eliminar");
            int clienteId = Integer.parseInt(request.getParameter("ClienteID"));
//            dao.deleteCliente(clienteId);
            forward = LIST_USER;
            ///primero va la tabla de sql
            request.setAttribute("ClienteBD", dao.getAllArtistas());
            System.out.println(" Realizo la accion de eliminar");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int clienteID = Integer.parseInt(request.getParameter("ClienteID"));
//            ClienteJc newCliente = dao.getClienteById(clienteID);
//            request.setAttribute("Cliente", newCliente);
        } else if (action.equalsIgnoreCase("ListarArtistasAC")) {
            forward = LIST_USER;
            request.setAttribute("ArtistasJSP", dao.getAllArtistas());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtistasCL newCliente = new ArtistasCL();
        newCliente.setNombre(request.getParameter("nombreHtml"));

        String clienteid = request.getParameter("clienteIdHtml");

        if (clienteid == null || clienteid.isEmpty()) {
            dao.addArtista(newCliente);
        } else {
            newCliente.setId(Integer.parseInt(clienteid));
            int clienteId = Integer.parseInt(request.getParameter("clienteIdHtml"));
//            dao.updateCliente(newCliente, clienteId);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("ArtistasJSP", dao.getAllArtistas());
        view.forward(request, response);
    }

}
