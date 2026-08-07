package Week3;
import java.lang.reflect.*;

class Employee_Method_Invoke {
    public void displayEmployee(){
        System.out.println("Employee ID   : EMP100");
        System.out.println("Employee Name : Rocky");
        System.out.println("Department    : SAP");
    }
}

public class Reflection_Dyn_Mtd_Invoke {
    public static void main(String[] args)  throws Exception{
        Employee_Method_Invoke employee = new Employee_Method_Invoke();
        Method method = Employee_Method_Invoke.class.getDeclaredMethod("displayEmployee");
        method.invoke(employee);
        
    }
    
}
