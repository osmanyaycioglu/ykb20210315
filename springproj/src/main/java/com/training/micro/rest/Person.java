package com.training.micro.rest;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.training.micro.validation.StartWith;

public class Person {

    @NotEmpty
    @Size(min = 5, max = 20, message = "username 5 ile 20 arasında olmalı")
    private String    username;
    @NotNull(message = "name null olamaz")
    @StartWith(value = "is", message = "İsim is ile başlamalı")
    private String    name;
    @NotEmpty
    @StartWith("soy")
    private String    surname;
    @Past
    private LocalDate birthday;
    @Positive
    @Max(300)
    @Min(70)
    private Integer   weight;
    private EGender   gender;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final LocalDate birthdayParam) {
        this.birthday = birthdayParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", birthday="
               + this.birthday
               + ", weight="
               + this.weight
               + ", gender="
               + this.gender
               + "]";
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }


}
