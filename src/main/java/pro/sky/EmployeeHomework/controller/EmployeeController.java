package pro.sky.EmployeeHomework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.EmployeeHomework.Employee;
import pro.sky.EmployeeHomework.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String welcome() { // для проверки, что спринг отзывается
        return "Добро пожаловать в отдел кадров";
    }

    @GetMapping(path = "/add")
    // По адресу /employee/add?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON
    // { "firstName": "Ivan", "lastName": "Ivanov" },
    // или исключение ArrayIsFull в случае переполнения коллекции
    // или EmployeeAlreadyAdded в случае, когда сотрудник уже существует.
    public Employee addEmployee(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    // По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    // { "firstName": "Ivan", "lastName": "Ivanov" },
    // или исключение со статусом EmployeeNotFound, если сотрудник отсутствует.
    @GetMapping(path = "/remove")
    public Employee fireEmployee(@RequestParam(name = "firstName", required = false) String firstName, @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    // По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
    // { "firstName": "Ivan", "lastName": "Ivanov" },
    // или исключение со статусом EmployeeNotFound, если такой сотрудник отсутствует.
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(name = "firstName", required = false) String firstName, @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/allEmployees")
    public Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
