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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kenn8007
 */
@Entity
@Table(name = "tbImage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbImage.findAll", query = "SELECT t FROM TbImage t"),
    @NamedQuery(name = "TbImage.findById", query = "SELECT t FROM TbImage t WHERE t.id = :id"),
    @NamedQuery(name = "TbImage.findByUrl", query = "SELECT t FROM TbImage t WHERE t.url = :url")})
public class TbImage implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "product_id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbProduct productId;

    public TbImage() {
    }

    public TbImage(Integer id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof TbImage)) {
            return false;
        }
        TbImage other = (TbImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbImage[ id=" + id + " ]";
    }
    
}
