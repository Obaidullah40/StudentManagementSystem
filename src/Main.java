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

                                                        String name = IO.readln("Name: ");
                                                        String studentPassword  = IO.readln("Password: ");
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
                                                                RandomAccessFile studentFile  =
                                                                        new RandomAccessFile("students.txt", "rw");

                                                                studentFile.seek(studentFile.length());

                                                                String studentLine  = student.getStudentId() + ","
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
                                                        break;

                                                case 4:
                                                        IO.println("View Advised Courses selected.");
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
