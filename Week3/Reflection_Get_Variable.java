package Week3;

import java.lang.reflect.*;

class RefField{
    private String empid;
    private String empname;
    private String department;
}

public class Reflection_Get_Variable {
    public static void main(String[] args) {
    //     RefField reffield = new RefField();
    //     Class<?> cls = reffield.getClass();
    Class<RefField> cls = RefField.class;
    Field[] fields = cls.getDeclaredFields();
    for(Field field : fields)
        System.out.println(field.getName());
    }
    
}

// field = variable both are same