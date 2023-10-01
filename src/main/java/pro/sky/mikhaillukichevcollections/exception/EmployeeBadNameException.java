package pro.sky.mikhaillukichevcollections.exception;

import java.sql.SQLOutput;

public class EmployeeBadNameException  extends RuntimeException{
    public EmployeeBadNameException(String message) {
        super(message);
        System.out.println(message);
    }
}
