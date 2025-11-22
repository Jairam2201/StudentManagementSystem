package StudentManagementSystem.src.studentapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student s) {
        String query = "INSERT INTO students(firstname, lastname, dateofbirth, place, age, course, branch) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.getFirstname());
            ps.setString(2, s.getLastname());
            ps.setString(3, s.getDateOfBirth());
            ps.setString(4, s.getPlace());
            ps.setInt(5, s.getAge());
            ps.setString(6, s.getCourse());
            ps.setString(7, s.getBranch());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!✅");
            } else {
                System.out.println("Failed to add student.❌");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("dateofbirth"),
                        rs.getString("place"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("branch")
                ));
            }

            if (list.isEmpty()) {
                System.out.println("No students found in the database.❌");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public void updateStudent(Student s) {
        String query = "UPDATE students SET firstname=?, lastname=?, dateofbirth=?, place=?, age=?, course=?, branch=? WHERE id=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.getFirstname());
            ps.setString(2, s.getLastname());
            ps.setString(3, s.getDateOfBirth());
            ps.setString(4, s.getPlace());
            ps.setInt(5, s.getAge());
            ps.setString(6, s.getCourse());
            ps.setString(7, s.getBranch());
            ps.setInt(8, s.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully!✅");
            } else {
                System.out.println("No student found with ID " + s.getId() + ". Update failed.❌");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!✅");
            } else {
                System.out.println("No student found with ID " + id + ". Delete failed.❌");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
