package Week3;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeStatusAnnotation{
    String status();
}
@EmployeeStatusAnnotation(status = "Active")
class EmployeeStatusAnnotationDemo{
    String empid = "EMP001";
    String empname = "Ram";
}

public class AnnotationReflection2 {
    public static void main(String[] args) {
        Class <EmployeeStatusAnnotationDemo> employeeClass = EmployeeStatusAnnotationDemo.class;
        EmployeeStatusAnnotation status = employeeClass.getAnnotation(EmployeeStatusAnnotation.class);
        System.out.println("Employee ID      : EMP001");
        System.out.println("Employee Name    : Ram");
        System.out.println("Employee Status  : " + status.status());

    }
    
}
