package lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet (name = "ShowCookieServlet", value = "/cookie.show")
public class ShowCookieServlet extends HttpServlet
{


protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
{
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
    out.println("<html>");
    
    out.println("<head>");
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    out.println("<title>Show Cookies</title>");
    out.println("</head>");
    
    out.println("<body>");
    out.println("<h1>Cookies</h1>");
    out.println("<p><table border='1' width='100%'>");
    out.println("<tr><th>Name</th><th>Value</th><th>Expire</th></tr>");
    for (Cookie cookie: request.getCookies())
    {
        out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td><td>" + cookie.getMaxAge() + "</td></tr>");
    }
    out.println("</table></p>");
    out.println("</body>");
    
    out.println("</html>");
    out.close();
}


} //ShowCookieServlet
