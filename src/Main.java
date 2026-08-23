//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

        Student student = new Student(
                101,
                "Muhammad",
                "abc123",
                "CSE",
                50,
                3.75
        );

        IO.println("Student ID: " + student.getStudentId());
        IO.println("Name: " + student.getName());
        IO.println("Program: " + student.getProgram());
        IO.println("Batch: " + student.getBatch());
        IO.println("CGPA: " + student.getCgpa());

}
