package Week3;
// import java.lang.reflect.*;

class Employee_Ref{

}

public class Reflection_Get_Class{
    public static void main(String[] args) {
        Employee_Ref employee = new Employee_Ref();
        Class<?> cls = employee.getClass();
        System.out.println("Class Name: " + cls.getName());
        
    }
    
}