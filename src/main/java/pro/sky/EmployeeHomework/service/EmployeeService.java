package pro.sky.EmployeeHomework.service;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeHomework.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public interface EmployeeService {
    Map<String, Employee> employeeBook = new HashMap<>();

    int maxEmployees = 5;

    Employee findEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}