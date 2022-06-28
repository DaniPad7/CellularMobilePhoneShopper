package com.phoneshopper.mobile.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity()
@Table()
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    @NotBlank(message = "Username is required")
    private String username;

    @Column()
    @NotBlank(message = "Email is required")
    private String email;

    @Column()
    private Long version;

    public AppUser(Long id, String username, String email, Long version) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.version = version;
    }

    public AppUser() { super(); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && Objects.equals(email, appUser.email) && Objects.equals(version, appUser.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, version);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", version=" + version +
                '}';
    }
}
