package webroot;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println("<html><body>Hello. Roses are red.");
        out.print("Violets are blue.");
        out.println("<br><pre> --- from thread " + Thread.currentThread().getName() + "</pre></body></html>");
    }

    public void destroy() {
        System.out.println("destroy");
    }

    public String getServletInfo() {
        return null;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

}
