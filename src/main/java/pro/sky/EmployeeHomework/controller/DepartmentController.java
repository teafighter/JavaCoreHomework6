package pro.sky.EmployeeHomework.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // GET http://localhost:8080/department/{id}/salary/max
    // возвращает максимальную зарплату по департаменту.
    @GetMapping(path = "{id}/salary/max")
    public Employee maxDeptSalary(@PathVariable("id") @RequestParam(name = "departmentId") Integer department) {
        return departmentService.maxDeptSalary(department);
    }

    // GET http://localhost:8080/department/{id}/salary/min
    // возвращает минимальную зарплату по департаменту.
    @GetMapping(path = "{id}/salary/min")
    public Employee minDeptSalary(@PathVariable("id") @RequestParam(name = "departmentId") Integer department) {
        return departmentService.maxDeptSalary(department);
    }

    // GET http://localhost:8080/department/{id}/employees
    // возвращает список сотрудников по департаменту.
    @GetMapping(path = "{id}/employees")
    public List<Employee> getDeptEmployees(@PathVariable("id") @RequestParam(name = "departmentId") Integer department) {
        return departmentService.getDeptEmployees(department);
    }

    // GET http://localhost:8080/department/employees
    // возвращает сотрудников, сгруппированых по отделам
    // в виде Map<Integer,List<Employees>>,
    // где ключ — это номер отдела, а значение — список сотрудников данного отдела.
    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDept() {
        return departmentService.getEmployeesGroupedByDept();
    }
}
