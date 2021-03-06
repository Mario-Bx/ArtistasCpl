<%-- 
    Document   : Compradores
    Created on : 2/12/2017, 09:30:16 PM
    Author     : Mario-Bx
--%>

<%@page import="Dato.CompradoresJC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EDA Comprador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum.scale=1.0">
        <link rel="stylesheet" href="ui/Css/MenuDesplegableSub.css">
        <link rel="stylesheet" href="ui/Css/Etilo Fomulario.css">
    </head>

    <body>
        <div id="Centrar">
            <div id="Telon" align="center">
                <div class="Menu">
                    <a href="Cliente.jsp"></a>
                    <header class="Menu_Des">
                        <input type="checkbox" id="btn_Menu">
                        <label for="btn_Menu"> <img class="icon"  src="ui/Imagenes/menu-icon.png"></label>
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
                    </header>                
                </div>

                <div class="form-style-5">
                    <%
                        CompradoresJC newObjetoIC = (CompradoresJC) request.getAttribute("frmAddSquema");
                        if (request.getParameter("action").equals("incertarAc")) {
                    %>
                    <form method="POST" action='CompradoresControlador' name="frmAddUser">
                        Compra ID : <input type="text" readonly="readonly" name="IdBDHtml"/>
                        <br /> 
                        ID Comprador : <input type="text" name="NombreHtml"/>
                        <br />
                        <input type="submit" value="Insertar" />
                    </form>


                    <%
                    } else if ((request.getParameter("action").equals("edit"))) {
                        CompradoresJC newObjetoEd = (CompradoresJC) request.getAttribute("JspED");
                    %>
                    <form method="POST" action='CompradoresControlador' name="frmAddSquema">
                        Comprador ID : <input type="text" readonly="readonly" name="IdBDHtml" value="<%=newObjetoEd.getID_Compradores()%>"/>
                        <br /> 
                        Nombre : <input type="text" name="NombreHtml" value="<%=newObjetoEd.getNombre()%>"/>
                        <br />
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
