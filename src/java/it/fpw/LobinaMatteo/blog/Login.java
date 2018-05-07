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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
/*Questa servlet si occupa di verificare se l'utento sia loggato o meno, in caso non lo sia si occupa di controllare 
se i dati inseriti siano corretti. In caso positivo, logga l'utente, in caso negativo restituisce un messaggio d'errore,
e rimanda il controllo a login.jsp*/
    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            UserFactory user_factory = UserFactory.getInstance(); //Accedo ai metodi della user factory
            NewsFactory news_factory = NewsFactory.getInstance(); //Accedo ai metodi della news factory
            
    /*Il seguente pezzo di codice si occupa di prendere la lista delle notizie e tramite un opportuno metodo usarle
      per ottenere la lista degli autori da stampare dalla jsp "listaautori" */
           
            
            ArrayList<Articoli> listNews=news_factory.getNews(); 
            ArrayList<User> lista_autori= user_factory.getAuthors(listNews);
            request.setAttribute("lista_autori",lista_autori); 
            
            
                    if (request.getParameter("logout") != null)
                    {
                        session.invalidate();
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        return;
                    }
                    
                    //Se l'utente e` loggato il controllo passa alla servlet Notizie
                    if (session.getAttribute("loggedIn") != null &&
                        session.getAttribute("loggedIn").equals(true))
                    {
                        String email = request.getParameter("email");
                        
                        User user = user_factory.getUserByEmail(email); //Acquisisco il profilo utente e lo salvo in una variabile di sessione
                        session.setAttribute("user",user); 
                                              
                        response.sendRedirect("notizie.html");
                        
                        return;
                    }
                    else //In caso contrario acquisisce e controlla i  parametri email e password
                    {
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        

                        if (email != null &&
                            password != null &&
                            user_factory.login(email, password)
                            )
                        {
                            //email e password esistono e sono validi: ora il controllo puo` passare alla servlet Notizie
                            int userId = user_factory.getUserByEmail(email).getId();
                            User username= user_factory.getUserById(userId);
                            session.setAttribute("loggedIn", true);
                            session.setAttribute("user",username);                                                        
                                                 
                            response.sendRedirect("notizie.html");
                            
                            return;
                        }
                        else if(email != null &&  //Altrimenti il controllo passa nuovamente a login.jsp per un nuovo tentativo di login
                                password != null)
                        {
                            
                            request.setAttribute("invalidData", true);
                            session.setAttribute("loggedIn", false);
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                            return;
                        }

                    }
                   request.getRequestDispatcher("login.jsp").forward(request, response);
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
