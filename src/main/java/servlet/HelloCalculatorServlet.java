package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calculator")
public class HelloCalculatorServlet extends HttpServlet {


    private final String RESULT = "servlet.HelloCalculatorServlet.result";
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
                String previous_results = "RESULT IS " + numberPärameter;
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
                                previousResult = String.valueOf(lastNum2) + " +   " + String.valueOf(lastNum1) + " = " + result + "\n";
                                lstAnswers.add(previousResult);
                                break;
                            case "Subtract":

                                lastNum1 = Integer.parseInt(numberPärameter);
                                lastNum2 = result;
                                result -= Integer.parseInt(numberPärameter);
                                previousResult = String.valueOf(lastNum2) + " - " + String.valueOf(lastNum1) + " = " + result + "\n";
                                lstAnswers.add(previousResult);
                                break;
                            case "Multiply":

                                lastNum1 = Integer.parseInt(numberPärameter);
                                lastNum2 = result;
                                result *= Integer.parseInt(numberPärameter);
                                previousResult = String.valueOf(lastNum2) + " x " + String.valueOf(lastNum1) + " = " + result + "\n";
                                lstAnswers.add(previousResult);
                                break;
                            case "Divide":

                                lastNum1 = Integer.parseInt(numberPärameter);
                                lastNum2 = result;
                                result /= Integer.parseInt(numberPärameter);
                                previousResult = String.valueOf(lastNum2) + " / " + String.valueOf(lastNum1) + " = " + result + "\n";
                                lstAnswers.add(previousResult);
                                break;
                        }


                    } catch (NumberFormatException e) {
                        message = "INVALID NUM";
                    }
                    req.setAttribute("message", message);
                    session.setAttribute(RESULT, result);

                    doGet(req, resp);


                    req.getRequestDispatcher("WEB-INF/pages/calculator.jsp").forward(req, resp);
                }
            }
        }
