<%-- 
    Document   : CompradoresIndex
    Created on : 2/12/2017, 09:14:11 PM
    Author     : Mario-Bx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Index</title>
    </head>
    <body>
        <jsp:forward page="/CompradoresControlador?action=ListarDatosJspAC" />
    </body>
</html>
