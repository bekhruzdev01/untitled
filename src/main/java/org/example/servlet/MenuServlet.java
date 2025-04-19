package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.example.dbService.DbService;
import org.example.model.Book;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/books")
public class MenuServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DbService dbService = new DbService();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Book book : dbService.getBooks()) {
            json.append("{");
            json.append("\"id\":").append(book.getId()).append(",");
            json.append("\"name\":\"").append(book.getName()).append("\",");
            json.append("\"price\":").append(book.getPrice()).append(",");
            json.append("\"writer\":\"").append(book.getWriter()).append("\",");
            json.append("\"year\":").append(book.getYear());
            json.append("},");
        }
        StringBuilder j = new StringBuilder(json.substring(0, json.length() - 1));
        j.append("]");

        writer.write(j.toString());
        writer.flush();
    }
}
