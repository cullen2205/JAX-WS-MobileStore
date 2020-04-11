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
@Table(name = "tbUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUser.findAll", query = "SELECT t FROM TbUser t"),
    @NamedQuery(name = "TbUser.findById", query = "SELECT t FROM TbUser t WHERE t.id = :id"),
    @NamedQuery(name = "TbUser.findByUsername", query = "SELECT t FROM TbUser t WHERE t.username = :username"),
    @NamedQuery(name = "TbUser.findByFullname", query = "SELECT t FROM TbUser t WHERE t.fullname = :fullname"),
    @NamedQuery(name = "TbUser.findByPwd", query = "SELECT t FROM TbUser t WHERE t.pwd = :pwd"),
    @NamedQuery(name = "TbUser.findByEmail", query = "SELECT t FROM TbUser t WHERE t.email = :email"),
    @NamedQuery(name = "TbUser.findByAddress", query = "SELECT t FROM TbUser t WHERE t.address = :address"),
    @NamedQuery(name = "TbUser.findByPhone", query = "SELECT t FROM TbUser t WHERE t.phone = :phone"),
    @NamedQuery(name = "TbUser.findByUrlImage", query = "SELECT t FROM TbUser t WHERE t.urlImage = :urlImage"),
    @NamedQuery(name = "TbUser.findByActivated", query = "SELECT t FROM TbUser t WHERE t.activated = :activated"),
    @NamedQuery(name = "TbUser.findByTotalMoney", query = "SELECT t FROM TbUser t WHERE t.totalMoney = :totalMoney"),
    @NamedQuery(name = "TbUser.findByLastOrderMoney", query = "SELECT t FROM TbUser t WHERE t.lastOrderMoney = :lastOrderMoney")})
public class TbUser implements iBaseClass, Serializable {

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
    @Column(name = "fullname")
    private String fullname;
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
    @Size(max = 255)
    @Column(name = "urlImage")
    private String urlImage;
    @Column(name = "activated")
    private Integer activated;
    @Size(max = 255)
    @Column(name = "total_money")
    private String totalMoney;
    @Size(max = 255)
    @Column(name = "lastOrderMoney")
    private String lastOrderMoney;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "userId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbComment> tbCommentCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "userId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbReview> tbReviewCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "userId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbOrder> tbOrderCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "userId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbUserToken> tbUserTokenCollection;

    public TbUser() {
    }

    public TbUser(Integer id) {
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getLastOrderMoney() {
        return lastOrderMoney;
    }

    public void setLastOrderMoney(String lastOrderMoney) {
        this.lastOrderMoney = lastOrderMoney;
    }

    @JsonIgnore
    @Null
    @Nullable
    @XmlTransient
    public Collection<TbComment> getTbCommentCollection() {
        return tbCommentCollection;
    }

    public void setTbCommentCollection(Collection<TbComment> tbCommentCollection) {
        this.tbCommentCollection = tbCommentCollection;
    }

    @JsonIgnore
    @Null
    @Nullable
    @XmlTransient
    public Collection<TbReview> getTbReviewCollection() {
        return tbReviewCollection;
    }

    public void setTbReviewCollection(Collection<TbReview> tbReviewCollection) {
        this.tbReviewCollection = tbReviewCollection;
    }

    @JsonIgnore
    @Null
    @Nullable
    @XmlTransient
    public Collection<TbOrder> getTbOrderCollection() {
        return tbOrderCollection;
    }

    public void setTbOrderCollection(Collection<TbOrder> tbOrderCollection) {
        this.tbOrderCollection = tbOrderCollection;
    }

    @JsonIgnore
    @Null
    @Nullable
    @XmlTransient
    public Collection<TbUserToken> getTbUserTokenCollection() {
        return tbUserTokenCollection;
    }

    public void setTbUserTokenCollection(Collection<TbUserToken> tbUserTokenCollection) {
        this.tbUserTokenCollection = tbUserTokenCollection;
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
        if (!(object instanceof TbUser)) {
            return false;
        }
        TbUser other = (TbUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbUser[ id=" + id + " ]";
    }
    
}
