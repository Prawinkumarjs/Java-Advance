package Week3;
import java.lang.reflect.*;

class RefMethod{
    public void displayEmployee(){

    }
    public void calculateSalary(){

    }
}


public class Reflection_Get_Method {
    public static void main(String[] args) {
        Class<RefMethod> cls = RefMethod.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
    }
}
