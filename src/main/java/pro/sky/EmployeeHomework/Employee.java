package pro.sky.EmployeeHomework;

import java.util.Objects;

public class Employee {
    private final String firstName; // имя
    private final String lastName; // фамилия
    private Integer salary; // зарплата
    private Integer department; // отдел

    // создание нового сотрудника
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + firstName + " " + lastName;
    }

    public String getFullname() {
        return firstName + " " + lastName;
    }
}
