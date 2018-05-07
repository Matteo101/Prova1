<%-- 
    Document   : notizia
    Created on : 20-apr-2018, 11.44.23
    Author     : Matteo
--%>

<%--
Questa jsp si occupa di stampare la singola notizia. La navbar varia a seconda che l'utente sia loggato o meno oppure
se sia un autore.Inoltre e` possibile guardare le notizie per categoria
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
    
    <head>
        <title>Notizia</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Pagina Notizia">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
      
        <jsp:include page="header.jsp" />
        
        <div class="barranavigazione">
            
            <c:if test="${loggedIn == true && isAuthor ==true}">
                
                <nav>

                    <a href="articoli.jsp">Articoli</a>
                    <a href="profilo.html?id=${user.getId()}">Profilo</a>
                    
                    <div id="nome-logout">
                        <h3>Ciao ${user.getName()}</h3>
                        <form action="login.html?logout=true" method="post">
                            <button type="submit" id="logout-button"> Logout </button>
                        </form>
                    </div>

                </nav>
                    
            </c:if>
            
            <c:if test="${loggedIn == true && isAuthor ==false}">
                
                <nav>
                    
                    <a href="profilo.html?id=${user.getId()}">Profilo</a>
                    
                    <div id="nome-logout">
                        <h3>Ciao ${user.getName()}</h3>
                        <form action="login.html?logout=true" method="post">
                            <button type="submit" id="logout-button"> Logout </button>
                        </form>
                    </div>
                </nav>
                    
            </c:if>
            
            <c:if test="${loggedIn == false}">
                
                <nav>
                    <a href="login.html">Login</a>
                </nav>
                
            </c:if>
        </div>
      
        <aside class="columnside">
            
            <jsp:include page="barraRicerca.jsp" />
            <jsp:include page="listaCategorie.jsp" />
            <jsp:include page="listaautori.jsp" />

        </aside>
        
        
        
        
            
        <div class="middlecolumn">
            
            <article>
                
                <h2 id="Titolo-Notizia">${news.getTitolo()}</h2>
                
                <div class="Immagine-Info">
                    
                    <img id="Immagine" src="${news.getImg()}">
                    
                    <div id="InfoAutore">
                        ${news.getAutore().getName()}
                        <br>
                        ${news.dateSetup()}
                        <br>
                        ${news.getCategoria()}
                    </div>
                    
                    <h3 id="Didascalia">${news.getDidascalia()}</h3> 
                    
                </div>
                    
                <div class="Articolo">
                    <p>${news.getContent()}</p>
                </div>
                
                <div class="Commento">
                    
                    <h2>Commenti:</h2>
                    <p>${news.getCommento().getAutore().getName()} : ${news.getCommento().getContent()}</p>
                    
                </div>
                    
            </article> 
                    
        </div>
       
    </body>
    
</html>
