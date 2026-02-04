package org.example.dao;

import org.example.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public static void insertStudent(String name, int age, String career) {

        String sql = "INSERT INTO student (name, age, career) VALUES (?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, career);

            pstmt.executeUpdate();
            System.out.println("Usuario insertado correctamente");

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
                System.out.println("usuario actualizado correctamente");
            } else {
                System.out.println("no se encontró usuario con id " + id);
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
                System.out.println("usuario eliminado correctamente");
            } else {
                System.out.println("no existe usuario con id " + id);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

}
