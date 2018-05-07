<%-- 
    Document   : listaautori
    Created on : 5-mag-2018, 9.19.03
    Author     : Matteo
--%>

<%--
Questa jsp si occupa di stampare la lista degli autori in basso a sinistra della colonna laterale
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="ListaAutori Blog">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <div id="c_sotto">
        
        <h2><a class="hidden-link" href="scriviArticolo.html">Autori</a></h2>
        
        <ul>
            
            <c:forEach var="autore" items="${lista_autori}">
                
                <li>${autore.getName()}</li>
            
            </c:forEach>
            
        </ul>
        
    </div>
</html>
