package pro.sky.mikhaillukichevcollections.service.utils;

import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

public class EmployeeGenerator {
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Tainsh";
    public static final int SALARY = 29000;
    public static final String FIRST_NAME_2 = "Sarah";
    public static final String LAST_NAME_2 = "Edwards";
    public static final int SALARY_2 = 32000;

    public static final String FIRST_NAME_3 = "Dana";
    public static final String LAST_NAME_3 = "Vrieze";
    public static final int SALARY_3 = 30000;
    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_2 = 2;

    public static Employee getEmployee1() {
        return new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_1, SALARY);
    }

    public static Employee getEmployee2() {
        return new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_2);
    }

    public static Employee getEmployee3() {
        return new Employee(FIRST_NAME_3, LAST_NAME_3, DEPARTMENT_2, SALARY_3);
    }

    public static Map<String, Employee> getAllEmployees() {
        Map<String, Employee> result = new HashMap<>();
        result.put(EmployeeGenerator.FIRST_NAME+EmployeeGenerator.LAST_NAME, getEmployee1());
        result.put(EmployeeGenerator.FIRST_NAME_2+EmployeeGenerator.LAST_NAME_2, getEmployee2());
        result.put(EmployeeGenerator.FIRST_NAME_3+EmployeeGenerator.LAST_NAME_3, getEmployee3());
        return result;
    }

    public static List<Employee> getDepartment1Employees() {
        return Arrays.asList(getEmployee1(), getEmployee2());
    }

    public static List<Employee> getEmptyListOfEmployees() {
        return List.of();
    }
}
