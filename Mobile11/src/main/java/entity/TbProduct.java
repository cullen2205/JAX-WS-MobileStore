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
@Table(name = "tbProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProduct.findAll", query = "SELECT t FROM TbProduct t"),
    @NamedQuery(name = "TbProduct.findById", query = "SELECT t FROM TbProduct t WHERE t.id = :id"),
    @NamedQuery(name = "TbProduct.findBySku", query = "SELECT t FROM TbProduct t WHERE t.sku = :sku"),
    @NamedQuery(name = "TbProduct.findByName", query = "SELECT t FROM TbProduct t WHERE t.name = :name"),
    @NamedQuery(name = "TbProduct.findByPrice", query = "SELECT t FROM TbProduct t WHERE t.price = :price"),
    @NamedQuery(name = "TbProduct.findByGhz", query = "SELECT t FROM TbProduct t WHERE t.ghz = :ghz"),
    @NamedQuery(name = "TbProduct.findByColor", query = "SELECT t FROM TbProduct t WHERE t.color = :color"),
    @NamedQuery(name = "TbProduct.findBySensor", query = "SELECT t FROM TbProduct t WHERE t.sensor = :sensor"),
    @NamedQuery(name = "TbProduct.findByCpu", query = "SELECT t FROM TbProduct t WHERE t.cpu = :cpu"),
    @NamedQuery(name = "TbProduct.findByRam", query = "SELECT t FROM TbProduct t WHERE t.ram = :ram"),
    @NamedQuery(name = "TbProduct.findByStorage", query = "SELECT t FROM TbProduct t WHERE t.storage = :storage"),
    @NamedQuery(name = "TbProduct.findByCameraFront", query = "SELECT t FROM TbProduct t WHERE t.cameraFront = :cameraFront"),
    @NamedQuery(name = "TbProduct.findByCameraRear", query = "SELECT t FROM TbProduct t WHERE t.cameraRear = :cameraRear"),
    @NamedQuery(name = "TbProduct.findByBattery", query = "SELECT t FROM TbProduct t WHERE t.battery = :battery"),
    @NamedQuery(name = "TbProduct.findByDisplay", query = "SELECT t FROM TbProduct t WHERE t.display = :display"),
    @NamedQuery(name = "TbProduct.findBySim", query = "SELECT t FROM TbProduct t WHERE t.sim = :sim"),
    @NamedQuery(name = "TbProduct.findByStatus", query = "SELECT t FROM TbProduct t WHERE t.status = :status"),
    @NamedQuery(name = "TbProduct.findByActivate", query = "SELECT t FROM TbProduct t WHERE t.activate = :activate"),
    @NamedQuery(name = "TbProduct.findByProductCateId", query = "SELECT t FROM TbProduct t WHERE t.productCateId = :productCateId"),
    @NamedQuery(name = "TbProduct.findByDiscountId", query = "SELECT t FROM TbProduct t WHERE t.discountId = :discountId"),
    @NamedQuery(name = "TbProduct.findByUrlImage", query = "SELECT t FROM TbProduct t WHERE t.urlImage = :urlImage"),
    @NamedQuery(name = "TbProduct.findByFollow", query = "SELECT t FROM TbProduct t WHERE t.follow = :follow")})
public class TbProduct implements iBaseClass, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "sku")
    private String sku;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @Size(max = 255)
    @Column(name = "Ghz")
    private String ghz;
    @Size(max = 255)
    @Column(name = "color")
    private String color;
    @Size(max = 255)
    @Column(name = "sensor")
    private String sensor;
    @Size(max = 255)
    @Column(name = "cpu")
    private String cpu;
    @Size(max = 255)
    @Column(name = "ram")
    private String ram;
    @Size(max = 255)
    @Column(name = "storage")
    private String storage;
    @Size(max = 255)
    @Column(name = "camera_front")
    private String cameraFront;
    @Size(max = 255)
    @Column(name = "camera_rear")
    private String cameraRear;
    @Size(max = 255)
    @Column(name = "battery")
    private String battery;
    @Size(max = 255)
    @Column(name = "display")
    private String display;
    @Size(max = 255)
    @Column(name = "sim")
    private String sim;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Column(name = "activate")
    private Integer activate;
    @Column(name = "product_cate_id")
    private Integer productCateId;
    @Column(name = "discount_id")
    private Integer discountId;
    @Size(max = 255)
    @Column(name = "urlImage")
    private String urlImage;
    @Column(name = "follow")
    private Integer follow;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "productId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbPost> tbPostCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "productId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbComment> tbCommentCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "productId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbImage> tbImageCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "productId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbReview> tbReviewCollection;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "productId", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<TbOrder> tbOrderCollection;

    public TbProduct() {
    }

    public TbProduct(Integer id) {
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGhz() {
        return ghz;
    }

    public void setGhz(String ghz) {
        this.ghz = ghz;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCameraFront() {
        return cameraFront;
    }

    public void setCameraFront(String cameraFront) {
        this.cameraFront = cameraFront;
    }

    public String getCameraRear() {
        return cameraRear;
    }

    public void setCameraRear(String cameraRear) {
        this.cameraRear = cameraRear;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getActivate() {
        return activate;
    }

    public void setActivate(Integer activate) {
        this.activate = activate;
    }

    public Integer getProductCateId() {
        return productCateId;
    }

    public void setProductCateId(Integer productCateId) {
        this.productCateId = productCateId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    @JsonIgnore
    @Null
    @Nullable
    @XmlTransient
    public Collection<TbPost> getTbPostCollection() {
        return tbPostCollection;
    }

    public void setTbPostCollection(Collection<TbPost> tbPostCollection) {
        this.tbPostCollection = tbPostCollection;
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
    public Collection<TbImage> getTbImageCollection() {
        return tbImageCollection;
    }

    public void setTbImageCollection(Collection<TbImage> tbImageCollection) {
        this.tbImageCollection = tbImageCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduct)) {
            return false;
        }
        TbProduct other = (TbProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbProduct[ id=" + id + " ]";
    }
    
}
