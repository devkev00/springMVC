package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        //[response-header]
//        response.setHeader("Content-type", "text/plain; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

//        content(response);
//        cookie(response);
//        redirect(response);


        PrintWriter writer = response.getWriter();
        writer.println("ok");

    }

    private void content(HttpServletResponse response) {

        // Content-Length: 2
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }

    private void cookie(HttpServletResponse response) {


        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초 후 쿠키 만료
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.sendRedirect("/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
