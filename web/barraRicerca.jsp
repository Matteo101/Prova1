<%-- 
    Document   : barraRicerca
    Created on : 6-mag-2018, 8.44.34
    Author     : Matteo
--%>
<%--
Questa jsp si occupa di mostrare la barra di ricerca in alto a sinistra nella pagina.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="BarraRicerca Blog">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    
    
    <body>
        <div class="barraricerca">
            <label for="cerca"></label>
            <input type="text" name="cerca" id="cerca" value="Cerca..">
        </div>
    </body>
    
    
    
</html>
