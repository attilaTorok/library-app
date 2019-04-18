package com.library.dto;

import java.time.LocalDateTime;

public class AuthorDto {

    private Long id;	
    private String lastName;
    private String firstName;
    private LocalDateTime dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "AuthorDto [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + "]";
    }

}
