package Week3;

import java.lang.reflect.*;;

class Employee_Adv_Pvt_Var_Set {
    private String empid = "EMP100";
    private String empname = "Rocky";
    private String department = "SAP";
}

public class Adv_Reflection_Set_Values_Variable_Pvt {
    public static void main(String[] args) throws Exception {
        Employee_Adv_Pvt_Var_Set employee = new Employee_Adv_Pvt_Var_Set();
        Field field = Employee_Adv_Pvt_Var_Set.class.getDeclaredField("department");
        field.setAccessible(true);
        System.out.println("Before Update: " + field.get(employee));
        field.set(employee, "Finance");
        System.out.println("After Update: " + field.get(employee));
    }
}
