class StudentBuilder
{
    private String studentId;
    private String name;
    private String course;
    private String year;
    private double fees;

    private StudentBuilder(SBuilder builder)
    {
        studentId = builder.studentId;
        name = builder.name;
        course = builder.course;
        year = builder.year;
        fees = builder.fees;
    }

    public void display()
    {
        System.out.println(studentId + " - " + name + " - " + course + " - " + year + " - " + fees);
    }

    static class SBuilder
    {
        private String studentId;
        private String name;
        private String course;
        private String year;
        private double fees;

        public SBuilder setStudentId(String studentId)
        {
            this.studentId = studentId;
            return this;
        }

        public SBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        public SBuilder setCourse(String course)
        {
            this.course = course;
            return this;
        }

        public SBuilder setYear(String year)
        {
            this.year = year;
            return this;
        }

        public SBuilder setFees(double fees)
        {
            this.fees = fees;
            return this;
        }

        public StudentBuilder build()
        {
            return new StudentBuilder(this);
        }
    }
}

public class StudentRegSysBuilder
{
    public static void main(String[] args)
    {
        StudentBuilder student = new StudentBuilder.SBuilder()
                .setStudentId("ECE064")
                .setName("Prawin")
                .setCourse("java")
                .setYear("2026")
                .setFees(20000)
                .build();

        student.display();
    }
}