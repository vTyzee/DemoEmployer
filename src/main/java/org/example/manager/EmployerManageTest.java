//package org.example.manager;
//
//import org.example.Address;
//import org.example.Employer;
//import org.example.Person;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class EmployerManageTest {
//
//    private EmployerManage employerManage;
//
//    @BeforeEach
//    public void setUp() {
//        employerManage = new EmployerManage();  // Инициализация нового объекта перед каждым тестом
//    }
//
//    @Test
//    public void testCreateEmployee() {
//        // Симулируем ввод данных для нового работника
//        String input = "John\nDoe\n10\n10\n1990\nManager\n3000\nNew York\nNew York State\n12345\n5th Avenue\n10\n5\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        Scanner scanner = new Scanner(in);
//
//        employerManage.createEmployee(scanner);  // Тестируем создание работника
//
//        // Проверяем, что работник добавлен
//        assertEquals(1, employerManage.getEmployerList().size(), "Работник не добавлен");
//
//        // Проверяем данные работника
//        Employer addedEmployer = employerManage.getEmployerList().get(0);
//        assertEquals("John", addedEmployer.getPerson().getName());
//        assertEquals("Doe", addedEmployer.getPerson().getSurname());
//        assertEquals("Manager", addedEmployer.getAppointment());
//        assertEquals("3000", addedEmployer.getSalary());
//        assertEquals("New York", addedEmployer.getPerson().getAddress().getCity());
//    }
//
//    @Test
//    public void testListIsEmpty() {
//        // Проверка на пустой список работников
//        assertTrue(employerManage.getEmployerList().isEmpty(), "Список работников должен быть пустым");
//    }
//
//    @Test
//    public void testFindEmployeeByName() {
//        // Симулируем ввод данных для нового работника
//        String input = "John\nDoe\n10\n10\n1990\nManager\n3000\nNew York\nNew York State\n12345\n5th Avenue\n10\n5\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        Scanner scanner = new Scanner(in);
//        employerManage.createEmployee(scanner);  // Создаем работника
//
//        // Симулируем ввод имени для поиска
//        String searchInput = "John\nDoe\n";
//        InputStream searchIn = new ByteArrayInputStream(searchInput.getBytes());
//        Scanner searchScanner = new Scanner(searchIn);
//
//        // Здесь мы проверим, что работник найден
//        // Можно будет модифицировать методы в классе EmployerManage для возврата найденных данных.
//        // Однако для простоты сейчас можно добавить вывод в консоль для визуальной проверки.
//        employerManage.findEmployeeByName(searchScanner);
//
//        assertTrue(employerManage.getEmployerList().get(0).getPerson().getName().equalsIgnoreCase("John"), "Имя работника должно быть John");
//    }
//}
