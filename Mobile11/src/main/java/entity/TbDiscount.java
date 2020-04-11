/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kenn8007
 */
@Entity
@Table(name = "tbDiscount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDiscount.findAll", query = "SELECT t FROM TbDiscount t"),
    @NamedQuery(name = "TbDiscount.findById", query = "SELECT t FROM TbDiscount t WHERE t.id = :id"),
    @NamedQuery(name = "TbDiscount.findByValue", query = "SELECT t FROM TbDiscount t WHERE t.value = :value"),
    @NamedQuery(name = "TbDiscount.findByName", query = "SELECT t FROM TbDiscount t WHERE t.name = :name")})
public class TbDiscount implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    public TbDiscount() {
    }

    public TbDiscount(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof TbDiscount)) {
            return false;
        }
        TbDiscount other = (TbDiscount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbDiscount[ id=" + id + " ]";
    }
    
}
