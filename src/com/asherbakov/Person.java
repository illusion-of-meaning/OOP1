package com.asherbakov;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private LocalDate dateOfBirthday;
    private String firstName;
    private String city;

    private String job;

    public Person(LocalDate dateOfBirthday, String firstName, String city) {
        this.dateOfBirthday = dateOfBirthday;
        if (firstName.isBlank()) {
            this.firstName = "Информация не указана";
        } else {
            this.firstName = firstName;
        }
        if (city.isBlank()) {
            this.city = "Информация не указана";
        } else {
            this.city = city;
        }
    }

    public Person(LocalDate dateOfBirthday, String firstName, String city, String job) {
        this.dateOfBirthday = dateOfBirthday;
        if (firstName.isBlank()) {
            this.firstName = "Информация не указана";
        } else {
            this.firstName = firstName;
        }
        if (city.isBlank()) {
            this.city = "Информация не указана";
        } else {
            this.city = city;
        }
        if (job.isBlank()) {
            this.job = "Информация не указана";
        } else {
            this.job = job;
        }
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        if (dateOfBirthday != null) {
            this.dateOfBirthday = dateOfBirthday;
        } else {
            this.dateOfBirthday = LocalDate.MIN;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null && !city.isBlank()) {
            this.city = city;
        } else {
            this.city = "Информация не указана";
        }
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        String result = "";
        if (this.job == null) {
            result = String.format("Привет! Меня зовут %s. Я из города %s. Я родился в %s году. Будем знакомы!", firstName, city, dateOfBirthday);
        } else {
            result = String.format("Привет! Меня зовут %s. Я из города %s. Я родился в %s году. Я работаю на должности %s. Будем знакомы!", firstName, city, dateOfBirthday, job);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return dateOfBirthday.equals(person.dateOfBirthday) && firstName.equals(person.firstName) && city.equals(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirthday, firstName, city);
    }
}
