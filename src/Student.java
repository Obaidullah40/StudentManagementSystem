public class Student {
    private int studentId;
    private String name;
    private String password;
    private String program;
    private int batch;
    private double cgpa;

    public Student(int studentId, String name, String password,
                   String program, int batch, double cgpa) {

        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.program = program;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
