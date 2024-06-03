package pro.sky.EmployeeHomework.service;

import pro.sky.EmployeeHomework.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    //1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
    //departments/max-salary?departmentId=5
    Employee maxDeptSalary(Integer department);

    //2.  Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
    //  /departments/min-salary?departmentId=5
    Employee minDeptSalary(Integer department);

    //3. Возвращать всех сотрудников по отделу.
    //departments/all?departmentId=5
    List<Employee> getDeptEmployees(Integer department);

    //4. Возвращать всех сотрудников с разделением по отделам.
    Map<Integer, List<Employee>> getEmployeesGroupedByDept();
}
