package pro.sky.mikhaillukichevcollections.service;

import org.hamcrest.core.AnyOf;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.mikhaillukichevcollections.exception.EmployeeNotFoundException;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static pro.sky.mikhaillukichevcollections.service.utils.EmployeeGenerator.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void getAllEmployees_success() {
        //Data preparation
        int department1 = DEPARTMENT_1;
        int department2 = DEPARTMENT_2;

        //Expected result
        when(employeeService.getEmployees()).thenReturn(getAllEmployees());
        Map<Integer, List<Employee>> expectedResult = new HashMap<>();
        expectedResult.put(department1, Arrays.asList(getEmployee2(), getEmployee1()));
        expectedResult.put(department2, List.of(getEmployee3()));

        //Test execution
        Map<Integer, List<Employee>> actualResult = departmentService.getAllEmployees();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDepartmentEmployees_success() {
        //Data preparation
        int department1 = DEPARTMENT_1;

        //Expected result
        when(employeeService.getEmployeesByDepartment(anyInt())).thenReturn(getDepartment1Employees());
        Map<Integer, List<Employee>> expectedResult = new HashMap<>();
        expectedResult.put(department1, List.of(getEmployee1(), getEmployee2()));

        //Test execution
        Map<Integer, List<Employee>> actualResult = departmentService.getDepartmentEmployees(department1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDepartmentSumSalary_success() {
        //Data preparation
        int department = DEPARTMENT_1;

        //Expected result
        when(employeeService.getEmployeesByDepartment(anyInt())).thenReturn(getDepartment1Employees());
        int expectedResult = SALARY + SALARY_2;

        //Test execution
        int actualResult = departmentService.getDepartmentSumSalary(department);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDepartmentMaxSalary_success() {
        //Data preparation
        int department = DEPARTMENT_1;

        //Expected result
        when(employeeService.getEmployeesByDepartment(anyInt())).thenReturn(getDepartment1Employees());
        Employee expectedEmployee = getEmployee2();

        //Test execution
        Employee actualEmployee = departmentService.getDepartmentMaxSalary(department);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void getDepartmentMaxSalary_withEmployeeNotFoundException() {
        //Data preparation
        int department = DEPARTMENT_1;

        //Expected result
        when(employeeService.getEmployeesByDepartment(anyInt())).thenReturn(getEmptyListOfEmployees());
        String expectedMessage = "Max salary employee is not found for department " + department;

        //Test execution
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.getDepartmentMaxSalary(department)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getDepartmentMinSalary_success() {
        //Data preparation
        int department = DEPARTMENT_1;

        //Expected result
        when(employeeService.getEmployeesByDepartment(anyInt())).thenReturn(getDepartment1Employees());
        Employee expectedEmployee = getEmployee1();

        //Test execution
        Employee actualEmployee = departmentService.getDepartmentMinSalary(department);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void getDepartmentMinSalary_withEmployeeNotFoundException() {
        //Data preparation
        int department = DEPARTMENT_1;

        //Expected result
        when(employeeService.getEmployeesByDepartment(anyInt())).thenReturn(getEmptyListOfEmployees());
        String expectedMessage = "Min salary employee is not found for department " + department;

        //Test execution
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.getDepartmentMinSalary(department)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }
}