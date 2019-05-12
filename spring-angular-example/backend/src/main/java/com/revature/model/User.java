package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.model.dto.RegistrationForm;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author William Gentry
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id
    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private String firstname;

    private String lastname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")

    public static User fromRegistrationForm(RegistrationForm registrationForm) {
        User user = new User();
        user.setUsername(registrationForm.getUsername());
        user.setEmail(registrationForm.getEmail());
        user.setFirstname(registrationForm.getFirstname());
        user.setLastname(registrationForm.getLastname());
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email, firstname, lastname);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("email='" + email + "'")
                .add("firstname='" + firstname + "'")
                .add("lastname='" + lastname + "'")
                .toString();
    }
}
