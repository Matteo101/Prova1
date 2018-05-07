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

/*Servlet che si occupa di raccogliere tutte le notizie scritte dall'eventuale autore */
public class Articles extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            UserFactory user_factory = UserFactory.getInstance();//Accedo ai metodi della user factory
            NewsFactory news_factory = NewsFactory.getInstance();//Accedo ai metodi della news factory
        
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

            
            User user = (User) session.getAttribute("user");
            session.setAttribute("user",user);
            
            Boolean isAuthor = (Boolean) session.getAttribute("isAuthor");

            if(isAuthor==null){
                isAuthor=false;
                
            }
            if(isAuthor==true){ /*Se l'utente e` un autore la jsp visualizzera` le notizie passategli dalla servlet in una tabella */
                
                session.setAttribute("isAuthor",isAuthor);
                ArrayList <Articoli> list_news =news_factory.getNewsByAuthor(user);
                request.setAttribute("list_news",list_news);
            }
            else{ //In caso contrario setta solo inAuthor e la jsp poiche`is author e` settato su false restituisce un messaggio d'errore
                session.setAttribute("isAuthor",isAuthor);
            }


            request.getRequestDispatcher("articoli.jsp").forward(request, response);
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
