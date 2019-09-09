package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/session")
public class HelloSessionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalTime sessionStartTime = null;
        HttpSession session = req.getSession();
        if(session.getAttribute("sessionStartTime")==null){
            sessionStartTime = LocalTime.now();
            session.setAttribute("sessionStartTime", sessionStartTime);
        }

        else {
            sessionStartTime = (LocalTime) session.getAttribute("sessionStartTime");
        }


       req.getRequestDispatcher("WEB-INF/pages/session.jsp").forward(req,resp);
    }
}
