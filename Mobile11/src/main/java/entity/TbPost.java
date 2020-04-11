/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbPost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPost.findAll", query = "SELECT t FROM TbPost t"),
    @NamedQuery(name = "TbPost.findById", query = "SELECT t FROM TbPost t WHERE t.id = :id"),
    @NamedQuery(name = "TbPost.findByName", query = "SELECT t FROM TbPost t WHERE t.name = :name"),
    @NamedQuery(name = "TbPost.findByDescripton", query = "SELECT t FROM TbPost t WHERE t.descripton = :descripton")})
public class TbPost implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 2000)
    @Column(name = "descripton")
    private String descripton;
    @JoinColumn(name = "product_id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbProduct productId;

    public TbPost() {
    }

    public TbPost(Integer id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public TbProduct getProductId() {
        return productId;
    }

    public void setProductId(TbProduct productId) {
        this.productId = productId;
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
        if (!(object instanceof TbPost)) {
            return false;
        }
        TbPost other = (TbPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbPost[ id=" + id + " ]";
    }
    
}
