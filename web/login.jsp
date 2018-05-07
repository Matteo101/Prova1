<%-- 
    Document   : Login
    Created on : 20-apr-2018, 11.26.23
    Author     : Matteo
--%>

<%--
Questa jsp si occupa di acquisire i dati email e password inseriti dall`utente e eventualmente stampare un messaggio di errore
inoltre e` possibile guardare le notizie per categoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
    
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Pagina Login Utente">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <jsp:include page="header.jsp" />
        
        <div class="barranavigazione">
            
            <nav>
                <a href="login.html">Login</a>
            </nav>
            
        </div>
       
        
        <aside class="columnside">
            
            <jsp:include page="barraRicerca.jsp" />
            <jsp:include page="listaCategorie.jsp" />
            <jsp:include page="listaautori.jsp" />

        </aside>
        
        <div class="middlecolumn">       
            <img id="logo" title="Logo" alt="Foto logo blog" src="https://image.freepik.com/icone-gratis/immagine-utente-con-sfondo-nero_318-34564.jpg"  
                 width="200" height="200">
            
            <c:if test="${invalidData == true}">
                        <p> Dati errati </p>
            </c:if>
                        
            <form action="login.html" method="post">
                
                <div class="schermatalogin">    
                    
                    <label class="labels" for="email">Email</label>
                    <input class="input" type="text" name="email" id="username" value="Inserisci email"/>
                    <br>
                    <label class="labels" for="password">Password</label>
                    <input class="input" type="password" name="password" id="password" />
                    <br>
                    <button id="login-button" type="submit"> Login </button>
                    <br>
                   
                </div>
                
            </form>           
        </div>
        
    </body>
    
</html>


