/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jetbrains.annotations.Nullable;

/**
 *
 * @author kenn8007
 */
@Entity
@Table(name = "tbAdmin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmin.findAll", query = "SELECT t FROM TbAdmin t"),
    @NamedQuery(name = "TbAdmin.findById", query = "SELECT t FROM TbAdmin t WHERE t.id = :id"),
    @NamedQuery(name = "TbAdmin.findByUsername", query = "SELECT t FROM TbAdmin t WHERE t.username = :username"),
    @NamedQuery(name = "TbAdmin.findByPwd", query = "SELECT t FROM TbAdmin t WHERE t.pwd = :pwd"),
    @NamedQuery(name = "TbAdmin.findByEmail", query = "SELECT t FROM TbAdmin t WHERE t.email = :email"),
    @NamedQuery(name = "TbAdmin.findByAddress", query = "SELECT t FROM TbAdmin t WHERE t.address = :address"),
    @NamedQuery(name = "TbAdmin.findByPhone", query = "SELECT t FROM TbAdmin t WHERE t.phone = :phone"),
    @NamedQuery(name = "TbAdmin.findByLevel", query = "SELECT t FROM TbAdmin t WHERE t.level = :level"),
    @NamedQuery(name = "TbAdmin.findByUrlImage", query = "SELECT t FROM TbAdmin t WHERE t.urlImage = :urlImage"),
    @NamedQuery(name = "TbAdmin.findByFullname", query = "SELECT t FROM TbAdmin t WHERE t.fullname = :fullname")})
public class TbAdmin implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "pwd")
    private String pwd;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Column(name = "level")
    private Integer level;
    @Size(max = 255)
    @Column(name = "urlImage")
    private String urlImage;
    @Size(max = 255)
    @Column(name = "fullname")
    private String fullname;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "adminId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbToken> tbTokenCollection;

    public TbAdmin() {
    }

    public TbAdmin(Integer id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @JsonIgnore
    @Null
    @Nullable
    @XmlTransient
    public Collection<TbToken> getTbTokenCollection() {
        return tbTokenCollection;
    }

    public void setTbTokenCollection(Collection<TbToken> tbTokenCollection) {
        this.tbTokenCollection = tbTokenCollection;
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
        if (!(object instanceof TbAdmin)) {
            return false;
        }
        TbAdmin other = (TbAdmin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbAdmin[ id=" + id + " ]";
    }
    
}
