/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matteo
 */
public class NewArticle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
/*Questa servlet si occupa di gestire in caso l`utente sia l`autore di modificare la propria notizie e di salvare i nuovi
  dati. La servlet capisce quando deve restituire i dati in memoria e quando salvarli,controllando un opportuno parametro
  inviato via URL chiamato refresh (se e` settato su true indica un salvataggio)
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            
        HttpSession session = request.getSession();
        UserFactory user_factory= UserFactory.getInstance();//Accedo ai metodi della user factory
        NewsFactory news_factory= NewsFactory.getInstance();//Accedo ai metodi della news factory
        
        
        /*Il seguente pezzo di codice si occupa di prendere la lista delle notizie e tramite un opportuno metodo usarle
         per ottenere la lista degli autori da stampare dalla jsp "listaautori" */
        
        ArrayList<Articoli> listNews=news_factory.getNews();
        ArrayList<User> lista_autori= user_factory.getAuthors(listNews);
        request.setAttribute("lista_autori",lista_autori);
        
        /*Acquisizione e controlli legati alle variabili di sessione contenenti le informazioni riguardanti l'utente
         (se l'utente e` loggato e se sia un autore)*/   
        
        Boolean loggedIn=(Boolean) session.getAttribute("loggedIn");
        
        
        if(loggedIn == null){
            loggedIn=false;
        }
        
        session.setAttribute("loggedIn",loggedIn);
        User user = (User) session.getAttribute("user"); //acquisisco la variabile di sessione riguardante l`utente
        session.setAttribute("user",user);
            
        Boolean isAuthor = (Boolean) session.getAttribute("isAuthor");
        if(isAuthor==null){
            isAuthor=false;

        }
        if(isAuthor==true){ /*Se l`utente e` l`autore la servlet va avanti altrimenti il controllo passa alla jsp che stampa
                            un messaggio di errore*/
            session.setAttribute("isAuthor",isAuthor);

            int id=Integer.parseInt(request.getParameter("id")); /*Tramite questo campo (id) la Servlet prende da memoria la notizia 
                                                                    desiderata*/
            
            Boolean refresh= Boolean.valueOf(request.getParameter("refresh")); /*Controllo refresh*/
            session.setAttribute("refresh",refresh);

            if(refresh==false){ /*Se refresh e` settato su false si occupa di inseire nei campi di input per la modifica la notizia
                                 desiderata*/
            Articoli news= news_factory.getNewsById(id);
            request.setAttribute("notizia",news);
            }
            if(refresh==true){ /*Se refresh e` uguale a true la servlet acquisira` i nuovi dati e stampa all`utente la notizia
                                (nei rispettivi campi di input) con le modifiche, oltre all`id della notizia*/
                
            Articoli nuova_notizia=news_factory.getNewsById(id);
            nuova_notizia.setTitolo(request.getParameter("titolo"));
            nuova_notizia.setData(request.getParameter("data"));
            nuova_notizia.setImg(request.getParameter("url"));
            nuova_notizia.setDidascalia(request.getParameter("didascalia"));
            nuova_notizia.setContent(request.getParameter("testoarticolo"));
            request.setAttribute("notizia",nuova_notizia);
            }
        }
        
         
        
         request.getRequestDispatcher("scriviArticolo.jsp").forward(request, response);
         
        
        
        }
        
   }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            processRequest(request, response);
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            processRequest(request,response);
       
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
