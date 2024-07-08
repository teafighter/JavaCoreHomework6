package pro.sky.EmployeeHomework.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.EmployeeHomework.Exceptions.EmployeeNotFoundException;
import pro.sky.EmployeeHomework.Exceptions.EmployeeStorageIsFullException;
import pro.sky.EmployeeHomework.service.EmployeeService;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @PostConstruct
    public void init() {
        addEmployee("Ivan", "Petrov");
        addEmployee("Ivan", "Ivanov");
        addEmployee("Ivan", "Sidorov");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employeeToFind.getFullname())) {
            return employeeToFind;
        } else throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employeeToAdd.getFullname())) {
            throw new EmployeeAlreadyAddedException("Добавляемый сотрудник уже имеется");
        }
        if (employeeBook.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Хранилище сотрудников переполнено");
        }
        employeeBook.put(employeeToAdd.getFullname(), employeeToAdd);
        return employeeToAdd;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeToFire = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employeeToFire.getFullname())) {
            employeeBook.remove(employeeToFire.getFullname());
            return employeeToFire;
        } else throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employeeBook;
    }
}