package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder lines =new StringBuilder();

        PrintWriter writer = resp.getWriter();
        writer.write("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Book</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <h1 class=\"text-center text-success\">Kitoblar sahifasi</h1>\n" +
                "    <button class=\"btn btn-success\">Saqlash</button>\n" +
                "    <table class=\"table\">\n" +
                "        <thead>\n" +
                "        <tr>\n" +
                "            <td>T/r</td>\n" +
                "            <td>Nomi</td>\n" +
                "            <td>Narxi</td>\n" +
                "            <td>Yozuvchisi</td>\n" +
                "            <td>Yili</td>\n" +
                "            <td colspan=\"2\">Sozlamalar</td>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n" +
                line +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "</body>\n" +
                "</html>");

    }
}
