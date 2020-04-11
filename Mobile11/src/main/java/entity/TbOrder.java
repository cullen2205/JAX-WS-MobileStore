/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kenn8007
 */
@Entity
@Table(name = "tbOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOrder.findAll", query = "SELECT t FROM TbOrder t"),
    @NamedQuery(name = "TbOrder.findById", query = "SELECT t FROM TbOrder t WHERE t.id = :id"),
    @NamedQuery(name = "TbOrder.findByQuantity", query = "SELECT t FROM TbOrder t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TbOrder.findByMoney", query = "SELECT t FROM TbOrder t WHERE t.money = :money"),
    @NamedQuery(name = "TbOrder.findByMethod", query = "SELECT t FROM TbOrder t WHERE t.method = :method"),
    @NamedQuery(name = "TbOrder.findByStatus", query = "SELECT t FROM TbOrder t WHERE t.status = :status"),
    @NamedQuery(name = "TbOrder.findByDateCreate", query = "SELECT t FROM TbOrder t WHERE t.dateCreate = :dateCreate")})
public class TbOrder implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 255)
    @Column(name = "money")
    private String money;
    @Size(max = 255)
    @Column(name = "method")
    private String method;
    @Column(name = "status")
    private Integer status;
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @JoinColumn(name = "product_id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbProduct productId;
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbUser userId;

    public TbOrder() {
    }

    public TbOrder(Integer id) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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
        if (!(object instanceof TbOrder)) {
            return false;
        }
        TbOrder other = (TbOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbOrder[ id=" + id + " ]";
    }
    
}
