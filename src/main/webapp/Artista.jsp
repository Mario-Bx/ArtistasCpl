<%-- 
    Document   : Artista
    Created on : 15/11/2017, 10:32:06 AM
    Author     : LabingXEON
--%>
<%@page import="Dato.ArtistasCL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                <li><a href="SquemaIndex.jsp"><span class="dos"><img class="icon" src="ui/Imagenes/Esquema.png" /> </span>Esquemas</a></li>
                                <li><a href="TablaIndex.jsp"><span class="tres"><img class="icon" src="ui/Imagenes/Database-Table-icon.png" /> </span>Tablas</a></li>
                                <li><a href="ColumnaIndex.jsp"><span class="cuatro"><img class="icon" src="ui/Imagenes/Columna.png" /> </span>Columnas</a></li>
                            </ul>
                        </nav>
                    </header>                
                </div>

                <div class="form-style-5">
                    <%
                        ArtistasCL newSquema = (ArtistasCL) request.getAttribute("frmAddSquema");
                        if (request.getParameter("action").equals("incertarAc")) {
                    %>
                    <form method="POST" action='ArtistaClontroller' name="frmAddUser">
                        Cliente ID : <input type="text" readonly="readonly" name="clienteIdHtml"/>
                        <br /> 
                        Nombre Cliente : <input type="text" name="nombreHtml"/>
                        <br />
                        <input type="submit" value="Insertar" />
                    </form>
                    <%
                    } else if ((request.getParameter("action").equals("edit"))) {
                        ArtistasCL Squemas = (ArtistasCL) request.getAttribute("Cliente");
                    %>
                    <form method="POST" action='ArtistaController' name="frmAddSquema">
                        Cliente ID : <input type="text" readonly="readonly" name="clienteIdHtml" value="<%=Squemas.getId()%>"/>
                        <br /> 
                        Nombre Cliente : <input type="text" name="NombreHtml" value="<%=Squemas.getNombre()%>"/>
                        <input type="submit" value="Editar" />
                    </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>


    </body>
</html>
