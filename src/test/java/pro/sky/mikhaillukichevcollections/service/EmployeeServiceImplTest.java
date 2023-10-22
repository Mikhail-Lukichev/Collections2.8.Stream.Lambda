package pro.sky.mikhaillukichevcollections.service;

import org.junit.jupiter.api.Test;
import pro.sky.mikhaillukichevcollections.exception.EmployeeAlreadyAddedException;
import pro.sky.mikhaillukichevcollections.exception.EmployeeNotFoundException;
import pro.sky.mikhaillukichevcollections.exception.EmployeeStorageIsFullException;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.Map;
import java.util.List;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final EmployeeService out = new EmployeeServiceImpl();

    @Test
    void getEmployees_success() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        Map<String, Employee> expectedResult = Map.of(firstName+lastName,new Employee(firstName,lastName,department,salary));

        //Test execution
        out.addEmployee(firstName,lastName,department,salary);
        Map<String, Employee> actualResult = out.getEmployees();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getEmployeesByDepartment_success() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        List<Employee> expectedResult = List.of(new Employee(firstName,lastName,department,salary));

        //Test execution
        out.addEmployee(firstName,lastName,department,salary);
        List<Employee> actualResult = out.getEmployeesByDepartment(department);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void addEmployee_success() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        Employee expectedResult = new Employee(firstName, lastName, department, salary);

        //Test execution
        Employee actualResult = out.addEmployee(firstName, lastName, department, salary);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addEmployee_withEmployeeStorageIsFullException() {

        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        String expectedMessage = "Exception: adding employee " + firstName + " " + lastName + ". Cannot add employee. Storage is full";

        //Test execution
        for (int i = 0; i < out.getEmployeeMaxCount(); i++) {
            out.addEmployee(firstName + valueOf(i), lastName + valueOf(i), department, salary);
        }

        Exception exception = assertThrows(EmployeeStorageIsFullException.class,
                () -> out.addEmployee(firstName, lastName, department, salary)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addEmployee_withEmployeeAlreadyAddedException() {

        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        String expectedMessage = "Exception: adding employee " + firstName + " " + lastName + ". Such employee has been already added";

        //Test execution
        out.addEmployee(firstName, lastName, department, salary);
        Exception exception = assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(firstName, lastName, department, salary)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void removeEmployee_success() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        Employee expectedResult = new Employee(firstName, lastName, department, salary);

        //Test execution
        out.addEmployee(firstName, lastName, department, salary);
        Employee actualResult = out.removeEmployee(firstName,lastName);
        assertEquals(expectedResult,actualResult);

    }

    @Test
    void removeEmployee_withEmployeeNotFoundException() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";

        //Expected result preparation
        String expectedMessage = "Exception: removing employee " + firstName + " " + lastName + ". Employee not found";

        //Test execution
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(firstName,lastName)
                );
        assertEquals(expectedMessage,exception.getMessage());

    }

    @Test
    void findEmployee_success() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";
        int department = 1;
        int salary = 29000;

        //Expected result preparation
        Employee expectedResult = new Employee(firstName,lastName,department,salary);

        //Test execution
        out.addEmployee(firstName,lastName,department,salary);
        Employee actualResult = out.findEmployee(firstName,lastName);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void findEmployee_withEmployeeNotFoundException() {
        //Data preparation
        String firstName = "John";
        String lastName = "Tainsh";

        //Expected result preparation
        String expectedMessage = "Exception: finding employee " + firstName + " " + lastName + ". Employee not found";

        //Test execution
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(firstName,lastName)
                );
        assertEquals(expectedMessage,exception.getMessage());
    }
}