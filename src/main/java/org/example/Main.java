package org.example;

import org.example.dao.StudentDAO;
import org.example.db.DatabaseConnection;
import org.example.db.StudentTableCreator;
import org.example.service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static void main() {

        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Conectado");

            // StudentTableCreator.createStudentTable();

            //StudentDAO.insertStudent("erick", 27, "java");
            //StudentDAO.insertStudent("muhammad", 29, "java");
            //StudentDAO.updateStudent(11, "armando", 27, "java");
            //StudentService.updateStudent(1, "armando", -5, "java");
            //StudentDAO.deleteStudent(3);
            StudentService.deleteStudent(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
