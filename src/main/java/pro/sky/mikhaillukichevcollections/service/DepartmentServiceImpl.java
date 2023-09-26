package pro.sky.mikhaillukichevcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeesByDepartment(Integer department) {
        return employeeService.getEmployees().values().stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Employee findLowestSalaryEmployeeInDepartment(int department) {
        return employeeService.getEmployees().values().stream()
            .filter(employee -> employee.getDepartment().equals(department))
            .min(Comparator.comparingInt(Employee::getSalary))
            .orElseThrow(() -> new RuntimeException("Min salary employee is not found for department " + department));
    }

    public Employee findHighestSalaryEmployeeInDepartment(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Max salary employee is not found for department " + department));
    }

}
