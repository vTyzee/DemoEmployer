package org.example;

import java.util.Objects;

public class Employer {
    private Person person;
    private String appointment;
    private String salary;

    public Employer(Person person, String appointment, String salary) {
        this.person = person;
        this.appointment = appointment;
        this.salary = salary;
    }

    // Геттеры
    public Person getPerson() {
        return person;
    }

    public String getAppointment() {
        return appointment;
    }

    public String getSalary() {
        return salary;
    }

    // Сеттеры
    public void setPerson(Person person) {
        this.person = person;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    // equals и hashCode для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(person, employer.person) && Objects.equals(appointment, employer.appointment) && Objects.equals(salary, employer.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, appointment, salary);
    }
}
