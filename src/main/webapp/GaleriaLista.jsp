<%-- 
    Document   : GaleriaLista
    Created on : 2/12/2017, 10:22:22 PM
    Author     : Mario-Bx
--%>

<%@page import="Dato.GaleriaJc"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Galeria</title>
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
                    <a href="GaleriaControl?action=incertarAc"><input type="submit" value="Agregar"/></a>
                    <table border=1>
                        <thead>
                            <tr>
                                <th>Galeria Id</th>
                                <th>ID Artista</th>
                                <th>Nombre obra</th>
                                <th>Estilo</th>
                                <th>Tecnica</th>
                                <th>Valor</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<GaleriaJc> newListaO = (List<GaleriaJc>) request.getAttribute("ListaJsp");
                                if (newListaO != null) {
                                    for (GaleriaJc objeto : newListaO) {
                            %>
                            <tr>
                                <td><%=objeto.getID_Galeria()%></td>
                                <td><%=objeto.getID_ArtistaFK()%></td>
                                <td><%=objeto.getNombre()%></td>
                                <td><%=objeto.getEstilo()%></td>
                                <td><%=objeto.getTecnica()%></td>
                                <td><%=objeto.getValor()%></td>
                                <td><a href="GaleriaControl?action=edit&JspAcID=<%=objeto.getID_Galeria()%>">Aatualizar</a></td>
                                <td><a href="GaleriaControl?action=delete&JspAcID=<%=objeto.getID_Galeria()%>">Eliminar</a></td>
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
