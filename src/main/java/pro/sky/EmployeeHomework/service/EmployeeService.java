package pro.sky.EmployeeHomework.service;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeHomework.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> employeeBook = new ArrayList<>(List.of(
            new Employee("Petr", "Petrov"),
            new Employee("Nikolai", "Nikolaev"),
            new Employee("Fedor", "Fedorov"),
            new Employee("Anton", "Antonov")));

    int maxEmployees = 5;

    Employee findEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();
}