package Week3;

import java.io.*;

class EmployeeSerializationOutput implements Serializable{
    private String empid;
    private String empname;
    private String department;
    private double salary;

    EmployeeSerializationOutput(String empid, String empname, String department, double salary){
        this.empid = empid;
        this.empname = empname;
        this.department = department;
        this.salary = salary;
    }
    public void displayEmployee(){
        System.out.println("Employee ID   : " + empid);
        System.out.println("Employee Name : " + empname);
        System.out.println("Department    : " + department);
        System.out.println("Salary        : " + salary);
    }


}

public class SerializationOutputStream {
    public static void main(String[] args) throws Exception {
        EmployeeSerializationOutput employee = new EmployeeSerializationOutput("EMP001","Ram","SAP",50000);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employee.ser"));
        output.writeObject(employee);
        output.close();
        System.out.println("Employee Object Serialized successfully.");
        
    }
    
}
