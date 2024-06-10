package pro.sky.EmployeeHomework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
    // /departments/max-salary?departmentId=5
    @GetMapping(path = "/max-salary")
    public Employee maxDeptSalary(@RequestParam(name = "departmentId") Integer department) {
        return departmentService.maxDeptSalary(department);
    }

    //2.  Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
    // /departments/min-salary?departmentId=5
    @GetMapping(path = "/min-salary")
    public Employee minDeptSalary(@RequestParam(name = "departmentId") Integer department) {
        return departmentService.maxDeptSalary(department);
    }

    //3. Возвращать всех сотрудников по отделу.
    //departments/all?departmentId=5
    @GetMapping(path = "/all")
    public List<Employee> getDeptEmployees(@RequestParam(name = "departmentId") Integer department) {
        return departmentService.getDeptEmployees(department);
    }

    //4. Возвращать всех сотрудников с разделением по отделам.
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDept() {
        return departmentService.getEmployeesGroupedByDept();
    }
}
