package pro.sky.mikhaillukichevcollections.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.mikhaillukichevcollections.model.Employee;
import pro.sky.mikhaillukichevcollections.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/employees")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getAllEmployees();
    }

    @GetMapping("{id}/employees")
    public Map<Integer, List<Employee>> getDepartmentEmployees(@PathVariable int id) {
        return departmentService.getDepartmentEmployees(id);
    }

    @GetMapping("{id}/salary/sum")
    public Integer getDepartmentSumSalary(@PathVariable int id) {
        return departmentService.getDepartmentSumSalary(id);
    }

    @GetMapping("{id}/salary/max")
    public Employee getDepartmentMaxSalary(@PathVariable int id) {
        return departmentService.getDepartmentMaxSalary(id);
    }

    @GetMapping("{id}/salary/min")
    public Employee getDepartmentMinSalary(@PathVariable int id) {
        return departmentService.getDepartmentMinSalary(id);
    }
}
