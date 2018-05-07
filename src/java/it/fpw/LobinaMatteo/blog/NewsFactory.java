/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.LobinaMatteo.blog;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*In questa classe sono inizializzate in un array 3 notizie di default. Inoltre sono contenuti una serie di metodi per
poter restituire le notizie a seconda di vari parametri passati(per data,per autore,per categoria..) e per gestire 
queste ultime */


public class NewsFactory {
    
    private static NewsFactory instance;
    private ArrayList<Articoli> listNews = new ArrayList<>();
   
    private NewsFactory()
    {
        UserFactory userFactory = UserFactory.getInstance();
        CommentsFactory commentsFactory= CommentsFactory.getInstance();
        Articoli news1 = new Articoli();
        news1.setId(0);
        news1.setCategoria("Politica");
        news1.setContent("Alle prese con le sfide tecnologiche, ma sempre fedele alle tecniche della vecchia fanteria. Addestrato alla guerra invisibile e informatica e contemporaneamente impegnato a pattugliare le strade delle nostre città. Pronto al futuro sfruttando le esperienze del passato, l’Esercito italiano festeggia oggi i suoi 157 anni di storia, affermando sempre di più l’impegno diretto a favore dei cittadini. Perché se è vero che le missioni all’estero assorbono una fetta importante delle forze, una parte ancor più significativa delle energia è destinata all’impegno in patria. ");
        news1.setImg("http://www.lastampa.it/rf/image_lowres/Pub/p4/2018/05/04/Italia/Foto/RitagliWeb/95a6ad0a-4f96-11e8-9a71-b4d79182be98_142c825705ab8262c1cb10573f83212b-kfYF-U1110717755522M4E-1024x576%40LaStampa.it.jpg" );
        news1.setDidascalia("Il capo di Stato Maggiore dell’Esercito,il capo di Stato Maggiore della Difesa e il ministro della Difesa");
        news1.setTitolo("L’Esercito italiano festeggia 157 anni");
        news1.setAutore(userFactory.getUserById(2));
        news1.setData("2018/05/04");
        
        news1.setCommento(commentsFactory.getCommentoById(2));
        
        Articoli news2 = new Articoli();
        news2.setId(1);
        news2.setCategoria("Sport");
        news2.setContent("LONDRA - Impresa della Juventus nel ritorno degli ottavi di Champions. \n" +
"                    I bianconeri espugnano Wembley dopo una partita di sofferenza e di cuore, \n" +
"                    chiusa in svantaggio all'intervallo per la rete di Son. \n" +
"                    Serviva una vittoria per buttare fuori il Tottenham, forte del 2-2 dell'andata,\n" +
"                    questa arriva nella ripresa,quando Allegri mescola le carte azzeccando le mosse giuste. \n" +
"                    In tre minuti Higuain e Dybala firmano una vittoria, poi mantenuta in un finale \n" +
"                    di pura sofferenza. ");
        news2.setImg("https://nst.sky.it/immagini/sport/ciclismo/2018/03/07/738-462/higuain_dybala_getty.jpg");
        news2.setDidascalia("Nell'immagine Higuain e Dybala");
        news2.setTitolo("Juventus vince la partita con il Tottenham");
        news2.setAutore(userFactory.getUserById(1));
        news2.setData("2018/3/7");
        news2.setCommento(commentsFactory.getCommentoById(1));
        
        Articoli news3 = new Articoli();
        news3.setId(2);
        news3.setCategoria("Cultura");
        news3.setContent("OnePlus negli anni è cresciuta, passando dall’essere una delle tante aziende cinesi produttrici di smartphone a un marchio affermato e rispettato. Dopo il buon successo ottenuto dal OnePlus 5 e del OnePlus 5T (primo smartphone dell’azienda cinese ad avere uno schermo con rapporto d’aspetto di 18:9 e un design borderless), gli sforzi degli sviluppatori si stanno concentrando sul primo dispositivo che sarà lanciato nel 2018: il One Plus 6.");
        news3.setImg("https://www.androidstylehd.com/wp-content/uploads/2018/01/maxresdefault-11.jpg");
        news3.setDidascalia("Nuovo OnePlus 6");
        news3.setTitolo("OnePlus 6");
        news3.setAutore(userFactory.getUserById(0));
        news3.setData("2018/05/5");
        news3.setCommento(commentsFactory.getCommentoById(0));
        
        listNews.add(news1);
        listNews.add(news2);
        listNews.add(news3);
    }
    
    public static NewsFactory getInstance() 
    {
        
     instance = new NewsFactory();
        
        return instance;
    }
    
    public ArrayList<Articoli> getNews()
    {
        return listNews;
    }
    
    public Articoli getNewsById(int id)
    {
        for (Articoli news : listNews)
            if (news.getId() == id)
                return news;
        
        return null;
    }
    
    public ArrayList<Articoli> getNewsByAuthor(User author)
    {
        ArrayList<Articoli> listToReturn = new ArrayList<>();
        
        for (Articoli news : listNews)
            if (author.equals(news.getAutore()))
                listToReturn.add(news);
            
        return listToReturn;
    }
    
/*Questo metodo si occupa di controllare se per un dato utente fornito in input ci sono notizie di cui lui e l'autore*/
     public Boolean getPresenceNewsByAuthor(User author)
    {
        Boolean presence=null;
        
        for (Articoli news : listNews){
            if (author.equals(news.getAutore())){
                presence=true;
            }
        }
        
        return presence;
    }
    
       public ArrayList<Articoli> getNewsByCategory(String category)
    {
        ArrayList<Articoli> listToReturn = new ArrayList<>();
        
        for (Articoli news : listNews)
            if (category.equals(news.getCategoria()))
                listToReturn.add(news);
            
        return listToReturn;
    }
    
    public ArrayList<Articoli> getNewsByDate() {
     ArrayList<Articoli> sortList = new ArrayList<>(listNews);
     Collections.sort(sortList, new Comparator<Articoli>(){
         @Override
         public int compare(Articoli o1, Articoli o2) {
             return o2.getData().compareTo(o1.getData());
         }
     });
     return sortList;
 }

    
}
