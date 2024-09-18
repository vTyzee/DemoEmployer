package org.example;

import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private int age;
    private int birthMonth;
    private int birthDay;
    private Address address;

    public Person(String name, String surname, Address address, int age, int birthMonth, int birthDay) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.address = address;

    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public int getAge() {
        return age;
    }



    public Address getAddress() {
        return address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && birthMonth == person.birthMonth && birthDay == person.birthDay && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, birthMonth, birthDay, address);
    }
}
