<%-- 
    Document   : index
    Created on : 24-apr-2018, 16.38.56
    Author     : Matteo
--%>

<%--
Questa jsp si occupa di visualizzare la schermata di benvenuto al sito.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Benvenuto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Pagina Indirizza Login">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
    </head>
    
    <body>
        <jsp:include page="header.jsp" />
        <div id="schermata-index">
            <h1 id="titolo-index">Benvenuto</h1>
            <p>Per accedere al sito clicca il bottone qua sotto:</p>
            <form action="login.html" method="post">
                <button id="go-to-login" type="submit">Go to Login</button>
            </form>
        </div>
    </body>
</html>