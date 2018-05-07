<%-- 
    Document   : articoli
    Created on : 20-apr-2018, 11.39.37
    Author     : Matteo
--%>
<%--
Questa jsp si occupa di stampare una tabella con le notizie scritte dall`autore. 
La navbar varia a seconda che l'utente sia loggato o meno oppure se sia un autore. 
In caso non sia un autore mostra un messaggio di accesso negato.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Articoli</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Pagina Articoli Blog">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <jsp:include page="header.jsp" />
        
        <div class="barranavigazione">
            
            <c:if test="${loggedIn == true && isAuthor ==true}"> 

                <nav>
                    
                    <a href="notizie.html">Notizie</a>
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
            
        <c:if test="${loggedIn == true && isAuthor ==true}">
            
            <div class="middlecolumn">
                
                <h2 id="Titolo-Tabella">I miei Articoli</h2>
             
                <table class="tabella">
                    
                    <tr>
                        <th>Data di Pubblicazione</th>
                        <th>Titolo</th>
                        <th>Modifica</th>
                        <th>Cancella</th>
                    </tr>

                    <c:forEach  var="notizia"  items="${list_news}">
                        
                        <tr>
                            
                            <td>${notizia.dateSetup()}</td>
                            
                            <td><a href="notizia.html?nid=${notizia.getId()}" id="titoli_art_tab">${notizia.getTitolo()}</a></td>
                            
                            <td>
                                <form action="scriviArticolo.html?id=${notizia.getId()}" method="post">
                                    <button type="submit">
                                        <img src="https://jackmoreno.files.wordpress.com/2015/06/iconmonstr-pencil-9-icon-256.png?w=625" 
                                             alt="icona modifica" width="16" height="16">
                                        Modifica
                                    </button>
                                </form>
                            </td>

                            <td>
                                <button type="submit">
                                    <img  src="https://image.freepik.com/icones-gratis/lixeira_318-55452.jpg"  
                                          alt="icona elimina" width="16" height="16">
                                    Elimina
                                </button>
                            </td>
                            
                        </tr>
                        
                    </c:forEach>


                </table>
                
                <form action="scriviArticolo.html" method="post">
                    <br>
                    <button id="new-article-button" type="submit"> Nuovo Articolo </button>
                    <br>
                </form>
                
            </div>
            
        </c:if>
            
        <c:if test="${loggedIn == true && isAuthor ==false}">
            
            <h2>Errore:sezione riservata agli autori</h2>
            
        </c:if>
        
        <c:if test="${loggedIn == false}">
            
            <h2>Errore:sezione riservata agli autori</h2>
            
        </c:if>
            
    </body>
    
</html>
