/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trwalosc;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author student
 */
@Entity
@Table(name = "PRACOWNICY")
@NamedQueries({
    @NamedQuery(name = "Pracownicy.findAll", query = "SELECT p FROM Pracownicy p"),
    @NamedQuery(name = "Pracownicy.findById", query = "SELECT p FROM Pracownicy p WHERE p.id = :id"),
    @NamedQuery(name = "Pracownicy.findByImie", query = "SELECT p FROM Pracownicy p WHERE p.imie = :imie"),
    @NamedQuery(name = "Pracownicy.findByNazwisko", query = "SELECT p FROM Pracownicy p WHERE p.nazwisko = :nazwisko")})
public class Pracownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IMIE")
    private String imie;
    @Column(name = "NAZWISKO")
    private String nazwisko;
    private Iterable<Pracownicy> lista;

    public Pracownicy() {
    }

    public Pracownicy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pracownicy)) {
            return false;
        }
        Pracownicy other = (Pracownicy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trwalosc.Pracownicy[ id=" + id + " ]";
    }
    public String getListaTML(List<Pracownicy> Lista){
        String wiersz;
        wiersz = ("<table><tr>");
        wiersz = wiersz.concat("<td><b>ID</b></td>"
                + "<td><b>IMIE</b></td>" 
                + "<td><b>NAZWISKO</b></td>");
        wiersz = wiersz.concat("</tr>");
        
        for (Pracownicy ldz : lista){
            wiersz = wiersz.concat("<tr>");
            wiersz = wiersz.concat("<td>" + ldz.getId() + "</td>");
            wiersz = wiersz.concat("<td>" + ldz.getImie() + "</td>");
            wiersz = wiersz.concat("<td>" + ldz.getNazwisko() + "</td>");
        }
        wiersz = wiersz.concat("</table>");
        return wiersz;
    }
    
}
