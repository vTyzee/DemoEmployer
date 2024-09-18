package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private Address address;

    public Person(String name, String surname, Address address, int birthDay, int birthMonth, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.address = address;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return calculateAge();  // Возраст рассчитывается на основе даты рождения
    }

    public Address getAddress() {
        return address;
    }

    // Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // Вычисление возраста на основе даты рождения
    private int calculateAge() {
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear &&
                birthMonth == person.birthMonth &&
                birthDay == person.birthDay &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(address, person.address);
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthYear, birthMonth, birthDay, address);
    }

    // Метод toString для удобного вывода информации
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + getAge() +
                ", address=" + address +
                '}';
    }
}
