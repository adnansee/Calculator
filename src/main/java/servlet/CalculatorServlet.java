package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class CalculatorServlet extends HttpServlet {
    private final String RESULT = "servlet.CalculatorServlet.result";
    private final String NUMBER = "number";
    private String previousResult = "previous_results";
    private List<String> lstAnswers = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object resultAttribute = session.getAttribute(RESULT);

        int result = 0;

        if (resultAttribute != null) {
            result = (int) resultAttribute;
        }
        String message = "";
        Object messageAttribute = req.getAttribute("message");
        if (resultAttribute != null) {
            message = (String) messageAttribute;
        }
        String previous_results = "";
        Object previousAttributes = req.getAttribute("previous_results");
        if (resultAttribute != null) {
            message = (String) messageAttribute;
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Calculator");
            out.println("</title></head><body>");
            out.println("<form method='POST'>");
            out.println(message + "<br/>");
            out.println("Result: " + result + "<br/>");
            out.println("<input type = 'number' name ='number' />");
            out.println("<input type='submit' name= 'operation' value= 'Add' />");
            out.println("<input type='submit' name= 'operation' value= 'Subtract' />");
            out.println("<input type='submit' name= 'operation' value= 'Multiply' />");
            out.println("<input type='submit' name= 'operation' value= 'Divide' />");
            out.println("<br><p>"+ lstAnswers +"</p>");

            out.println("</form></body></html>");
        }
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        String message = "";
        HttpSession session = req.getSession();
        Object resultAttribute = session.getAttribute(RESULT);
        if (resultAttribute != null) {
            result = (int) resultAttribute;
        }


        String numberPärameter = req.getParameter(NUMBER);
        String previous_results = "RESULT IS "+numberPärameter;
        int lastNum1 = 0;
        int lastNum2 = 0;
        if (numberPärameter != null) {
            try {
                String type = req.getParameter("operation");

                System.out.println(type);

                switch (type) {
                    case "Add":
                         lastNum1 = Integer.parseInt(numberPärameter);
                         lastNum2 = result;
                        result += Integer.parseInt(numberPärameter);
                        previousResult = String.valueOf(lastNum2)+ " +   " +   String.valueOf(lastNum1) + " = " + result + "\n";
                        lstAnswers.add(previousResult);
                        break;
                    case "Subtract":

                       lastNum1 = Integer.parseInt(numberPärameter);
                        lastNum2 = result;
                        result -= Integer.parseInt(numberPärameter);
                        previousResult = String.valueOf(lastNum2) + " - " + String.valueOf(lastNum1) +" = "+ result+"\n";
                        lstAnswers.add(previousResult);
                        break;
                    case "Multiply":

                        lastNum1 = Integer.parseInt(numberPärameter);
                        lastNum2 = result;
                        result *= Integer.parseInt(numberPärameter);
                        previousResult = String.valueOf(lastNum2) + " x " + String.valueOf(lastNum1) +" = "+ result+"\n";
                        lstAnswers.add(previousResult);
                        break;
                    case "Divide":

                        lastNum1 = Integer.parseInt(numberPärameter);
                        lastNum2 = result;
                        result /= Integer.parseInt(numberPärameter);
                        previousResult = String.valueOf(lastNum2) + " / " + String.valueOf(lastNum1) +" = "+ result+"\n";
                        lstAnswers.add(previousResult);
                        break;
                }


            } catch (NumberFormatException e) {
                message = "INVALID NUM";
            }
            req.setAttribute("message", message);
            session.setAttribute(RESULT, result);

            doGet(req, resp);
        }
           }
}

