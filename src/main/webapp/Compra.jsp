<%-- 
    Document   : Compra
    Created on : 2/12/2017, 07:42:13 PM
    Author     : Mario-Bx
--%>

<%@page import="Dato.MedioPagoJc"%>
<%@page import="Dato.CompradoresJC"%>
<%@page import="Dato.GaleriaJc"%>
<%@page import="java.util.List"%>
<%@page import="Dato.CompraJc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AED Compras</title>
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
                        CompraJc newObjetoIC = (CompraJc) request.getAttribute("frmAddSquema");
                        if (request.getParameter("action").equals("incertarAc")) {
                    %>
                    <form method="POST" action='CompraControlador' name="frmAddUser">
                        Compra ID : <input type="text" readonly="readonly" name="IdBDHtml"/>
                        <br /> 
                        ID Comprador : 
                        <SELECT name="FkCompradorHtml" SIZE="1"> 
                            <%
                                List<CompradoresJC> objetoLt = (List<CompradoresJC>) request.getAttribute("compradorJsp");
                                if (objetoLt != null) {
                                    for (CompradoresJC objeto : objetoLt) {
                            %>
                            <OPTION VALUE="<%=objeto.getID_Compradores()%>"><%=objeto.getNombre()%></OPTION> 
                                <%
                                        }
                                    }
                                %>
                        </SELECT>
                        <br />
                        ID Obra :
                        <SELECT name="FkGaleriaHtml" SIZE="1"> 
                            <%
                                List<GaleriaJc> objetoGL = (List<GaleriaJc>) request.getAttribute("galeriaJsp");
                                if (objetoLt != null) {
                                    for (GaleriaJc objetog : objetoGL) {
                            %>
                            <OPTION VALUE="<%=objetog.getID_Galeria()%>"><%=objetog.getNombre()%></OPTION> 
                                <%
                                        }
                                    }
                                %>
                        </SELECT>
                        <br />
                        Pago :
                        <SELECT name="FkMedioHtml" SIZE="1"> 
                            <%
                                List<MedioPagoJc> objetoMP = (List<MedioPagoJc>) request.getAttribute("pagoJsp");
                                if (objetoMP != null) {
                                    for (MedioPagoJc objetoMp : objetoMP) {
                            %>
                            <OPTION VALUE="<%=objetoMp.getID_Medio()%>"><%=objetoMp.getNombre()%></OPTION> 
                                <%
                                        }
                                    }
                                %>
                            <br />
                            <input type="submit" value="Insertar" />
                    </form>


                    <%
                    } else if ((request.getParameter("action").equals("edit"))) {
                        CompraJc newObjetoEd = (CompraJc) request.getAttribute("JspED");
                    %>
                    <form method="POST" action='CompraControlador' name="frmAddSquema">
                        Compra ID : <input type="text" readonly="readonly" name="IdBDHtml" value="<%=newObjetoEd.getID_Compra()%>"/>
                        <br /> 
                        ID Comprador :
                        <SELECT name="FkCompradorHtml" SIZE="1"> 
                            <%
                                List<CompradoresJC> objetoLT = (List<CompradoresJC>) request.getAttribute("compradorJsp");
                                if (objetoLT != null) {
                                    for (CompradoresJC objetoLt1 : objetoLT) {
                                        if (newObjetoEd.getID_CompradorFK() == objetoLt1.getID_Compradores()) {
                            %>
                            <OPTION VALUE="<%=objetoLt1.getID_Compradores()%>">(<%=objetoLt1.getNombre()%>)</OPTION> 
                                <%
                                        }
                                    }
                                    for (CompradoresJC objetoLt2 : objetoLT) {
                                %>
                            <OPTION VALUE="<%=objetoLt2.getID_Compradores()%>"><%=objetoLt2.getNombre()%></OPTION> 
                                <%

                                        }
                                    }
                                %>
                        </SELECT>
                        <br />
                        ID Obra :
                        <SELECT name="FkGaleriaHtml" SIZE="1"> 
                            <%
                                List<GaleriaJc> objetoGL = (List<GaleriaJc>) request.getAttribute("galeriaJsp");
                                if (objetoGL != null) {
                                    for (GaleriaJc objetoGl1 : objetoGL) {
                                        if (newObjetoEd.getID_GaleriaFK()== objetoGl1.getID_Galeria()) {
                            %>
                            <OPTION VALUE="<%=objetoGl1.getID_Galeria()%>">(<%=objetoGl1.getNombre()%>)</OPTION> 
                                <%
                                        }
                                    }
                                    for (GaleriaJc objetoGl2 : objetoGL) {
                                %>
                            <OPTION VALUE="<%=objetoGl2.getID_Galeria()%>"><%=objetoGl2.getNombre()%></OPTION> 
                                <%

                                        }
                                    }
                                %>
                        </SELECT>
                        <br />
                        Pago : 
                        <SELECT name="FkMedioHtml" SIZE="1"> 
                            <%
                                List<MedioPagoJc> objetoMP = (List<MedioPagoJc>) request.getAttribute("pagoJsp");
                                if (objetoMP != null) {
                                    for (MedioPagoJc objetoMp1 : objetoMP) {
                                        if (newObjetoEd.getID_GaleriaFK()== objetoMp1.getID_Medio()) {
                            %>
                            <OPTION VALUE="<%=objetoMp1.getID_Medio()%>">(<%=objetoMp1.getNombre()%>)</OPTION> 
                                <%
                                        }
                                    }
                                    for (MedioPagoJc objetoMp2 : objetoMP) {
                                %>
                            <OPTION VALUE="<%=objetoMp2.getID_Medio()%>"><%=objetoMp2.getNombre()%></OPTION> 
                                <%

                                        }
                                    }
                                %>
                        </SELECT>
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