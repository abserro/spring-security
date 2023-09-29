package com.example.SecurityApp.entity;

import com.example.SecurityApp.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "user_account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String username;
    @Column(name = "first_name")
    @Size(max = 30, message = "First name must be up to 30 characters long")
    private String firstName;
    @Column(name = "last_name")
    @Size(max = 30, message = "Last name must be up to 30 characters long")
    private String lastName;
    @Email
    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Invalid email address")
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "account_enabled", nullable = false)
    private boolean accountEnabled;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @CreationTimestamp
    @Column(name = "registration_date")
    private Date dateRegistered;

    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private Role role;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
