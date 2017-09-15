package servlet;

import dao.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListAllStudentServlet",urlPatterns = "/listAllStudent")
public class ListAllStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = StudentDao.getAllStudents();
        req.setAttribute("students",studentList);
        req.getRequestDispatcher("/student.jsp").forward(req,resp);
    }
}
