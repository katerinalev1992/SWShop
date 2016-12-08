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
@Table(name = "payments")
public class Payment  implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @JoinColumn(name = "orderId")
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Order orderId;

    @Column(name = "paymentAmount")
    private String paymentAmount;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "creditCardName")
    private String creditCardName;

    @Column(name = "cardholderName")
    private String cardholderName;

    @Column(name = "creditCardExpDate")
    private Date creditCardExpDate;

    @NotNull
    @JoinColumn(name = "paymentMethodId")
    @ManyToOne(targetEntity = PaymentMethod.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PaymentMethod paymentMethodId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public Date getCreditCardExpDate() {
        return creditCardExpDate;
    }

    public void setCreditCardExpDate(Date creditCardExpDate) {
        this.creditCardExpDate = creditCardExpDate;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != payment.id) return false;
        if (orderId != null ? !orderId.equals(payment.orderId) : payment.orderId != null) return false;
        if (paymentAmount != null ? !paymentAmount.equals(payment.paymentAmount) : payment.paymentAmount != null)
            return false;
        if (paymentDate != null ? !paymentDate.equals(payment.paymentDate) : payment.paymentDate != null) return false;
        if (creditCardName != null ? !creditCardName.equals(payment.creditCardName) : payment.creditCardName != null)
            return false;
        if (cardholderName != null ? !cardholderName.equals(payment.cardholderName) : payment.cardholderName != null)
            return false;
        if (creditCardExpDate != null ? !creditCardExpDate.equals(payment.creditCardExpDate) : payment.creditCardExpDate != null)
            return false;
        return paymentMethodId != null ? paymentMethodId.equals(payment.paymentMethodId) : payment.paymentMethodId == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (paymentAmount != null ? paymentAmount.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (creditCardName != null ? creditCardName.hashCode() : 0);
        result = 31 * result + (cardholderName != null ? cardholderName.hashCode() : 0);
        result = 31 * result + (creditCardExpDate != null ? creditCardExpDate.hashCode() : 0);
        result = 31 * result + (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", paymentDate=" + paymentDate +
                ", creditCardName='" + creditCardName + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                ", creditCardExpDate=" + creditCardExpDate +
                ", paymentMethodId=" + paymentMethodId +
                '}';
    }
}
