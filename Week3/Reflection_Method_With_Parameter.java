package Week3;
import java.lang.reflect.*;

class Employee_Method_With_Parameter{
    private String department = "SAP";

    public void  updateDepartment(String department){
        this.department = department;
        System.out.println("Department Updated: " + this.department);
    }
}

public class Reflection_Method_With_Parameter {
    public static void main(String[] args) throws Exception {
        Employee_Method_With_Parameter employee = new Employee_Method_With_Parameter();
        Method method = Employee_Method_With_Parameter.class.getDeclaredMethod("updateDepartment",String.class);
        method.invoke(employee, "Finance");
    }
    
}
