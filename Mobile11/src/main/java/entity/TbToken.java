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
@Table(name = "tbToken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbToken.findAll", query = "SELECT t FROM TbToken t"),
    @NamedQuery(name = "TbToken.findById", query = "SELECT t FROM TbToken t WHERE t.id = :id"),
    @NamedQuery(name = "TbToken.findByValue", query = "SELECT t FROM TbToken t WHERE t.value = :value")})
public class TbToken implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "admin_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(cascade = {CascadeType.DETACH})
    private TbAdmin adminId;

    public TbToken() {
    }

    public TbToken(Integer id) {
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

    public TbAdmin getAdminId() {
        return adminId;
    }

    public void setAdminId(TbAdmin adminId) {
        this.adminId = adminId;
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
        if (!(object instanceof TbToken)) {
            return false;
        }
        TbToken other = (TbToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbToken[ id=" + id + " ]";
    }
    
}
