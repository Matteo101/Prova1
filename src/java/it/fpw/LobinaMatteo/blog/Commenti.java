/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

import java.util.Calendar;

/*Questa classe descrive gli attributi necessari per rappresentare i commenti. Inoltre raccoglie tutti i metodi per settare
e restituire questi ultimi.
*/

/**
 *
 * @author Matteo
 */
public class Commenti {
    private int id;
    private Calendar data;
    private User autore;
    private String content;
    
public Commenti(){
        this.id = 0;
        this.data=Calendar.getInstance();
        this.autore = new User();
        this.content="";
}

public void setId(int id) {
        this.id = id;
    }

    public void setData(int year, int month, int day) {
        this.data.set(year, month, day);
    }
    public Calendar getData() {
        return data;
    }

    public void setAutore(User autore) {
        this.autore = autore;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    

    public User getAutore() {
        return autore;
    }

    public String getContent() {
        return content;
    }
    
}