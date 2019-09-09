package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/random")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Random r = new Random();
        int choose = r.nextInt((3 - 0) + 1);

        if(choose==0){req.getRequestDispatcher("/WEB-INF/pages/helloWorld.jsp").forward(req, resp);}
        else if (choose==1){req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);}
        else if (choose==2){req.getRequestDispatcher("/WEB-INF/pages/calculator.jsp").forward(req, resp);}
        else if (choose==3){req.getRequestDispatcher("/WEB-INF/pages/session.jsp").forward(req, resp);}



    }
}
