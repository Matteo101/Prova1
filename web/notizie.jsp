<%-- 
    Document   : notizie
    Created on : 1-mag-2018, 15.59.24
    Author     : Matteo
--%>
<%--
Questa jsp si occupa di stampare la lista delle notizie. La navbar varia a seconda che l'utente sia loggato o meno oppure
se sia un autore.Inoltre e` possibile guardare le notizie per categoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
    
    <head>
        <title>Notizie</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Pagina Notizie">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
      
        <jsp:include page="header.jsp" />
        
        <div class="barranavigazione">
            
            <c:if test="${loggedIn == true && isAuthor == true}">
                
                <nav>
                    
                    <a href="articoli.html">Articoli</a>
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
            
            <c:forEach var="notizia" items="${list_news}">
                
                <article>
                    
                    <h2 id="Titolo-Notizia">${notizia.getTitolo()}</h2>
                    
                    <div class="Immagine-Info">
                        
                        <img id="Immagine" src="${notizia.getImg()}">
                        
                        <div id="InfoAutore">
                            ${notizia.getAutore().getName()}
                            <br>
                            ${notizia.dateSetup()}
                            <br>
                            ${notizia.getCategoria()}
                        </div> 
                        
                        <h3 id="Didascalia">${notizia.getDidascalia()}</h3>
                        
                    </div>

                    <div class="Articolo">
                        
                        <p>${notizia.len()}</p>
                        <a href="notizia.html?nid=${notizia.getId()}">Leggi tutto...</a>
                        
                    </div>

                </article> 
                
            </c:forEach>
            
        </div>
            
    </body>
    
</html>
