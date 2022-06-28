package com.phoneshopper.mobile.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity()
@Table()
public class CellPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    @NotNull(message = "MIN is required")
    private Long mobileIdentificationNumber;

    @Column(unique = true, updatable = false, nullable = false)
    @NotNull(message = "IMEI is required")
    private Long internationalMobileEquipmentIdentity;

    @Column()
    @NotEmpty(message = "Maker cannot be empty.")
    @Size(max = 20, message = "Length is greater than 20 characters")
    private String maker;

    @Column()
    @NotNull(message = "Year cannot be null")
    private Short year;

    @Column()
    @NotEmpty(message = "Color cannot be empty.")
    @Size(max = 20, message = "Length is greater than 20 characters")
    private String color;

    @Column()
    @NotEmpty(message = "Model cannot be empty.")
    @Size(max = 20, message = "Length is greater than 20 characters")
    private String model;

    @Column()
    @NotEmpty(message = "Model Number cannot be empty.")
    @Size(max = 20, message = "Length is greater than 20 characters")
    private String modelNumber;

    @Column()
    private Long version;

    @Column(nullable = false)
    private Boolean isNew = true;

    @Column()
    @Size(max = 20, message = "Length is greater than 20 characters")
    private String currentAppUser;

    @Column()
    @Size(max = 20, message = "Length is greater than 20 characters")
    private String currentAppOrder;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<AppOrder> appOrders = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<AppUser> appUsers = new HashSet<>();

    public CellPhone(Long id, Long mobileIdentificationNumber, Long internationalMobileEquipmentIdentity, String maker, Short year, String color, String model, String modelNumber, Long version, Boolean isNew, String currentAppUser, String currentAppOrder, Set<AppOrder> appOrders, Set<AppUser> appUsers) {
        this.id = id;
        this.mobileIdentificationNumber = mobileIdentificationNumber;
        this.internationalMobileEquipmentIdentity = internationalMobileEquipmentIdentity;
        this.maker = maker;
        this.year = year;
        this.color = color;
        this.model = model;
        this.modelNumber = modelNumber;
        this.version = version;
        this.isNew = isNew;
        this.currentAppUser = currentAppUser;
        this.currentAppOrder = currentAppOrder;
        this.appOrders = appOrders;
        this.appUsers = appUsers;
    }

    public CellPhone() { super(); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMobileIdentificationNumber() {
        return mobileIdentificationNumber;
    }

    public void setMobileIdentificationNumber(Long mobileIdentificationNumber) {
        this.mobileIdentificationNumber = mobileIdentificationNumber;
    }

    public Long getInternationalMobileEquipmentIdentity() {
        return internationalMobileEquipmentIdentity;
    }

    public void setInternationalMobileEquipmentIdentity(Long internationalMobileEquipmentIdentity) {
        this.internationalMobileEquipmentIdentity = internationalMobileEquipmentIdentity;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public String getCurrentAppUser() {
        return currentAppUser;
    }

    public void setCurrentAppUser(String currentAppUser) {
        this.currentAppUser = currentAppUser;
    }

    public String getCurrentAppOrder() {
        return currentAppOrder;
    }

    public void setCurrentAppOrder(String currentAppOrder) {
        this.currentAppOrder = currentAppOrder;
    }

    public Set<AppOrder> getAppOrders() {
        return appOrders;
    }

    public void setAppOrders(Set<AppOrder> appOrders) {
        this.appOrders = appOrders;
    }

    public Set<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPhone cellPhone = (CellPhone) o;
        return Objects.equals(id, cellPhone.id) && Objects.equals(mobileIdentificationNumber, cellPhone.mobileIdentificationNumber) && Objects.equals(internationalMobileEquipmentIdentity, cellPhone.internationalMobileEquipmentIdentity) && Objects.equals(maker, cellPhone.maker) && Objects.equals(year, cellPhone.year) && Objects.equals(color, cellPhone.color) && Objects.equals(model, cellPhone.model) && Objects.equals(modelNumber, cellPhone.modelNumber) && Objects.equals(version, cellPhone.version) && Objects.equals(isNew, cellPhone.isNew) && Objects.equals(currentAppUser, cellPhone.currentAppUser) && Objects.equals(currentAppOrder, cellPhone.currentAppOrder) && Objects.equals(appOrders, cellPhone.appOrders) && Objects.equals(appUsers, cellPhone.appUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mobileIdentificationNumber, internationalMobileEquipmentIdentity, maker, year, color, model, modelNumber, version, isNew, currentAppUser, currentAppOrder, appOrders, appUsers);
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "id=" + id +
                ", mobileIdentificationNumber=" + mobileIdentificationNumber +
                ", internationalMobileEquipmentIdentity=" + internationalMobileEquipmentIdentity +
                ", maker='" + maker + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", version=" + version +
                ", isNew=" + isNew +
                ", currentAppUser='" + currentAppUser + '\'' +
                ", currentAppOrder='" + currentAppOrder + '\'' +
                ", appOrders=" + appOrders +
                ", appUsers=" + appUsers +
                '}';
    }
}
