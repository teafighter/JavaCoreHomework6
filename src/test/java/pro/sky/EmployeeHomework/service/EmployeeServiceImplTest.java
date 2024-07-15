package pro.sky.EmployeeHomework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.EmployeeHomework.Exceptions.EmployeeNotFoundException;
import pro.sky.EmployeeHomework.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    // тесты добавления нового сотрудника
    @BeforeEach
    public void init() {
        employeeService.addEmployee("Ivan", "Petrov");
        employeeService.addEmployee("Ivan", "Ivanov");
        employeeService.addEmployee("Ivan", "Sidorov");
        employeeService.addEmployee("Ivan", "Pupkin");
    }
    @Test // тест на выброс исключения, если сотрудник уже добавлен
    public void should_ThrowEmployeeAlreadyAddedException_When_EmployeeAlreadyExists() {

        // given
        // when
        // then
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Ivan", "Petrov")
        );
    }

    @Test // тест на выброс исключения, если хранилище сотрудников переполнено
    public void should_ThrowEmployeeStorageIsFullException_When_EmployeeStorageIsFull() {
        // given
        employeeService.addEmployee("Ivan", "Koshkin");
        // when
        // then
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Ivan", "Petrov")
        );
    }

    @Test // тест на выброс исключения, если сотрудник не найден
    public void should_ThrowEmployeeNotFoundException_When_EmployeeIsNotFound() {

        // given
        // when
        // then
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee("testFirstName", "TestLastName")
        );
    }

    @Test // тест на поиск сотрудника
    public void shouldCorrectlyFindEmployee() {
        // given
        Employee expectedResult = new Employee("Ivan", "Petrov");

        // when
        Employee actualResult = employeeService.findEmployee("Ivan", "Petrov");

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test // тест на добавление нового сотрудника
    public void shouldCorrectlyAddEmployee() {
        // given
        Employee expectedResult = new Employee("testName", "testLastName");

        // when
        Employee actualResult = employeeService.addEmployee("testName", "testLastName");

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test // тест на удаление сотрудника
    public void shouldCorrectlyRemoveEmployee() {
        // given
        Employee expectedResult = new Employee("Ivan", "Petrov");

        // when
        Employee actualResult = employeeService.removeEmployee("Ivan", "Petrov");

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
