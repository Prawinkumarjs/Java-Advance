package Week3;
import java.io.*;

class EmployeeSerialDeserial implements Serializable{
    private String empid;
    private String empname;
    private String department;
    private double salary;

    EmployeeSerialDeserial (String empid, String empname, String department , double salary){
        this.empid = empid;
        this.empname = empname;
        this.department = department;
        this.salary = salary;
    }
    public void displayEmployee(){
        System.out.println("Employee ID    : " + empid);
        System.out.println("Employee Name  : " + empname);
        System.out.println("Department     : " + department);
        System.out.println("Salary         : " + salary);
    }
}

public class SerialDeserialwithoutTransist {
    public static void main(String[] args) throws Exception {
        EmployeeSerialDeserial  employee = new EmployeeSerialDeserial("EMP001", "Ram", "SAP", 50000);

        // serialization
        ObjectOutputStream output =  new ObjectOutputStream(new FileOutputStream("Employee.ser"));
        output.writeObject(employee);
        output.close();

        // deserialization
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Employee.ser"));
        EmployeeSerialDeserial savedEmployee = (EmployeeSerialDeserial)input.readObject();
        input.close();

        System.out.println();
        System.out.println("---------------------------------");

        System.out.println("---------------------------------");
        System.out.println("Employee Data Retrieved");
        savedEmployee.displayEmployee();
        System.out.println("---------------------------------");

    }
    
}
