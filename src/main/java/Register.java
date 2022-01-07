

import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet(urlPatterns = "/Register")
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username=request.getParameter("ufname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/agreeya","root","12345678");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into registeration (name,password,email)  values(?,?,?)");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            int output=preparedStatement.executeUpdate();
            if(output>0)
            {
                out.println("Inserted Successfully");
            }
            else
            {
                out.println("Error In Insertion");
            }
        }

        catch(Exception IOE)
        {
            System.out.println("Error in Ioexception");
        }


        out.close();
    }

}