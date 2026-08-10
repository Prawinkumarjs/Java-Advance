package Week3;
import java.lang.reflect.*;

class EmployeeStatus{
    public String getEmployeeStatus(){
        return "Active";
    }
}

public class Reflection_Method_Return_value {
    public static void main(String[] args) throws Exception {
        EmployeeStatus empstatus = new EmployeeStatus();
        Method method = EmployeeStatus.class.getDeclaredMethod("getEmployeeStatus" );
        String status = (String) method.invoke(empstatus);
        System.out.println("Employee Status: " + status);
    }
    
}
