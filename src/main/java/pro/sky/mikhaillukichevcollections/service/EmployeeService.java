package pro.sky.mikhaillukichevcollections.service;

import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, int salary);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String,Employee> displayEmployees();

    void addTestEmployees();
}
