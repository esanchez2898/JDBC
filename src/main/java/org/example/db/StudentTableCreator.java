package org.example.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTableCreator {

    public static void createStudentTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS student (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    age INT NOT NULL UNIQUE,
                    career VARCHAR(100) NOT NULL
                );
                """;

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla student creada exitosamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
