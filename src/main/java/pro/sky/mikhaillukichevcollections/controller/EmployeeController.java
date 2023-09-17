package pro.sky.mikhaillukichevcollections.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.mikhaillukichevcollections.model.Employee;
import pro.sky.mikhaillukichevcollections.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Map<String, Employee> displayEmployees() {
        return employeeService.displayEmployees();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName,
                                @RequestParam(value = "department") int department,
                                @RequestParam(value = "salary") int salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path="/addTestEmployees")
    public String addTestEmployees() {
        employeeService.addTestEmployees();
        return "Test employees have been added";
    }
}
