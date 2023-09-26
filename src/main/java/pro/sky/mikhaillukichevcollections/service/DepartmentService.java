package pro.sky.mikhaillukichevcollections.service;

import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findLowestSalaryEmployeeInDepartment(int department);
    Employee findHighestSalaryEmployeeInDepartment(int department);
    List<Employee> getEmployeesByDepartment(Integer departmentId);
    Map<Integer, List<Employee>> getAllEmployees();
}
