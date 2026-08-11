package Week3;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeInfo{
    String department();
    String roll();
}
@EmployeeInfo(department = "SAP", roll = "ABAP Developer")

class EmployeeAnnotate{
    String empid = "EMP001";
    String empname = "Ram";
}

public class AnnotationReflection {
    public static void main(String[] args) {
        Class <EmployeeAnnotate> emp = EmployeeAnnotate.class;
        EmployeeInfo info = emp.getAnnotation(EmployeeInfo.class);
        System.out.println("Employee ID     : EMP001");
        System.out.println("Employee Name   : Ram");
        System.out.println("Department      : " + info.department() );
        System.out.println("Roll            : " + info.roll());
    }
}
