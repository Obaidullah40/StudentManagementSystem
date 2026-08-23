public class Course {
    private int studentId;
    private String courseCode;
    private String courseName;

    public Course(int studentId, String courseCode, String courseName) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    public int getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
}
