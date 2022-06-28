package com.phoneshopper.mobile.model;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table()
public class AppOrder {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private Long orderNumber;

    @Column()
    private Long version;

    public AppOrder(Long id, Long orderNumber, Long version) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.version = version;
    }

    public AppOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppOrder appOrder = (AppOrder) o;
        return Objects.equals(id, appOrder.id) && Objects.equals(orderNumber, appOrder.orderNumber) && Objects.equals(version, appOrder.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, version);
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", version=" + version +
                '}';
    }
}
