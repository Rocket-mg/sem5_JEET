/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trwalosc;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PICTURES")
@NamedQueries({
    @NamedQuery(name = "Pictures.findAll", query = "SELECT p FROM Pictures p"),
    @NamedQuery(name = "Pictures.findByImageId", query = "SELECT p FROM Pictures p WHERE p.imageId = :imageId"),
    @NamedQuery(name = "Pictures.findByName", query = "SELECT p FROM Pictures p WHERE p.name = :name"),
    @NamedQuery(name = "Pictures.findByAuthor", query = "SELECT p FROM Pictures p WHERE p.author = :author"),
    @NamedQuery(name = "Pictures.findByType", query = "SELECT p FROM Pictures p WHERE p.type = :type"),
    @NamedQuery(name = "Pictures.findByForm", query = "SELECT p FROM Pictures p WHERE p.form = :form"),
    @NamedQuery(name = "Pictures.findByUsdPrice", query = "SELECT p FROM Pictures p WHERE p.usdPrice = :usdPrice"),
    @NamedQuery(name = "Pictures.findByMuseumProperty", query = "SELECT p FROM Pictures p WHERE p.museumProperty = :museumProperty")})
public class Pictures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IMAGE_ID")
    private Integer imageId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "FORM")
    private String form;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "USD_PRICE")
    private BigDecimal usdPrice;
    @Basic(optional = false)
    @Column(name = "MUSEUM_PROPERTY")
    private Boolean museumProperty;
    private Iterable<Pictures> lista;

    public Pictures() {
    }

    public Pictures(Integer imageId) {
        this.imageId = imageId;
    }

    public Pictures(Integer imageId, String name, String author, Boolean museumProperty) {
        this.imageId = imageId;
        this.name = name;
        this.author = author;
        this.museumProperty = museumProperty;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public BigDecimal getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(BigDecimal usdPrice) {
        this.usdPrice = usdPrice;
    }

    public Boolean getMuseumProperty() {
        return museumProperty;
    }

    public void setMuseumProperty(Boolean museumProperty) {
        this.museumProperty = museumProperty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageId != null ? imageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pictures)) {
            return false;
        }
        Pictures other = (Pictures) object;
        if ((this.imageId == null && other.imageId != null) || (this.imageId != null && !this.imageId.equals(other.imageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trwalosc.Pictures[ imageId=" + imageId + " ]";
    }
    
    public String getListaTML(List<Pracownicy> Lista){
        String wiersz;
        wiersz = ("<table><tr>");
        wiersz = wiersz.concat("<td><b>ID</b></td>"
                + "<td><b>IMIE</b></td>" 
                + "<td><b>NAZWISKO</b></td>");
        wiersz = wiersz.concat("</tr>");
        
        for (Pictures pct : lista){
            wiersz = wiersz.concat("<tr>");
            wiersz = wiersz.concat("<td>" + pct.getImageId() + "</td>");
            wiersz = wiersz.concat("<td>" + pct.getName() + "</td>");
            wiersz = wiersz.concat("<td>" + pct.getAuthor() + "</td>");
            wiersz = wiersz.concat("<td>" + pct.getType() + "</td>");
            wiersz = wiersz.concat("<td>" + pct.getForm() + "</td>");
            wiersz = wiersz.concat("<td>" + pct.getUsdPrice() + "</td>");
            wiersz = wiersz.concat("<td>" + pct.getMuseumProperty() + "</td>");
        }
        wiersz = wiersz.concat("</table>");
        return wiersz;
    }
    
}
