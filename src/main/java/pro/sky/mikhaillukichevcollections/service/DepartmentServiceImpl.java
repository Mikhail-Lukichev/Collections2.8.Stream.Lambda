package pro.sky.mikhaillukichevcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.mikhaillukichevcollections.exception.EmployeeNotFoundException;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<Integer, List<Employee>> getDepartmentEmployees(int department) {
        return employeeService.getEmployeesByDepartment(department).stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Integer getDepartmentSumSalary(int department) {
        return employeeService.getEmployeesByDepartment(department).stream()
                .mapToInt(Employee::getSalary).sum();
    }

    public Employee getDepartmentMaxSalary(int department) {
        return employeeService.getEmployeesByDepartment(department).stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Max salary employee is not found for department " + department));
    }

    public Employee getDepartmentMinSalary(int department) {
        return employeeService.getEmployeesByDepartment(department).stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Min salary employee is not found for department " + department));
    }

}
