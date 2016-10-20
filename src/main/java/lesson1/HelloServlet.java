package lesson1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet (name = "HelloServlet", value = "/hello.do", initParams = {
  @WebInitParam (name = "Annotation Init Parameter1", value = "Annotation Init Parameter1 Value"),
  @WebInitParam (name = "Annotation Init Parameter2", value = "Annotation Init Parameter2 Value")
})
public class HelloServlet extends HttpServlet
{

private static final String FIRST_NAME_PARAM = "txt_first_name";
private static final String LAST_NAME_PARAM = "txt_last_name";
private static final String FIRST_NAME_DEFAULT = "NoName";
private static final String LAST_NAME_DEFAULT = "NoName";

private String initParamsTable;


protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
{
    request.setCharacterEncoding("UTF-8");
      
    String firstName = request.getParameter(FIRST_NAME_PARAM);
    if (StringUtils.isBlank(firstName))
    {
        firstName = FIRST_NAME_DEFAULT;
    }
    firstName = StringUtils.capitalizeFirstLetter(firstName);
    
    String lastName = request.getParameter(LAST_NAME_PARAM);
    if (StringUtils.isBlank(lastName))
    {
        lastName = LAST_NAME_DEFAULT;
    }
    lastName = StringUtils.capitalizeFirstLetter(lastName);
    
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
    out.println("<html>");

    out.println("<head>");
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    out.println("<title>Hello Page</title>");
    out.println("</head>");

    out.println("<body>");
    out.println("<center>");
    out.println("<h1>Hello, " + firstName + ' ' + lastName +"!</h1>");

    out.println("<table border='1'>");
    out.println("<tr><th>Name</th><th>Value</th></tr>");
    Enumeration<String> params = request.getParameterNames();
    while (params.hasMoreElements())
    {
        String name = params.nextElement();
        String[] value = request.getParameterValues(name);
        out.println("<tr><td>" + name + "</td><td>");
        if (value != null)
            for (int i = 0; i < value.length; i++) out.println(value[i] + "<br>");
        out.println("</td></tr>");
    }
    out.println("</table>");

    out.println("</center>");
    out.println("<a href=\"" + request.getServletContext().getContextPath() + "/lesson1_Hello.html\">Back To Register Page</a>");
    
    out.println("<h1>Init Parameters</h1>");
    out.println(initParamsTable);
    out.println("<h1>Servlet Context</h1>");
    out.println(getContextTable());
    out.println("</body>");

    out.println("</html>");
    out.close();
}


public void init()
  throws ServletException
{
    initParamsTable = "<p><table border='1'>";
    initParamsTable += "<tr><th>№</th><th>Name</th><th>Value</th></tr>";
    int recNo = 1;
    Enumeration<String> initParams = getServletConfig().getInitParameterNames();
    while (initParams.hasMoreElements())
    {
        String name = initParams.nextElement();
        String value = getInitParameter(name);
        initParamsTable += "<tr><td>" + recNo++ + "</td><td>" + name + "</td><td>" + value + "</td></tr>";
    }
    initParamsTable += "</table></p>";
}


private String getContextTable()
  throws ServletException
{
    String contextTable = "<p><table border='1'>";
    contextTable += "<tr><th>№</th><th>Name</th><th>Value</th></tr>";
    int recNo = 1;
    
    ServletContext sc = getServletContext();
    
    contextTable += "<tr><td>" + recNo++ + "</td><td>Server name</td><td>"
      + sc.getServerInfo() + "</td></tr>";
    contextTable += "<tr><td>" + recNo++ + "</td><td>Servlet name</td><td>"
      + sc.getServletContextName() + "</td></tr>";
    contextTable += "<tr><td>" + recNo++ + "</td><td>Servlet API minor version</td><td>"
      + sc.getMinorVersion() + "</td></tr>";
    contextTable += "<tr><td>" + recNo++ + "</td><td>Servlet API major version</td><td>"
      + sc.getMajorVersion() + "</td></tr>";
    contextTable += "<tr><td>" + recNo++ + "</td><td>Context path</td><td>"
      + sc.getContextPath() + "</td></tr>";
    
    Enumeration<String> en = sc.getAttributeNames();
    while (en.hasMoreElements())
    {
        String name = en.nextElement();
        Object value = sc.getAttribute(name);
        contextTable += "<tr><td>" + recNo++ + "</td><td>" + name + "</td><td>" + value + "</td></tr>";
    }
    
    contextTable += "</table></p>";
    return contextTable;
}


} //HelloServlet
