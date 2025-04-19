package org.example.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
import java.util.List;

@WebServlet("/books")
public class MenuServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DbService dbService = new DbService();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        StringBuilder json = new StringBuilder();
        for (Book book : dbService.getBooks()) {
            json.append("{");
            json.append("\"id\":").append(book.getId()).append(",");
            json.append("\"name\":\"").append(book.getName()).append("\",");
            json.append("\"price\":").append(book.getPrice()).append(",");
            json.append("\"writer\":\"").append(book.getWriter()).append("\",");
            json.append("\"year\":").append(book.getYear());
            json.append("}");

        }
        writer.write(json.toString());
        writer.flush();

    }
}
