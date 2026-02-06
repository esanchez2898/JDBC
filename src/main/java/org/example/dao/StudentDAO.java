package org.example.dao;

import org.example.db.DatabaseConnection;
import org.example.module.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    public static void insertStudent(String name, int age, String career) {

        String sql = "INSERT INTO student (name, age, career) VALUES (?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, career);

            pstmt.executeUpdate();
            System.out.println("student added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(int id, String name, int age, String career) {
        String sql = "UPDATE student SET name = ?, age = ?, career = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, career);
            pstmt.setInt(4, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("student updated");
            } else {
                System.out.println("there is not student with id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("student deleted");
            } else {
                System.out.println("there is not student with id " + id);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        ArrayList<Student> students = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                Student s1 = new Student(rs.getInt("id"), rs.getString("name"),
                                         rs.getInt("age"), rs.getString("career"));
                students.add(s1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static Student getStudentById(int id) {
        Student s1 = null;
        String sql = "SELECT * FROM student WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();


            if (rs.next()) {
                System.out.println("user found :)");
                s1 = new Student(rs.getInt("id"),rs.getString("name"),
                        rs.getInt("age"),rs.getString("career"));

            } else {
                System.out.println("there is not a user with id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s1;
    }

    // get with id
//    public static Student getStudent() {
//        return "test";
//    }


}
