/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*Questa classe descrive gli attributi necessari per rappresentare gli articoli. Inoltre raccoglie tutti i metodi per settare
e restituire questi ultimi.
*/


/**
 *
 * @author Matteo
 */
public class Articoli {
    private int id;

    /**
     *
     */
    private String titolo;
    private String content;
    private String img;
    private String didascalia;
    private String categoria;
    private User autore;
    private GregorianCalendar data;
    private Commenti commento;

    public Articoli(){
        this.id = 0;
        this.titolo = "";
        this.content= "";
        this.img= "";
        this.didascalia="";
        this.categoria = "";
        this.autore = new User();
        this.data= new GregorianCalendar();
        this.commento= new Commenti();
    }
    
        
    /**
     * @return the id
     */
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }
    
    public String getDidascalia() {
        return didascalia;
    }

    /**
     * @param didascalia
     */
    public void setDidascalia(String didascalia) {
        this.didascalia = didascalia;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the autore
     */
    public User getAutore() {
        return autore;
    }

    /**
     * @param nome_autore
     */
    public void setAutore(User nome_autore) {
        
        this.autore = nome_autore;
    }
    
/*Questa speciale funzione permette di settare la data partendo da una stringa contenente la data inserita dall'utente*/  
    
   public void setData(String data_acquisita) {  
        String[] parts = data_acquisita.split("/");
        int year= Integer.parseInt( parts[0]);
        int month= Integer.parseInt( parts[1]);
        int day= Integer.parseInt( parts[2]);
        GregorianCalendar aux= new GregorianCalendar(year,month,day);
        this.data=aux;
        
    }
/*Funzione per la stampa della data sotto formato di stringa*/   
      public String dateSetup(){
        int day,month,year;
        day = data.get(Calendar.DATE);
        month = data.get(Calendar.MONTH);
        year = data.get(Calendar.YEAR);
        return year+"/"+month+"/"+day;
    }
    
   
   
   
   public GregorianCalendar getData() {
        return data;
    }
   
    public void setCommento(Commenti commento){
        this.commento=commento;
    }
    
    public Commenti getCommento(){
       return commento;
    }
    
/*Funzione che permette di stampare i primi 100 caratteri di una notizia*/
    
    public String len() {
        String testo=content;
        int dim= testo.length();
        
        if(dim<100){
            
        return testo;
        
        }
        else{
            return testo.substring(0,100);
        }
    }
    
 
           
} 


