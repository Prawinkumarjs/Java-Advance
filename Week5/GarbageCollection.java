class EmployeeHRMSJVM{
    private String empid;
    private String empname;
    EmployeeHRMSJVM(String empid, String empname){
        this.empid = empid;
        this.empname = empname;
    }
    void display(){
        System.out.println(empid +" : " + empname );
    }
}


public class GarbageCollection {
    public static void main(String[] args) {
        
        EmployeeHRMSJVM emp1 = new EmployeeHRMSJVM("EMP001", "Sethu");
        EmployeeHRMSJVM emp2 = new EmployeeHRMSJVM("EMP002", "Guna");

        emp1.display();
        emp2.display();
        emp1 = null;
        System.out.println("After emp1 nullifying");
        System.gc();
        // emp1.display(); // here is not visible because emp1 is already null
        System.out.println("HRMS Application Completed");


    }
    
}
