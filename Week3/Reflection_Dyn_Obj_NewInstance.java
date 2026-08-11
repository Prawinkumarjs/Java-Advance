package Week3;
import java.lang.reflect.*;

class Employee_DynamicObject{
    public Employee_DynamicObject(){
        System.out.println("Employee Object Created");
    } 
}

public class Reflection_Dyn_Obj_NewInstance {
    public static void main(String[] args) throws Exception {
        Constructor<Employee_DynamicObject> dConstructor = Employee_DynamicObject.class.getDeclaredConstructor();
        Employee_DynamicObject emp = dConstructor.newInstance();
    }
    
}
