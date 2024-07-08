package pro.sky.EmployeeHomework.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.service.impl.DepartmentServiceImpl;
import pro.sky.EmployeeHomework.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    private final List<Employee> employeeList = new ArrayList<>() {{
        add(new Employee("Test", "A"));
        add(new Employee("Test", "B"));
        add(new Employee("Test", "C"));
        add(new Employee("Test", "D"));
        add(new Employee("Test", "E"));
    }};
    private final Map<String, Employee> employees = new HashMap<>();

    @BeforeEach
    public void initMap() {
        for (Employee employee :
                employeeList) {
            employees.put(employee.getFullname(), employee);
        }
    }

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test // тест на поиск сотрудников по отделам
    public void shouldGetEmployees() {
        //  given
        Integer department = 1;
        List<Employee> expectedEmployees = List.of();
        // then
        List<Employee> actualEmployees = departmentService.getDeptEmployees(department);
        //  then
        Assertions
                .assertThat(actualEmployees).containsExactlyInAnyOrderElementsOf(expectedEmployees);
    }

    @Test // тест на поиск сотрудника с минимальной зарплатой
    public void shouldGetMinSalary() {
        //  given
        Integer department = 1;
        Employee expectedMinSalaryEmployee = null;
        // then
        Employee actualMinSalaryEmployee = departmentService.minDeptSalary(department);
        //  then
        org.junit.jupiter.api.Assertions.assertEquals(expectedMinSalaryEmployee, actualMinSalaryEmployee);
    }

    @Test // тест на поиск сотрудника с максимальной зарплатой
    public void shouldGetMaxSalary() {
        //  given
        Integer department = 1;
        Employee expectedMaxSalaryEmployee = null;
        // then
        Employee actualMaxSalaryEmployee = departmentService.maxDeptSalary(department);
        //  then
        org.junit.jupiter.api.Assertions.assertEquals(expectedMaxSalaryEmployee, actualMaxSalaryEmployee);
    }

    @Test // тест на подсчет суммы зарплат в отделе
    public void shouldSumSalary() {
        //  given
        Integer department = 1;
        Integer expectedSumSalary = 0;
        // then
        Integer actualSumSalary = departmentService.sumDeptSalary(department);
        //  then
        org.junit.jupiter.api.Assertions.assertEquals(expectedSumSalary, actualSumSalary);
    }

    @Test // тест на группировку по отделам
    public void shouldGroupByDept() {

        // given
        Map<Integer, List<Employee>> expectedGroupedEmployees = new HashMap<>();
        // when
        Map<Integer, List<Employee>> actualGroupedEmployees = departmentService.getEmployeesGroupedByDept();
        // then
        Assertions.assertThat(actualGroupedEmployees).isEqualTo(expectedGroupedEmployees);
    }
}