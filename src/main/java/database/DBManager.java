package database;

import constants.Constat;
import entity.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager implements IDBManager {
    @Override
    public ArrayList<Students> getAllStudents() {
        ArrayList<Students> students = new ArrayList<>();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constat.CONNECTIONS_URL_DB, Constat.CONNECTIONS_LOGIN_DB, Constat.CONNECTIONS_PASSWORD_DB);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students where status=1;");
            while (rs.next()) {
                Students student = new Students();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(rs.getByte("status"));
                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Students getModificationStudents(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constat.CONNECTIONS_URL_DB, Constat.CONNECTIONS_LOGIN_DB, Constat.CONNECTIONS_PASSWORD_DB);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students where status = 1 and id = " + id + ";");
            while (rs.next()) {
                Students student = new Students();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("date"));
                student.setStatus(rs.getByte("status"));
                return student;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constat.CONNECTIONS_URL_DB, Constat.CONNECTIONS_LOGIN_DB, Constat.CONNECTIONS_PASSWORD_DB);

            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `students` (`name`, `surname`, `group`, `date`, `status`) " +
                    "VALUES ('" + name + "', '" + surname + "', '" + group + "', '" + date + "', '1');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(String id, String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constat.CONNECTIONS_URL_DB, Constat.CONNECTIONS_LOGIN_DB, Constat.CONNECTIONS_PASSWORD_DB);

            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students` SET `name` = '" + name + "', `surname` = '" + surname + "', `group` = '" + group + "', `date` = '" + date + "' WHERE (`id` = '" + id + "');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudents(String ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Constat.CONNECTIONS_URL_DB, Constat.CONNECTIONS_LOGIN_DB, Constat.CONNECTIONS_PASSWORD_DB);

            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students` SET `status` = '0' WHERE (`id` in (" + ids + "));");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
