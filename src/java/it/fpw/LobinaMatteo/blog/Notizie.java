/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matteo
 */
public class Notizie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
/*Questa servlet si occupa di stampare la lista delle notizie. E` settata in modo che stampi a seconda di particolari input
  o l`intera lista o solo le notizie appartenenti a una categoria selezionata dall`utente.
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            UserFactory user_factory= UserFactory.getInstance(); //Accedo ai metodi della user factory
            NewsFactory news_factory = NewsFactory.getInstance();//Accedo ai metodi della news factory
            
        /*Il seguente pezzo di codice si occupa di prendere la lista delle notizie e tramite un opportuno metodo usarle
         per ottenere la lista degli autori da stampare dalla jsp "listaautori" */
        
            ArrayList<Articoli> listNews=news_factory.getNews();
            ArrayList<User> lista_autori= user_factory.getAuthors(listNews);
            request.setAttribute("lista_autori",lista_autori); 
            
            
            
            
            User user = (User) session.getAttribute("user"); /*acquisisco la variabile di sessione utente, che contiene le 
                                                                informazioni dell'utente loggato. */
            
            /*Acquisizione della variabile loggedIn, se l'utente e` loggato avra` acesso ad alcune sezioni a cui agli utenti
            non loggati e` bloccato l'accesso*/
            
            Boolean loggedIn=(Boolean) session.getAttribute("loggedIn");  //acquisisco loggedIn
            
            if(loggedIn == null){
                loggedIn=false;
            }
            
            
            Boolean isAuthor;
            //Verifico se l'utente sia un autore o meno
            if(user!= null && news_factory.getPresenceNewsByAuthor(user)!=null){
                isAuthor=true;
                session.setAttribute("isAuthor",isAuthor);
            }
            else{
                isAuthor=false;
                session.setAttribute("isAuthor",isAuthor);
            }  
            session.setAttribute("loggedIn",loggedIn);
            session.setAttribute("user",user);
            
            /*Con l'acquisizione di category come parametro dalla URL la servlet capisce se stampare tutte le notizie
             (in caso category sia settata su null o su Tutte) oppure solo le notizie di una determinata categoria
            */
            String category=request.getParameter("category");
            request.setAttribute("category", category);
            String Tutte="Tutte";
            if(category==null|| category.equals(Tutte)){ //stampo tutte le notizie mediante notizie.jsp
            ArrayList <Articoli> list_news= news_factory.getNewsByDate();
            request.setAttribute("list_news",list_news);
            request.getRequestDispatcher("notizie.jsp").forward(request, response);
            
            }
            else{ /*stampo solo le notizie di una determinata categoria mediante categorie.jsp 
                   (jsp apposita per la stampa di notizie per categoria)*/
                
            ArrayList <Articoli> list_news= news_factory.getNewsByCategory(category);
            request.setAttribute("list_news",list_news); 
            request.getRequestDispatcher("categorie.jsp").forward(request, response);
            
            
            }
            
            
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
     
            processRequest(request, response);
      
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
