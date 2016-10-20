package lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "SetCookieServlet", value = "/cookie.set")
public class SetCookieServlet extends HttpServlet
{


protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
{
    Cookie cookie;
    
    (cookie = new Cookie("Cookie-1", "-1")).setMaxAge(-1);
    response.addCookie(cookie);
    (cookie = new Cookie("Cookie-2", "-2")).setMaxAge(-2);
    response.addCookie(cookie);
    (cookie = new Cookie("Cookie-3", "-3")).setMaxAge(-3);
    response.addCookie(cookie);

    (cookie = new Cookie("Cookie+1", "1")).setMaxAge(3600);
    response.addCookie(cookie);
    (cookie = new Cookie("Cookie+2", "2")).setMaxAge(3600);
    response.addCookie(cookie);
    (cookie = new Cookie("Cookie+3", "3")).setMaxAge(3600);
    response.addCookie(cookie);
}
    
    
} //SetCookieServlet

