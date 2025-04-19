package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.example.dbService.DbService;
import org.example.model.Book;
import org.example.model.Result;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/books")
public class MenuServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        DbService dbService = new DbService();
        StringBuilder str = new StringBuilder();
        int tr = 1;
        for (Book book : dbService.getBooks()) {
            str.append(
                    "        <tr>\n" +
                            "            <td>" + tr + "</td>\n" +
                            "            <td>" + book.getName() + "</td>\n" +
                            "            <td>" + book.getPrice() + "so'm</td>\n" +
                            "            <td>" + book.getWriter() + "</td>\n" +
                            "            <td>" + book.getYear() + "-yil</td>\n" +
                            "            <td>\n" +
                            "                <button class=\"btn btn-warning\">Taxrirlash</button>\n" +
                            "            </td>\n" +
                            "            <td>\n" +
                            "                <button class=\"btn btn-danger\">O'chirish</button>\n" +
                            "            </td>\n" +
                            "        </tr>\n"
            );
            tr++;
        }

        writer.write(
                "<!doctype html>\n" +
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
                        "    <button class=\"btn btn-success mt-3 mb-3\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Saqlash</button>\n" +
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
                        str +
                        "        </tbody>\n" +
                        "    </table>\n" +
                        "</div>\n" +
                        "<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                        "    <div class=\"modal-dialog\">\n" +
                        "        <div class=\"modal-content\">\n" +
                        "            <div class=\"modal-header\">\n" +
                        "                <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Kitob saqlash</h1>\n" +
                        "                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n" +
                        "            </div>\n" +
                        "            <div class=\"modal-body\">\n" +
                        "                <form action=\"/main\" method=\"post\">\n" +
                        "                    <input type=\"text\" class=\"form-control mb-2\" placeholder=\"Kitob nomini kiriting\" id=\"name\" name=\"name\"/>\n" +
                        "                    <input type=\"number\" class=\"form-control mb-2\" placeholder=\"Kitob narxini kiriting\" id=\"price\" name=\"price\"/>\n" +
                        "                    <input type=\"text\" class=\"form-control mb-2\" placeholder=\"Kitob yozuvchisini kiriting\" id=\"writer\" name=\"writer\"/>\n" +
                        "                    <input type=\"number\" class=\"form-control mb-2\" placeholder=\"Kitob chiqqan yilni kiriting\" id=\"year\" name=\"year\"/>\n" +
                        "                    <div class=\"modal-footer\">\n" +
                        "                        <button type=\"button\" class=\"btn btn-danger\" data-bs-dismiss=\"modal\">Yopish</button>\n" +
                        "                        <button type=\"submit\" class=\"btn btn-primary\">Saqlash</button>\n" +
                        "                    </div>\n" +
                        "                </form>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>" +
                        "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String writer = req.getParameter("writer");
        int year = Integer.parseInt(req.getParameter("year"));
        DbService dbService = new DbService();
        Result result = dbService.addBook(Book.builder().name(name).price(price).writer(writer).year(year).build());
        PrintWriter writers = resp.getWriter();
        resp.sendRedirect("/main");
    }
}
