package org.example;

import org.example.dao.StudentDAO;
import org.example.db.DatabaseConnection;
import org.example.db.StudentTableCreator;
import org.example.module.Student;
import org.example.service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menu;

        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("DB Connected :)");

            do {
                System.out.println("\n\n");
                System.out.println("Please choose from the following options:");
                System.out.println("(1)Add   (2)Update   (3)Delete by ID   (4)Get All   (5)Get by ID   (6)Exit");
                menu = sc.nextInt();
                int id;
                String name;
                int age;
                String career;

                switch (menu) {
                    case 1:
                        System.out.println("Add student:");

                        System.out.print("\nPlease enter student name: ");
                        name =  sc.next();
                        System.out.print("\nPlease enter student age: ");
                        age = sc.nextInt();
                        System.out.print("\nPlease enter student career: ");
                        career = sc.next();

                        StudentDAO.insertStudent(name, age, career);
                        break;

                    case 2:
                        System.out.println("2: Update Student");

                        System.out.print("\nPlease enter student ID: ");
                        id =  sc.nextInt();
                        System.out.print("\nPlease enter student name: ");
                        name =  sc.next();
                        System.out.print("\nPlease enter student age: ");
                        age = sc.nextInt();
                        System.out.print("\nPlease enter student career: ");
                        career = sc.next();

                        StudentService.updateStudent(id, name, age, career);
                        break;

                    case 3:
                        System.out.println("3: Delete Student By id");

                        System.out.print("\nPlease enter student ID: ");
                        id =  sc.nextInt();

                        StudentService.deleteStudent(id);
                        break;

                    case 4:
                        System.out.println("4: Get All Students\n");

                        for (Student student : StudentDAO.getAllStudents()) {
                            System.out.println(student.getId() + " " + student.getName() + " " + student.getAge() + " " + student.getCareer());
                        }
                        break;

                    case 5:
                        System.out.println("5: Get Student By id");
                        System.out.print("\nPlease enter student ID: ");
                        id =  sc.nextInt();

                        System.out.println(StudentDAO.getStudentById(id).getName());
                        break;

                    case 6:
                        System.out.println("6: Exit");
                        break;
                    default:
                        System.out.println("invalid input");
                }

            } while (menu != 6);


//            StudentTableCreator.createStudentTable();


//            StudentDAO.updateStudent(11, "armando", 27, "java");
//            StudentService.updateStudent(1, "armando", -5, "java");
//            StudentService.updateStudent(3, "armando", 27, "java");


//            StudentDAO.deleteStudent(3);
//            StudentService.deleteStudent(2);

//            for (Student student : StudentDAO.getAllStudents()) {
//                System.out.println(student.getName());
//            }

// HW: create a menu


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
