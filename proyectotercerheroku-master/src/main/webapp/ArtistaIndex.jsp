<%-- 
    Document   : ArtistaIndex
    Created on : 15/11/2017, 10:24:02 AM
    Author     : LabingXEON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Artista</title>
    </head>
    <body>
        <jsp:forward page="ArtistaController?action=ListarArtistasAC" />
    </body>
</html>
