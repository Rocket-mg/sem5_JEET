/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;
import java.lang.reflect.Field;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author student
 */
public class HashedstringsQuery {
    
    private Session session = null;
    private List<Hashedstrings> HSList = null; 
    private Query q = null;
    
    
    public HashedstringsQuery(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private String getHashedstringsHTML(List<Hashedstrings> lista) {
        String wiersz;
        wiersz = ("<table><tr>"); wiersz = wiersz.concat(
        "<td><b>ID | </b></td>"
        + "<td><b>HASHEDSTRING</b></td>");

        wiersz = wiersz.concat("</tr>");

        for (Hashedstrings ldz : lista) {
        wiersz = wiersz.concat("<tr>");
        wiersz = wiersz.concat("<td>" + ldz.getIdH() + "</td>"); 
        wiersz = wiersz.concat("|<td>" + ldz.getHashedstring() + "</td>"); 
        wiersz = wiersz.concat("</tr>");
        }
        wiersz = wiersz.concat("</table>");
        return wiersz;
        }

    
    public String getHashedstringsLista() {

    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        q = session.createQuery("from Hashedstrings order by id_h");
        HSList = (List<Hashedstrings>) q.list(); 
        session.close();
        tx.commit();
    } catch (HibernateException e) {
    }
    return getHashedstringsHTML(HSList);
    }
    
    public boolean usunHashedstring(String IDp){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Hashedstrings pr = new Hashedstrings();
            int IDpp = Integer.parseInt(IDp);
            pr.setIdH(IDpp);
            session.delete(pr);
            System.out.println("Hash o ID "+IDp + "usuniety");
            tx.commit();
            return true;
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean dodajHashedstring(String string) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
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
            q = session.createQuery("select max(idH) from Hashedstrings");
            List rs = q.list();
            maxid = (Integer) rs.get(0);
            q = session.createQuery("from Hashedstrings order by id_h");
            rs = q.list();
            //pom = rs.get(0);
            Field myField = (rs.get(0)).getClass().getDeclaredField("idH");
            myField.setAccessible(true);
            while(pom<maxid){
                pom = ((Integer) myField.get(rs.get(iter-1)));
                System.out.print(pom);
                if(!(iter == pom))
                    break;
                else iter++;
            }
            //iter++;
            Hashedstrings pr = new Hashedstrings();
            pr.setIdH(iter);
            pr.setHashedstring(string);
            session.save(pr);
            session.getTransaction().commit();
            System.out.println(iter);
            session.close();
            //tx.commit(); 
            return true;
            
        } catch (HibernateException e) {
            return false;
        }
        
    }
}
