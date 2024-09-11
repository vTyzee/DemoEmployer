package org.example;

public class App {
    public void run() {
        // Creating Address instance and setting values
        Address address = new Address();
        address.setCity("Йыхви");
        address.setState("Ида-Вирумаа");
        address.setZip("41536");
        address.setStreet("Нарвское шоссе");
        address.setHouse("80");
        address.setRoom("69");

        // Creating Person and Employer objects
        Person person = new Person("Ivan", "Ivanov", address, 10, 10, 2000);
        Employer employer = new Employer(person, "Директор", "3000");

        // Corrected System.out.printf with arguments passed correctly
        System.out.printf(
                "Name: %s, Surname: %s, Age: %d, Position: %s, Salary: %s, Living in: %s, %s, %s, %s\n",
                employer.getPerson().getName(),                         // Name
                employer.getPerson().getSurname(),                      // Surname
                employer.getPerson().getAge(),                          // Age
                employer.getAppointment(),                              // Position
                employer.getSalary(),                                   // Salary
                employer.getPerson().getAddress().getCity(),            // City
                employer.getPerson().getAddress().getStreet(),          // Street
                employer.getPerson().getAddress().getHouse(),           // House
                employer.getPerson().getAddress().getState()            // State
        );
    }
}
