/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;

import java.util.ArrayList;

/**
 *
 * @author Matteo
 */

/*In questa classe sono inizializzati in un array 3 commenti di default. Inoltre sono contenuti una serie di metodi per
poter gestire i commenti.
*/
public class CommentsFactory {
     private static CommentsFactory instance;
     private  ArrayList<Commenti> commentiList = new ArrayList<>();
     private CommentsFactory() {

    UserFactory userFactory = UserFactory.getInstance();

    Commenti commento1 = new Commenti();
    commento1.setId(0);
    commento1.setData(2018,05,04);
    commento1.setContent("Articolo meraviglioso");

    commento1.setAutore(userFactory.getUserById(0));


    Commenti commento2 = new Commenti();
    commento2.setId(1);
    commento2.setData(2018,04,28);
    commento2.setContent("Bella parttita!");

    commento2.setAutore(userFactory.getUserById(1));

    Commenti commento3 = new Commenti();
    commento3.setId(2);
    commento3.setData(2017,03,10);
    commento3.setContent("Articolo Interessante");

    commento3.setAutore(userFactory.getUserById(2));

    commentiList.add(commento1);
    commentiList.add(commento2);
    commentiList.add(commento3);
    }

public static CommentsFactory getInstance(){
    if (instance == null)
        instance = new CommentsFactory();

        return instance;
}

public ArrayList<Commenti> getCommenti(){
    return commentiList;
}

public Commenti getCommentoById(int id){
    for (Commenti cm : commentiList)
        if (cm.getId() == id)
        return cm;

return null;
}

public ArrayList<Commenti> getCommentoByAuthor(User author){
ArrayList<Commenti> listToReturn = new ArrayList<>();

for (Commenti cm : commentiList)
    if (author.equals(cm.getAutore()))
    listToReturn.add(cm);

return listToReturn;
}

}

