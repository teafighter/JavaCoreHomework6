package pro.sky.EmployeeHomework.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.service.DepartmentService;
import pro.sky.EmployeeHomework.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxDeptSalary(Integer department) {
        return employeeService.employeeBook.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee minDeptSalary(Integer department) {
        return employeeService.employeeBook.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getDeptEmployees(Integer department) {
        return employeeService.employeeBook.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupedByDept() {
        return employeeService.employeeBook.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Integer sumDeptSalary(Integer department) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .sum();
    }


}
