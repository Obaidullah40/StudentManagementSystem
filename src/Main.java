void main() {


        IO.println("===== Admission Officer Login =====");

        boolean loginSuccessful = false;

        while (!loginSuccessful) {

                String username = IO.readln("Username: ");
                String password = IO.readln("Password: ");

                try {
                        RandomAccessFile file =
                                new RandomAccessFile("officers.txt", "r");

                        String line = file.readLine();

                        String[] data = line.split(",");

                        String fileUsername = data[0];
                        String filePassword = data[1];

                        if (username.equals(fileUsername) &&
                                password.equals(filePassword)) {

                                IO.println("Login successful!");
                                IO.println("Welcome, Admission Officer.");

                                boolean running = true;

                                while (running) {

                                        IO.println("\n===== Student Management System =====");
                                        IO.println("1. Add Student");
                                        IO.println("2. Search Student");
                                        IO.println("3. Assign Course");
                                        IO.println("4. View Advised Courses");
                                        IO.println("5. Exit");

                                        int choice = Integer.parseInt(
                                                IO.readln("Enter your choice: ")
                                        );

                                        switch (choice) {

                                                case 1:
                                                        IO.println("Add Student selected.");
                                                        int studentId = Integer.parseInt(
                                                                IO.readln("Student ID: ")
                                                        );

                                                        boolean studentExists = false;

                                                        try {
                                                                RandomAccessFile checkFile =
                                                                        new RandomAccessFile("students.txt", "r");

                                                                String checkLine;

                                                                while ((checkLine = checkFile.readLine()) != null) {

                                                                        String[] checkData = checkLine.split(",");

                                                                        int existingId =
                                                                                Integer.parseInt(checkData[0]);

                                                                        if (existingId == studentId) {
                                                                                studentExists = true;
                                                                                break;
                                                                        }
                                                                }

                                                                checkFile.close();

                                                        } catch (Exception e) {
                                                                IO.println("Error checking student ID.");
                                                        }
                                                        if (studentExists) {

                                                                IO.println("Student ID already exists.");

                                                        } else {

                                                                String name = IO.readln("Name: ");
                                                                String studentPassword = IO.readln("Password: ");
                                                                String program = IO.readln("Program: ");

                                                                int batch = Integer.parseInt(
                                                                        IO.readln("Batch: ")
                                                                );

                                                                double cgpa = Double.parseDouble(
                                                                        IO.readln("CGPA: ")
                                                                );

                                                                Student student = new Student(
                                                                        studentId,
                                                                        name,
                                                                        studentPassword,
                                                                        program,
                                                                        batch,
                                                                        cgpa
                                                                );

                                                                IO.println("Student added successfully.");

                                                                try {
                                                                        RandomAccessFile studentFile =
                                                                                new RandomAccessFile("students.txt", "rw");

                                                                        studentFile.seek(studentFile.length());

                                                                        String studentLine = student.getStudentId() + ","
                                                                                + student.getName() + ","
                                                                                + student.getPassword() + ","
                                                                                + student.getProgram() + ","
                                                                                + student.getBatch() + ","
                                                                                + student.getCgpa() + "\n";

                                                                        studentFile.writeBytes(studentLine);

                                                                        studentFile.close();

                                                                        IO.println("Student added successfully.");

                                                                } catch (Exception e) {
                                                                        IO.println("Error saving student information.");
                                                                }
                                                        }

                                                        break;

                                                case 2:

                                                        int searchId = Integer.parseInt(
                                                                IO.readln("Enter Student ID: ")
                                                        );

                                                        boolean studentFound = false;

                                                        try {
                                                                RandomAccessFile studentFile =
                                                                        new RandomAccessFile("students.txt", "r");

                                                                String studentLine;

                                                                while ((studentLine = studentFile.readLine()) != null) {

                                                                        String[] studentData = studentLine.split(",");

                                                                        int fileStudentId =
                                                                                Integer.parseInt(studentData[0]);

                                                                        if (fileStudentId == searchId) {

                                                                                IO.println("\n===== Student Information =====");
                                                                                IO.println("Student ID: " + studentData[0]);
                                                                                IO.println("Name: " + studentData[1]);
                                                                                IO.println("Program: " + studentData[3]);
                                                                                IO.println("Batch: " + studentData[4]);
                                                                                IO.println("CGPA: " + studentData[5]);

                                                                                studentFound = true;

                                                                                break;
                                                                        }
                                                                }

                                                                studentFile.close();

                                                                if (!studentFound) {
                                                                        IO.println("Student not found.");
                                                                }

                                                        } catch (Exception e) {
                                                                IO.println("Error reading student information.");
                                                        }

                                                        break;


                                                case 3:
                                                        IO.println("Assign Course selected.");
                                                        int courseStudentId = Integer.parseInt(
                                                                IO.readln("Student ID: ")
                                                        );

                                                        String courseCode = IO.readln("Course Code: ");
                                                        String courseName = IO.readln("Course Name: ");

                                                        Course course = new Course(
                                                                courseStudentId,
                                                                courseCode,
                                                                courseName
                                                        );

                                                        try {
                                                                RandomAccessFile courseFile =
                                                                        new RandomAccessFile("courses.txt", "rw");

                                                                courseFile.seek(courseFile.length());

                                                                String courseLine = course.getStudentId() + ","
                                                                        + course.getCourseCode() + ","
                                                                        + course.getCourseName() + "\n";

                                                                courseFile.writeBytes(courseLine);

                                                                courseFile.close();

                                                                IO.println("Course assigned successfully.");

                                                        } catch (Exception e) {
                                                                IO.println("Error saving course information.");
                                                        }
                                                        break;

                                                case 4:
                                                        IO.println("View Advised Courses selected.");
                                                        int courseSearchId = Integer.parseInt(
                                                                IO.readln("Enter Student ID: ")
                                                        );

                                                        boolean courseFound = false;

                                                        try {
                                                                RandomAccessFile courseFile =
                                                                        new RandomAccessFile("courses.txt", "r");

                                                                String courseLine;

                                                                IO.println("\n===== Advised Courses =====");

                                                                while ((courseLine = courseFile.readLine()) != null) {

                                                                        String[] courseData = courseLine.split(",");

                                                                        int fileCourseStudentId =
                                                                                Integer.parseInt(courseData[0]);

                                                                        if (fileCourseStudentId == courseSearchId) {

                                                                                IO.println("Course Code: " + courseData[1]);
                                                                                IO.println("Course Name: " + courseData[2]);
                                                                                IO.println();

                                                                                courseFound = true;
                                                                        }
                                                                }

                                                                courseFile.close();

                                                                if (!courseFound) {
                                                                        IO.println("No advised courses found.");
                                                                }

                                                        } catch (Exception e) {
                                                                IO.println("Error reading course information.");
                                                        }
                                                        break;

                                                case 5:
                                                        IO.println("Goodbye!");
                                                        running = false;
                                                        break;

                                                default:
                                                        IO.println("Invalid choice. Please try again.");
                                        }
                                }

                        } else {

                                IO.println("Incorrect username or password.");
                                IO.println("Please try again.");
                        }

                        file.close();

                } catch (Exception e) {
                        IO.println("Error reading file.");
                        break;
                }
        }
}
