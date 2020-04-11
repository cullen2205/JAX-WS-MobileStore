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
@Table(name = "tbReview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbReview.findAll", query = "SELECT t FROM TbReview t"),
    @NamedQuery(name = "TbReview.findById", query = "SELECT t FROM TbReview t WHERE t.id = :id"),
    @NamedQuery(name = "TbReview.findByContent", query = "SELECT t FROM TbReview t WHERE t.content = :content")})
public class TbReview implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2000)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "product_id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbProduct productId;
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbUser userId;

    public TbReview() {
    }

    public TbReview(Integer id) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TbProduct getProductId() {
        return productId;
    }

    public void setProductId(TbProduct productId) {
        this.productId = productId;
    }

    public TbUser getUserId() {
        return userId;
    }

    public void setUserId(TbUser userId) {
        this.userId = userId;
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
        if (!(object instanceof TbReview)) {
            return false;
        }
        TbReview other = (TbReview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbReview[ id=" + id + " ]";
    }
    
}
