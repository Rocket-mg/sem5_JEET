/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trwalosc;
import java.lang.reflect.Field;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.validator.internal.util.logging.Log;

/**
 *
 * @author student
 */
public class PracownicyQuery {
    private Session session = null;
    //int maxid=0;
    Object result = null;
    int[] ints = null;
    long res1 = 0;
    long count = 0;
    private List<Pracownicy> PracownicyList = null; 
    private Query q = null;
    public PracownicyQuery() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    /*public String getPracownicyLista () {
        try {            
            Transaction tx = session.beginTransaction();               
            q = session.createQuery("from Pracownicy");                      
            PracownicyList = (List<Pracownicy>) q.list();            
            session.close();            
            tx.commit();        
        } catch (HibernateException e) {}
        //return PracownicyList.toString();
        return getListaHTML(PracownicyList); 
    }*/
    //public List<Pracownicy> getPracownicyLista(boolean OrderByImie) {
    public String getPracownicyLista(int OrderByImie) {
        try {
        org.hibernate.Transaction tx = session.beginTransaction();
        System.out.println(OrderByImie);
        if (OrderByImie==0) {
            System.out.println("0");
            q = session.createQuery("from Pracownicy");
            
        } else {
            System.out.println("1");
            q = session.createQuery("from Pracownicy order by imie");
            
        }
            PracownicyList = (List<Pracownicy>) q.list(); 
            session.close();
            tx.commit();
        } catch (HibernateException e) {
        }
        return  getListaHTML(PracownicyList);
        }
    public String getPracownicyListaBYID() {
        try {
        org.hibernate.Transaction tx = session.beginTransaction();
        
            q = session.createQuery("from Pracownicy order by ID");

            PracownicyList = (List<Pracownicy>) q.list(); 
            session.close();
            tx.commit();
        } catch (HibernateException e) {
        }
        return  getListaHTML(PracownicyList);
        }
    public int dodajPracownika(String imie, String nazwisko) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        int iter = 1;
        int pom = 0;
        try {
        org.hibernate.Transaction tx;
           tx = session.beginTransaction();
          /*  q = session.createQuery("select max(id) from Pracownicy");
            List rs = q.list();
            int maxid = (Integer) rs.get(0);
            System.out.println(q);
            session.close();
            tx.commit();*/
            int maxid = 0;
            q = session.createQuery("select max(id) from Pracownicy");
            List rs = q.list();
            maxid = (Integer) rs.get(0);
            q = session.createQuery("from Pracownicy order by id");
            rs = q.list();
            //pom = rs.get(0);
            Field myField = (rs.get(0)).getClass().getDeclaredField("id");
            myField.setAccessible(true);
            while(pom<maxid){
                pom = ((Integer) myField.get(rs.get(iter-1)));
                System.out.print(pom);
                if(!(iter == pom))
                    break;
                else iter++;
            }
            //iter++;
            Pracownicy pr = new Pracownicy();
            pr.setId(iter);
            pr.setImie(imie);
            pr.setNazwisko(nazwisko);
            session.save(pr);
            session.getTransaction().commit();
            System.out.println(iter);
            session.close();
            //tx.commit(); 
            
        } catch (HibernateException e) {
        }
        return iter;
    }
    public int edytujPracownika(String ID, String imie, String nazwisko){
        Pracownicy pr = new Pracownicy();
        if(ID == "") 
        {
            return 0;
        }
        pr.setId(Integer.parseInt(ID));
        pr.setImie(imie);
        pr.setNazwisko(nazwisko);
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(pr);
            tx.commit();
            return 1;
        
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }
    public int usunPracownika(String IDp){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Pracownicy pr = new Pracownicy();
            int IDpp = Integer.parseInt(IDp);
            pr.setId(IDpp);
            session.delete(pr);
            System.out.println("Pracownik o ID "+IDp + "usuniety");
            tx.commit();
            return 1;
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }
    private String getListaHTML(List<Pracownicy> lista) {
        String wiersz;
        wiersz = ("<table><tr>"); 
        wiersz = wiersz.concat(
        "<td><b>ID</b></td>"
        + "<td><b>IMIE</b></td>"
        + "<td><b>NAZWISKO</b></td>");

        wiersz = wiersz.concat("</tr>");

        for (Pracownicy ldz : lista) {
        wiersz = wiersz.concat("<tr>");
        wiersz = wiersz.concat("<td>" + ldz.getId() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getImie() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getNazwisko() + "</td>"); 
        wiersz = wiersz.concat("</tr>");
        }
        wiersz = wiersz.concat("</table>");
        return wiersz;
       }

    

}
