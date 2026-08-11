package Week3;
import java.lang.reflect.*;
class EmployeeAdRefDynamic{
    private String empid = "EMP1";
    private String empname = "Ram";
    private String departments = "SAP";
    private String designation = "Junior Consultant";
    
    public void displayEmployee(){
        System.out.println("Employee Details");
        System.out.println("Employee ID   : " + empid);
        System.out.println("Employee Name : " + empname);
        System.out.println("Department    : " + departments);
        System.out.println("Designation   : " + designation);
    }

    public void updateDepartments(String departments){
        this.departments = departments;
    }

    public void updateDesignation(String designation){
        this.designation = designation;
    }

}


public class Assignment3 {
    public static void main(String[] args) throws Exception {
        EmployeeAdRefDynamic emp = new EmployeeAdRefDynamic();
        System.out.println("----------------------------------");
        System.out.println("HRMS Employee Processing");
        System.out.println("----------------------------------");

        Field field1 = EmployeeAdRefDynamic.class.getDeclaredField("departments");
        Field field2 = EmployeeAdRefDynamic.class.getDeclaredField("designation");
        
        field1.setAccessible(true);
        System.out.println("Original Department : " + field1.get(emp));
        field1.set(emp, "Java");
        System.out.println("Updated Department  : " + field1.get(emp));
        System.out.println("------------------------------------");

        field2.setAccessible(true);
        System.out.println("Original Designation : " + field2.get(emp));
        field2.set(emp, "Senior Consultant");
        System.out.println("Updated Designation  : " + field2.get(emp));
        System.out.println("------------------------------------");

        Method method = EmployeeAdRefDynamic.class.getDeclaredMethod("displayEmployee");
        method.invoke(emp);
        System.out.println("------------------------------------");
    }
    
}
