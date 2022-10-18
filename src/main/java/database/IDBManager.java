package database;

import entity.Students;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList<Students> getAllStudents();

    Students getModificationStudents(int id);

    void createStudent(String surname, String name, String group, String date);

    void updateStudent(String id,String surname, String name, String group, String date);

    void deleteStudents(String ids);
}

