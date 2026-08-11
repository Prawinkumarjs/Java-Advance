package Week3;
import java.lang.reflect.*;

class Employee_Constructor{
    public Employee_Constructor(){

    }
    public Employee_Constructor(String name){

    }
}

public class Reflection_Method_Constructor_Inspection {
    public static void main(String[] args) {
        Constructor<?>[] constructors = Employee_Constructor.class.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors ){
            System.out.println(constructor);
        }
    }
    
}
