<%-- 
    Document   : listaCategorie
    Created on : 6-mag-2018, 1.13.00
    Author     : Matteo
--%>
<%--
Questa jsp si occupa di rendere dinamica la lista delle categorie e consente all'utente di scegliere se stampare
tutte le notizie o solo quelle per categorie.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="ListaCategorie">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <div id="c_sopra">
            
            <h2><a class="hidden-link" href="notizia.html">Categorie</a></h2>
            <ul id="listacategorie">

                <li><a href="notizie.html?category=Politica">Politica</a></li>
                <li><a href="notizie.html?category=Cronaca">Cronaca</a></li>
                <li><a href="notizie.html?category=Esteri">Esteri</a></li>
                <li><a href="notizie.html?category=Economia">Economia</a></li>
                <li><a href="notizie.html?category=Sport">Sport</a></li>
                <li><a href="notizie.html?category=Cultura">Cultura</a></li>
                <li><a href="notizie.html?category=Cucina">Cucina</a></li>
                <li><a href="notizie.html?category=Tutte">Tutte</a></li>

            </ul>
            
        </div>
        
    </body>
    
</html>
