/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

import java.util.ArrayList;

/*In questa classe sono inizializzati in un array 3 utenti di default. Inoltre sono contenuti una serie di metodi per
poter gestire gli utenti.
*/
public class UserFactory {
    
    /**
     * Pattern singleton.
     */
    private static UserFactory instance;
    private ArrayList<User> userList = new ArrayList<>();
    
    private UserFactory()
    {
        User user1 = new User();
        user1.setId(0);
        user1.setName("Alessandro");
        user1.setSurname("Bianchi");
        user1.setEmail("AlessandroBianchi@google.it");
        user1.setPassword("bianchino");
        user1.setUrlProfImg("img/profimgnomefalso.png");
        
        User user2 = new User();
        user2.setId(1);
        user2.setName("Sergio");
        user2.setSurname("Castelli");
        user2.setEmail("SergioCastelli@google.it");
        user2.setPassword("serg1995");
        user2.setUrlProfImg("img/profimgpippopaperino.png");
        
        User user3 = new User();
        user3.setId(2);
        user3.setName("Giulio");
        user3.setSurname("Potenza");
        user3.setEmail("GiulioPotenza@google.it");
        user3.setPassword("123");
        user3.setUrlProfImg("img/Potenzastar.png");
        
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
    
    public static UserFactory getInstance()
    {
        if (instance == null)
            instance = new UserFactory();
        return instance;
    }
    
    public ArrayList<User> getUsers()
    {
        return userList;
    }
    
    public User getUserById(int id)
    {
        for (User user : userList)
            if (user.getId() == id)
                return user;
        
        return null;
    }
    
 /*Questo metodo si occupa di  verificare se un utente ha inserito email e password corretti*/
    public boolean login(String email, String password)
    {
        for (User user : userList){
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    
    public User getUserByEmail(String email)
    {
        for (User user: userList)
            if (user.getEmail().equals(email))
                return user;
        
        return null;
    }
    
    /*Questo metodo si occupa di raccogliere e mettere in un array gli autori delle notizie*/
    public ArrayList<User>getAuthors(ArrayList<Articoli> listNews){
        ArrayList<User> authors= new ArrayList<>();
        for(User user : userList){
            for (Articoli news : listNews){
                if (user.equals(news.getAutore())){
                    if(!authors.contains(user)){
                        authors.add(user);
                    }
                }
            }
        }
               
        return  authors;
    }

}