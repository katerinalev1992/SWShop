package com.klevytska.swshop.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by klevytska on 08.12.2016.
 */
@Entity
@XmlRootElement
@Table(name = "shippingMethod")
public class ShippingMethod implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "method")
    private String method;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingMethod that = (ShippingMethod) o;

        if (id != that.id) return false;
        return method != null ? method.equals(that.method) : that.method == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (method != null ? method.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShippingMethod{" +
                "id=" + id +
                ", method='" + method + '\'' +
                '}';
    }
}
