package lesson3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name = "QuadraticEquationSolveServlet", value = "/QuadraticEquation.solve")
public class QuadraticEquationSolveServlet extends HttpServlet
{


protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
{
    double a = Double.valueOf(request.getParameter("coeff_a"));
    if (a == 0) throw new ServletException("Quadratic coefficient cannot be zero.");
    double b = Double.valueOf(request.getParameter("coeff_b"));
    double c = Double.valueOf(request.getParameter("coeff_c"));
    Double discriminant = b * b - 4 * a * c;
    Double root1 = (-b - Math.sqrt(discriminant)) / (2*a);
    Double root2 = (-b + Math.sqrt(discriminant)) / (2*a);
    
    ServletContext sc = getServletContext();
    sc.setAttribute("discriminant", discriminant);
    sc.setAttribute("root1", root1);
    sc.setAttribute("root2", root2);
    
    sc.getRequestDispatcher("/lesson3_QE.jsp").forward(request, response);
}


} //QuadraticEquationSolveServlet
