package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private static Connection connection;

    public static List<Student> getAllStudents(){
        List<Student> allStudents = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=utf8", "root", "123456");
//            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
//            ResultSet resultSet = statement.executeQuery("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("resultset:  "+resultSet.getMetaData().getColumnCount());
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                System.out.println("id:"+id+"name:"+name+"age:"+age);
                Student student = new Student(id,age,name);
                allStudents.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    public static boolean deleteStudent(String id){
        int count= 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
            preparedStatement.setString(1,id);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }
}
