package Week3;
import java.lang.reflect.*;

class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private double salary;

    public Employee() {}

    public void displayDetails() {}

    public void calculateSalary() {}

    public void updateDepartment() {}
}

public class Assignment1 {
    public static void main(String[] args) {
        Class<Employee> emp = Employee.class;
        System.out.println("---------------------");
        System.out.println("Class Name: " + emp.getName());
        System.out.println();
        System.out.println("Fields");
        Field[] empfields = emp.getDeclaredFields();
        for(Field empfield : empfields){
            System.out.println(empfield.getName());
        }
        System.out.println();
        System.out.println("Methods Names: ");
        System.out.println();
        Method[] empmethods = emp.getDeclaredMethods();
        for (Method empmethod : empmethods){
            System.out.println(empmethod.getName());
        }
        System.out.println("-----------------------------");
    }
    
}
