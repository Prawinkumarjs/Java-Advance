package Week3;
import java.lang.reflect.*;
class EmployeeAdReflect{
    private String empid = "EMP001";
    private String empname = "Ram";
    private String department = "SAP";
    public void displayEmployee(){
        System.out.println("Employee Details");
        System.out.println("Employee ID   : " + empid);
        System.out.println("Employee Name : " + empname);
        System.out.println("Department    : "+ department);
    }
    public void updateDepartment(String department){
        this.department = department;
    }

}

public class HRMSDynamic {
    public static void main(String[] args) throws Exception {
        EmployeeAdReflect emp = new EmployeeAdReflect();
        System.out.println("-----------------------------------");
        System.out.println("HRMS Employee Processing");
        System.out.println("-----------------------------------");
        // access private department fields
        Field field = EmployeeAdReflect.class.getDeclaredField("department");
        field.setAccessible(true);
        System.out.println("Original Department: " + field.get(emp));
        field.set(emp, "Finance");
        System.out.println("Updated Department: " + field.get(emp));
        System.out.println("------------------------------------");
        // invoke methods dynamically
        Method method = EmployeeAdReflect.class.getDeclaredMethod("displayEmployee");
        method.invoke(emp);
        System.out.println("------------------------------------");
        
    }
    
}
