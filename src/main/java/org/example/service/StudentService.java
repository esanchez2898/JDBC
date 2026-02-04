package org.example.service;

import org.example.dao.StudentDAO;

public class StudentService {

    public static void updateStudent(int id, String name, int age, String career) {
        if (age < 0) {
            System.out.println("edad invalida ");
            return;
        }
        StudentDAO.updateStudent(id, name, age, career);
    }

    public static void deleteStudent(int id) {
        if (id <= 0) {
            System.out.println("id invalido");
            return;
        }
        StudentDAO.deleteStudent(id);
    }

}
