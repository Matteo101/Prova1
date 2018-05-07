/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

/*Questa classe descrive gli attributi necessari per rappresentare gli utenti. Inoltre raccoglie tutti i metodi per settare
e restituire questi ultimi.
*/

/**
 *
 * @author Matteo
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String urlProfImg;
        
    public User(){
        this.id = 0;
        this.name = "";
        this.surname = "";
        this.email = "";
        this.password = "";
        this.urlProfImg = "";
    }
        
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUrlProfImg(){
        return urlProfImg;
    }

    public void setUrlProfImg(String urlProfImg){
        this.urlProfImg = urlProfImg;
    }
    
    public boolean equals(User otherUtenti){
        return this.id == otherUtenti.getId();
    }
           
}
