package StudentManagementSystem.src.studentapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("First Name: ");
                    String fname = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lname = sc.nextLine();

                    System.out.print("Date of Birth (YYYY-MM-DD): ");
                    String dob = sc.nextLine();

                    System.out.print("Place: ");
                    String place = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Branch: ");
                    String branch = sc.nextLine();

                    dao.addStudent(new Student(fname, lname, dob, place, age, course, branch));
                    break;

                case 2:
                    dao.getAllStudents().forEach(s ->
                        System.out.println(
                                "StudentId: "+ s.getId() + " | " + s.getFirstname() + " " + s.getLastname() +
                                " | DOB: " + s.getDateOfBirth() +
                                " | Place: " + s.getPlace() +
                                " | Age: " + s.getAge() +
                                " | Course: " + s.getCourse() +
                                " | Branch: " + s.getBranch()
                        )
                    );
                    break;

                case 3:
                    System.out.print("Student ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    Student existingStudent = dao.getAllStudents()
                                                 .stream()
                                                 .filter(s -> s.getId() == uid)
                                                 .findFirst()
                                                 .orElse(null);

                    if (existingStudent == null) {
                        System.out.println("No student found with ID " + uid + "❌");
                        break;
                    }
                    System.out.println("Select field to update:");
                    System.out.println("1. First Name");
                    System.out.println("2. Last Name");
                    System.out.println("3. Date of Birth");
                    System.out.println("4. Place");
                    System.out.println("5. Age");
                    System.out.println("6. Course");
                    System.out.println("7. Branch");
                    System.out.print("Choice: ");
                    int fieldChoice = sc.nextInt();
                    sc.nextLine();

                    

                    switch (fieldChoice) {
                        case 1 -> {
                            System.out.print("Enter new First Name: ");
                            existingStudent.setFirstname(sc.nextLine());
                        }
                        case 2 -> {
                            System.out.print("Enter new Last Name: ");
                            existingStudent.setLastname(sc.nextLine());
                        }
                        case 3 -> {
                            System.out.print("Enter new Date of Birth (YYYY-MM-DD): ");
                            existingStudent.setDateOfBirth(sc.nextLine());
                        }
                        case 4 -> {
                            System.out.print("Enter new Place: ");
                            existingStudent.setPlace(sc.nextLine());
                        }
                        case 5 -> {
                            System.out.print("Enter new Age: ");
                            existingStudent.setAge(sc.nextInt());
                            sc.nextLine();
                        }
                        case 6 -> {
                            System.out.print("Enter new Course: ");
                            existingStudent.setCourse(sc.nextLine());
                        }
                        case 7 -> {
                            System.out.print("Enter new Branch: ");
                            existingStudent.setBranch(sc.nextLine());
                        }
                        default -> {
                            System.out.println("Invalid choice!❌");
                            break;
                        }
                    }

                    dao.updateStudent(existingStudent);
                    break;

                case 4:
                    System.out.print("Student ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!❌");
            }
        }
    }
}
