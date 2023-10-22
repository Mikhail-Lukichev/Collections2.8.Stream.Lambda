package pro.sky.mikhaillukichevcollections.service;

import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> getAllEmployees();

    Map<Integer, List<Employee>> getDepartmentEmployees(int department);

    Integer getDepartmentSumSalary(int department);

    Employee getDepartmentMaxSalary(int department);

    Employee getDepartmentMinSalary(int department);
}
