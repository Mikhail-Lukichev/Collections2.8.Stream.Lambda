package pro.sky.mikhaillukichevcollections.exception;

public class EmployeeBadNameException  extends RuntimeException{
    public EmployeeBadNameException(String message) {
        super(message);
        System.out.println(message);
    }
}
