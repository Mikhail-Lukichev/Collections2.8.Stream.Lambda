package pro.sky.mikhaillukichevcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeesByDepartment(Integer department) {
        return employeeService.getEmployees().values().stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees().values().stream().sorted((e1, e2)->e1.getDepartment().compareTo(e2.getDepartment())).collect(Collectors.toList());
    }

    public Employee findLowestSalaryEmployeeInDepartment(int department) {
        final List<Employee> employeesByDepartment = this.getEmployeesByDepartment(department);
        final List<Integer> salaries = employeesByDepartment.stream().map(employee -> employee.getSalary()).collect(Collectors.toList());
        Optional<Integer> minSalary = salaries.stream().min((a, b) -> a - b);
        Optional<Employee> minSalaryEmployee = employeesByDepartment.stream().filter(employee -> employee.getSalary().equals(minSalary.get())).findAny();
        if (minSalaryEmployee.isPresent()) {
            return minSalaryEmployee.get();
        } else {
            throw new RuntimeException("Min salary employee is not found for department " + department);
        }
    }

    public Employee findHighestSalaryEmployeeInDepartment(int department) {
        final List<Employee> employeesByDepartment = this.getEmployeesByDepartment(department);
        final List<Integer> salaries = employeesByDepartment.stream().map(employee -> employee.getSalary()).collect(Collectors.toList());
        Optional<Integer> maxSalary = salaries.stream().max((i, j) -> i.compareTo(j));
        Optional<Employee> maxSalaryEmployee = employeesByDepartment.stream().filter(employee -> employee.getSalary().equals(maxSalary.get())).findAny();
        if (maxSalaryEmployee.isPresent()) {
            return maxSalaryEmployee.get();
        } else {
            throw new RuntimeException("Max salary employee is not found for department " + department);
        }
    }

}
