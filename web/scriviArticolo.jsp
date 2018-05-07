<%-- 
    Document   : scriviArticolo
    Created on : 20-apr-2018, 11.33.09
    Author     : Matteo
--%>

<%--
Questa jsp si occupa di inserire e poi mostrare i campi della notizia prima e dopo l`eventuale modifica. 
La navbar varia a seconda che l'utente sia loggato o meno oppure se sia un autore. 
In caso non sia un autore mostra un messaggio di accesso negato.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="it">
    
    <head>
        <title>Scrivi Articolo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Pagina Scrvi Articolo">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <jsp:include page="header.jsp" />
        
        <div  class="barranavigazione">
            
            <c:if test="${loggedIn==true}"> 

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
                
                <c:if test="${refresh==true}">
                    <h2>Id Articolo: ${notizia.getId()}</h2>
                </c:if>
                <form  action="scriviArticolo.html?id=${notizia.getId()}&refresh=true" method="post">

                    <article class="ScriviArticolo">

                         <label class="labelArticolo" for="titolo">Titolo:</label>
                         <input class="Art-Text" type="text" name="titolo" id="titolo" value="${notizia.getTitolo()}" />
                         <br>
                         <label class="labelArticolo" for="data">Data di Pubblicazione:</label>
                         <input class="Art-Text" type="text" name="data" id="data" value="${notizia.dateSetup()}" />
                         <br>
                         <label class="labelArticolo" for="url">Url:</label>
                         <input class="Art-Text" type="text" name="url" id="url" value="${notizia.getImg()}" />
                         <br>
                         <label class="labelArticolo" for="didascalia">Didascalia Immagine:</label>
                         <input class="Art-Text" type="text" name="didascalia" id="didascalia" value="${notizia.getDidascalia()}" />
                         <br>
                         <label class="labelArticolo" for="testoarticolo">Testo Articolo:</label>
                         <textarea class="Art-Text" rows="10" cols="50" name="testoarticolo" id="testoarticolo">${notizia.getContent()} </textarea>
                         
                        <button id="Save-button" type="submit"> Salva </button>

                    </article>

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

