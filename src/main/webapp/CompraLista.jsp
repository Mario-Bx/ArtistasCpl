<%-- 
    Document   : CompraLista
    Created on : 2/12/2017, 12:47:28 PM
    Author     : Mario-Bx
--%>

<%@page import="java.util.List"%>
<%@page import="Dato.CompraJc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Compras</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum.scale=1.0">
        <link rel="stylesheet" href="ui/Css/MenuDesplegableSub.css">
        <link rel="stylesheet" href="ui/Css/Etilo Fomulario.css">
    </head>

    <body>
        <div id="Centrar">
            <div id="Telon" align="center">
                <div class="Menu">
                    <header class="Menu_Des">
                        <input type="checkbox" id="btn_Menu">
                        <label for="btn_Menu"> <img class="icon"  src="ui/Imagenes/menu-icon.png"></label>
                        <nav class="MenuCss">
                            <ul>
                                <li><a href="index.jsp"><span class="uno"><img class="icon" src="ui/Imagenes/icon1.png" /></span>Inicio</a></li>
                                <li><a href="ArtistaIndex.jsp"><span class="uno"><img class="icon" src="ui/Imagenes/icon1.png" /></span>Artistas</a></li>
                                <li><a href="CompradoresIndex.jsp"><span class="dos"><img class="icon" src="ui/Imagenes/Esquema.png" /> </span>Compradores</a></li>
                                <li><a href="GaleriaIndex.jsp"><span class="tres"><img class="icon" src="ui/Imagenes/Database-Table-icon.png" /> </span>Galeria</a></li>
                                <li><a href="CompraIndex.jsp"><span class="cuatro"><img class="icon" src="ui/Imagenes/Columna.png" /> </span>Compras</a></li>
                            </ul>
                        </nav>
                    </header>                
                </div>

                <div class="form-style-5">
                    <a href="CompraControlador?action=incertarAc"><input type="submit" value="Agregar"/></a>
                    <table border=1>
                        <thead>
                            <tr>
                                <th>Compra Id</th>
                                <th>ID Comprador</th>
                                <th>ID Galeria</th>
                                <th>Pago</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<CompraJc> newListaO = (List<CompraJc>) request.getAttribute("ListaJsp");
                                if (newListaO != null) {
                                    for (CompraJc objeto : newListaO) {
                            %>
                            <tr>
                                <td><%=objeto.getID_Compra()%></td>
                                <td><%=objeto.getID_CompradorFK()%></td>
                                <td><%=objeto.getID_GaleriaFK()%></td>
                                <td><%=objeto.getID_MedioPagoFK()%></td>
                                <td><a href="CompraControlador?action=edit&JspAcID=<%=objeto.getID_Compra()%>">Aatualizar</a></td>
                                <td><a href="CompraControlador?action=delete&JspAcID=<%=objeto.getID_Compra()%>">Eliminar</a></td>
                            </tr>

                            <%
                                    }

                                }

                            %>

                        </tbody>
                    </table>

                </div>

            </div>
        </div>

    </body>
</html>
