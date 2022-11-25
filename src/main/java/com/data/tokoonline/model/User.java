package com.data.tokoonline.model;

import com.data.tokoonline.auditing.AudiTable;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User extends AudiTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "username")
    private String username;

    @Column (name = "email")
    private String email;

    @Column (name = "age")
    private Integer age;

    @Lob
    @Column (name = "address")
    private String address;

    @Column (name = "phone_number")
    private Integer phoneNumber;

    public User() {
    }

    public User(Long id, String username, String email, Integer age, String address, Integer phoneNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
