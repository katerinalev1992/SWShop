package com.klevytska.swshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by klevytska on 08.12.2016.
 */
@Entity
@XmlRootElement
@Table(name = "products")
public class Product implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "rating")
    private String rating;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "added_date")
    private Date addedDate;

    @NotNull
    @JoinColumn(name = "added_by")
    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Employee addedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Employee getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Employee addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (isActive != product.isActive) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (shortDescription != null ? !shortDescription.equals(product.shortDescription) : product.shortDescription != null)
            return false;
        if (fullDescription != null ? !fullDescription.equals(product.fullDescription) : product.fullDescription != null)
            return false;
        if (rating != null ? !rating.equals(product.rating) : product.rating != null) return false;
        if (posterUrl != null ? !posterUrl.equals(product.posterUrl) : product.posterUrl != null) return false;
        if (productType != null ? !productType.equals(product.productType) : product.productType != null) return false;
        if (addedDate != null ? !addedDate.equals(product.addedDate) : product.addedDate != null) return false;
        return addedBy != null ? addedBy.equals(product.addedBy) : product.addedBy == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (fullDescription != null ? fullDescription.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (posterUrl != null ? posterUrl.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (addedBy != null ? addedBy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", rating='" + rating + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", isActive=" + isActive +
                ", productType='" + productType + '\'' +
                ", addedDate=" + addedDate +
                ", addedBy=" + addedBy +
                '}';
    }
}
