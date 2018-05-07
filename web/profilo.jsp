<%-- 
    Document   : profilo
    Created on : 5-mag-2018, 19.11.10
    Author     : Matteo
--%>

<%--
Questa jsp si occupa di inserire e poi mostrare i campi del profilo utente prima e dopo l`eventuale modifica. 
La navbar varia a seconda che l'utente sia loggato o meno oppure se sia un autore. 
In caso non sia autenticato mostra un messaggio di accesso negato.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML,CSS,RESPONSIVE,NOTIZIE,BLOG">
        <meta name="description" content="Profilo">
        <meta name="author" content="Matteo Lobina">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <jsp:include page="header.jsp" />
        
        <div class="barranavigazione">
            
            <c:if test="${loggedIn == true && isAuthor == true}">

                <nav>

                    <a href="notizie.html">Notizie</a>
                    <a href="articoli.html">Articoli</a>

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

                    
                    <a href="notizie.html">Notizie</a>
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
           
            <c:if test="${loggedIn==true}">  
                
                <c:if test="${operazione_riuscita==true}">
                    <h2>Modifica avvenuta con successo </h2>
                </c:if>
               
                <form  action="profilo.html?id=${utente.getId()}&refresh=true" method="post">
               
                    <article class="ScriviArticolo">
                        
                        <label class="labelArticolo" for="name">Nome:</label>
                        <input class="Art-Text" type="text" name="name" id="name" value="${utente.getName()}" />
                        <br>
                        <label class="labelArticolo" for="surname">Cognome:</label>
                        <input class="Art-Text" type="text" name="surname" id="surname" value="${utente.getSurname()}" />
                        <br>
                        <label class="labelArticolo" for="email">Email:</label>
                        <input class="Art-Text" type="text" name="email" id="email" value="${utente.getEmail()}" />
                        <br>
                        <label class="labelArticolo" for="password">Password:</label>
                        <input class="Art-Text" type="password" name="password" id="password-profilo" value="${utente.getPassword()}" />
                        <br>
                        <label class="labelArticolo" for="urlProfImg">Url Immagine Profilo:</label>
                        <input class="Art-Text" type="text" name="urlProfImg" id="urlProfImg" value="${utente.getUrlProfImg()}" />                    
                        <br>
                        <button id="Save-button" type="submit"> Salva </button>

                    </article>
             
                </form>
           
            </c:if>
                    
            <c:if test="${loggedIn==false}">
                
                <h2>Errore:sezione riservata agli utenti loggati </h2>
                
            </c:if>
                
        </div>
            
    </body>

</html>
