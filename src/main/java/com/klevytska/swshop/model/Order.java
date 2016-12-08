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
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    long id;

    @NotNull
    @JoinColumn(name = "customerId")
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Customer customerId;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "orderNumber")
    private String orderNumber;

    @Column(name = "state")
    private String state;

    @NotNull
    @JoinColumn(name = "paymentMethodId")
    @ManyToOne(targetEntity = PaymentMethod.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PaymentMethod paymentMethodId;

    @NotNull
    @JoinColumn(name = "shippingMothod")
    @ManyToOne(targetEntity = ShippingMethod.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShippingMethod shippingMothod;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public ShippingMethod getShippingMothod() {
        return shippingMothod;
    }

    public void setShippingMothod(ShippingMethod shippingMothod) {
        this.shippingMothod = shippingMothod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (customerId != null ? !customerId.equals(order.customerId) : order.customerId != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (orderNumber != null ? !orderNumber.equals(order.orderNumber) : order.orderNumber != null) return false;
        if (state != null ? !state.equals(order.state) : order.state != null) return false;
        if (paymentMethodId != null ? !paymentMethodId.equals(order.paymentMethodId) : order.paymentMethodId != null)
            return false;
        return shippingMothod != null ? shippingMothod.equals(order.shippingMothod) : order.shippingMothod == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        result = 31 * result + (shippingMothod != null ? shippingMothod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", orderNumber='" + orderNumber + '\'' +
                ", state='" + state + '\'' +
                ", paymentMethodId=" + paymentMethodId +
                ", shippingMothod=" + shippingMothod +
                '}';
    }
}
