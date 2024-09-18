package org.example.manager;

import org.example.Employer;
import org.example.Address;
import org.example.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployerManage {
    private final List<Employer> employers = new ArrayList<>(); // Список работников

    // Метод для создания нового работника
    public void createEmployee(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();

        System.out.println("Введите дату рождения (дд мм гггг):");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine(); // Поглощаем символ новой строки

        System.out.println("Введите должность:");
        String appointment = scanner.nextLine();

        System.out.println("Введите зарплату:");
        String salary = scanner.nextLine();

        System.out.println("Введите адрес:");
        System.out.println("Город:");
        String city = scanner.nextLine();
        System.out.println("Область:");
        String state = scanner.nextLine();
        System.out.println("Индекс:");
        String zip = scanner.nextLine();
        System.out.println("Улица:");
        String street = scanner.nextLine();
        System.out.println("Дом:");
        String house = scanner.nextLine();
        System.out.println("Квартира:");
        String room = scanner.nextLine();

        Address address = new Address();
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);
        address.setStreet(street);
        address.setHouse(house);
        address.setRoom(room);

        Person person = new Person(name, surname, address, day, month, year);

        Employer employer = new Employer(person, appointment, salary);

        employers.add(employer); // Добавляем нового работника в список
        System.out.println("Работник добавлен успешно!");
    }

    // Метод для отображения списка всех работников
    public void list() {
        if (employers.isEmpty()) {
            System.out.println("Нет работников в списке.");
        } else {
            for (Employer employer : employers) {
                printEmployerInfo(employer);
            }
        }
    }

    // Метод для поиска работника по имени и фамилии
    public void findEmployeeByName(Scanner scanner) {
        System.out.println("Введите имя:");
        String searchName = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String searchSurname = scanner.nextLine();

        boolean found = false;
        for (Employer employer : employers) {
            if (employer.getPerson().getName().equalsIgnoreCase(searchName) &&
                    employer.getPerson().getSurname().equalsIgnoreCase(searchSurname)) {
                printEmployerInfo(employer);
                found = true;
                break; // Если найден, выходим из цикла
            }
        }

        if (!found) {
            System.out.println("Работник не найден.");
        }
    }

    // Метод для редактирования существующего работника
    public void editEmployee(Scanner scanner) {
        System.out.println("Введите имя сотрудника для редактирования:");
        String searchName = scanner.nextLine();

        System.out.println("Введите фамилию сотрудника для редактирования:");
        String searchSurname = scanner.nextLine();

        Employer employerToEdit = null;
        for (Employer employer : employers) {
            if (employer.getPerson().getName().equalsIgnoreCase(searchName) &&
                    employer.getPerson().getSurname().equalsIgnoreCase(searchSurname)) {
                employerToEdit = employer;
                break;  // Останавливаем цикл, так как сотрудник найден
            }
        }

        if (employerToEdit != null) {
            System.out.println("Выберите, что вы хотите отредактировать:");
            System.out.println("1. Имя");
            System.out.println("2. Фамилия");
            System.out.println("3. Должность");
            System.out.println("4. Зарплата");
            System.out.println("5. Адрес");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Поглощаем символ новой строки

            switch (choice) {
                case 1:
                    System.out.println("Введите новое имя:");
                    String newName = scanner.nextLine();
                    employerToEdit.getPerson().setName(newName);
                    System.out.println("Имя изменено успешно.");
                    break;
                case 2:
                    System.out.println("Введите новую фамилию:");
                    String newSurname = scanner.nextLine();
                    employerToEdit.getPerson().setSurname(newSurname);
                    System.out.println("Фамилия изменена успешно.");
                    break;
                case 3:
                    System.out.println("Введите новую должность:");
                    String newAppointment = scanner.nextLine();
                    employerToEdit.setAppointment(newAppointment);
                    System.out.println("Должность изменена успешно.");
                    break;
                case 4:
                    System.out.println("Введите новую зарплату:");
                    String newSalary = scanner.nextLine();
                    employerToEdit.setSalary(newSalary);
                    System.out.println("Зарплата изменена успешно.");
                    break;
                case 5:
                    System.out.println("Редактирование адреса:");
                    System.out.println("Город:");
                    String newCity = scanner.nextLine();
                    System.out.println("Область:");
                    String newState = scanner.nextLine();
                    System.out.println("Индекс:");
                    String newZip = scanner.nextLine();
                    System.out.println("Улица:");
                    String newStreet = scanner.nextLine();
                    System.out.println("Дом:");
                    String newHouse = scanner.nextLine();
                    System.out.println("Квартира:");
                    String newRoom = scanner.nextLine();

                    Address newAddress = new Address();
                    newAddress.setCity(newCity);
                    newAddress.setState(newState);
                    newAddress.setZip(newZip);
                    newAddress.setStreet(newStreet);
                    newAddress.setHouse(newHouse);
                    newAddress.setRoom(newRoom);

                    employerToEdit.getPerson().setAddress(newAddress);
                    System.out.println("Адрес изменен успешно.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }

    // Вспомогательный метод для вывода информации о работнике
    private void printEmployerInfo(Employer employer) {
        System.out.printf(
                "Имя: %s, Фамилия: %s, Возраст: %d, Должность: %s, Зарплата: %s, Адрес: %s, %s, %s, %s\n",
                employer.getPerson().getName(),
                employer.getPerson().getSurname(),
                employer.getPerson().getAge(),
                employer.getAppointment(),
                employer.getSalary(),
                employer.getPerson().getAddress().getCity(),
                employer.getPerson().getAddress().getStreet(),
                employer.getPerson().getAddress().getHouse(),
                employer.getPerson().getAddress().getState()
        );
    }
}
