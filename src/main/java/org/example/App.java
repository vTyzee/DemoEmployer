package org.example;

import org.example.manager.EmployerManage;

import java.util.Scanner;

public class App {
    public void run() {
        EmployerManage employerManage = new EmployerManage(); // Создаем объект для управления работниками
        boolean exitFromPro = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("HR");
        System.out.println("---------------------");

        do {
            System.out.println("Список задач:");
            System.out.println("0. Exit");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список всех работников");
            System.out.println("3. Работники по имени и фамилии");
            System.out.println("4: Редактировать запись");
            System.out.print("Выберите задачу: ");

            int task = scanner.nextInt();
            scanner.nextLine(); // Поглощаем символ новой строки

            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    exitFromPro = true;
                    break;
                case 1:
                    employerManage.createEmployee(scanner); // Вызываем метод для добавления работника
                    break;
                case 2:
                    employerManage.list(); // Вызываем метод для отображения списка работников
                    break;
                case 3:
                    employerManage.findEmployeeByName(scanner); // Вызываем метод для поиска по имени
                    break;
                case 4:
                    employerManage.editEmployee(scanner); // Вызываем метод для редактироние
                    break;
                default:
                    System.out.println("Ошибка: неверный номер");
                    break;
            }
        } while (!exitFromPro);

        System.out.println("heat aega!");
        scanner.close();
    }
}
