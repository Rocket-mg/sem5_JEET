/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trwalosc;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author student
 */
public class PicturesQuery {
    private Session session = null;
    private List<Pictures> PicturesList = null; 
    private Query q = null;

    
    public PicturesQuery(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
     private String getPicturesHTML(List<Pictures> lista) {
        String wiersz;
        wiersz = ("<table><tr>"); wiersz = wiersz.concat(
        "<td><b>ID</b></td>"
        + "<td><b>IMIE</b></td>"
        + "<td><b>NAZWISKO</b></td>");

        wiersz = wiersz.concat("</tr>");

        for (Pictures ldz : lista) {
        wiersz = wiersz.concat("<tr>");
        wiersz = wiersz.concat("<td>" + ldz.getImageId() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getName() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getAuthor() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getType() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getForm() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getUsdPrice() + "</td>"); 
        wiersz = wiersz.concat("<td>" + ldz.getMuseumProperty() + "</td>"); 
        wiersz = wiersz.concat("</tr>");
        }
        wiersz = wiersz.concat("</table>");
        return wiersz;
        }

    
    public String getPicturesLista(boolean OrderByName) {

    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        if (OrderByName) {
        q = session.createQuery("from Pictures order by name");
        } else {
            q = session.createQuery("from Pictures order by image_id");
        }
        PicturesList = (List<Pictures>) q.list(); 
        session.close();
        tx.commit();
    } catch (HibernateException e) {
    }
    return getPicturesHTML(PicturesList);
    }
    
    public int dodajImage(String name, String author, String type, String form, String USD_price, boolean MP) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
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
            q = session.createQuery("select max(imageId) FROM Pictures");
            List rs = q.list();
            maxid = (Integer) rs.get(0);
            q = session.createQuery("from Pictures order by image_id");
            rs = q.list();
            //pom = rs.get(0);
            Field myField = (rs.get(0)).getClass().getDeclaredField("imageId");
            myField.setAccessible(true);
            while(pom<maxid){
                pom = ((Integer) myField.get(rs.get(iter-1)));
                System.out.print(pom);
                if(!(iter == pom))
                    break;
                else iter++;
            }
            //iter++;
            Pictures pr = new Pictures();
            pr.setImageId(iter);
            pr.setName(name);
            pr.setAuthor(author);
            pr.setType(type);
            pr.setForm(form);
            pr.setUsdPrice(Integer.parseInt(USD_price));
            pr.setMuseumProperty(MP);
            session.save(pr);
            session.getTransaction().commit();
            System.out.println(iter);
            session.close();
            //tx.commit(); 
            
        } catch (HibernateException e) {
        }
        return iter;
    }
    public int usunImage(String IDp){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Pictures pr = new Pictures();
            int IDpp = Integer.parseInt(IDp);
            pr.setImageId((short)IDpp);
            session.delete(pr);
            System.out.println("Obraz o ID "+IDp + "usuniety");
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
    public int edytujImage(String ID, String name, String author, String type, String form, String USD_price, boolean MP){
        Pictures pr = new Pictures();
        pr.setImageId(Integer.parseInt(ID));
        pr.setName(name);
        pr.setAuthor(author);
        pr.setType(type);
        pr.setForm(form);
        pr.setUsdPrice(Integer.parseInt(USD_price));
        pr.setMuseumProperty(MP);
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
}
