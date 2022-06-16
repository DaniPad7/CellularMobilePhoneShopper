package com.phoneshopper.mobile.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(/*schema = "mobile_phones"*/)
public class CellPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    private Long mobileIdentificationNumber;

    @Column(unique = true, updatable = false, nullable = false)
    private Long internationalMobileEquipmentIdentity;

    @Column()
    private String maker;

    @Column()
    private Short year;

    @Column()
    private String color;

    @Column()
    private String model;

    @Column()
    private String modelNumber;

    @Column()
    private Long version;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<AppUser> users = new HashSet<>();

    public CellPhone(Long id, Long mobileIdentificationNumber, Long internationalMobileEquipmentIdentity, String maker, Short year, String color, String model, String modelNumber, Long version, Set<AppUser> users) {
        this.id = id;
        this.mobileIdentificationNumber = mobileIdentificationNumber;
        this.internationalMobileEquipmentIdentity = internationalMobileEquipmentIdentity;
        this.maker = maker;
        this.year = year;
        this.color = color;
        this.model = model;
        this.modelNumber = modelNumber;
        this.version = version;
        this.users = users;
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

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPhone cellPhone = (CellPhone) o;
        return Objects.equals(id, cellPhone.id) && Objects.equals(mobileIdentificationNumber, cellPhone.mobileIdentificationNumber) && Objects.equals(internationalMobileEquipmentIdentity, cellPhone.internationalMobileEquipmentIdentity) && Objects.equals(maker, cellPhone.maker) && Objects.equals(year, cellPhone.year) && Objects.equals(color, cellPhone.color) && Objects.equals(model, cellPhone.model) && Objects.equals(modelNumber, cellPhone.modelNumber) && Objects.equals(version, cellPhone.version) && Objects.equals(users, cellPhone.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mobileIdentificationNumber, internationalMobileEquipmentIdentity, maker, year, color, model, modelNumber, version, users);
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
                ", users=" + users +
                '}';
    }
}
