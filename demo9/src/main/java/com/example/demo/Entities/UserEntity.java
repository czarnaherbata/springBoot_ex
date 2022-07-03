package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 20)
    //@NotEmpty
    //@NotBlank(message = "Wprowadź imie")
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
   // @NotEmpty
   // @NotBlank(message = "Wprowadź nazwisko")
    private String lastName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
