package Week3;
import java.lang.reflect.*;

class Employee_Adv_Pvt_Var_Get {
    private String empid = "EMP100";
    private String empname = "Rocky";
    private String department = "SAP";
}

public class Adv_Reflection_Get_Values_Variable_Pvt {
    public static void main(String[] args) throws Exception{
        Employee_Adv_Pvt_Var_Get employee =  new Employee_Adv_Pvt_Var_Get();
        Field field = Employee_Adv_Pvt_Var_Get.class.getDeclaredField("empname");
        field.setAccessible(true);
        String name = (String) field.get(employee);
        System.out.println("Employee Name: " + name);
    }
    
}
