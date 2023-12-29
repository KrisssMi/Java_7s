package by.belstu.servlets;

import by.belstu.logger.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GetWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName = req.getParameter("file");
        if (fileName != null) {
            Logger.info("file: " + fileName);
            File file = new File(req.getServletContext().getInitParameter("word-dir") + "//" + fileName);

            /*
            Заголовок Content-Type может использоваться как в запросах, так и в ответах HTTP.
            В запросах клиент сообщает серверу, какой тип данных он ожидает получить.
            В ответах сервер сообщает клиенту, какой тип данных он отправляет.
            */

            resp.setContentType("application/msword");
            resp.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
            resp.setContentLength((int) file.length());

            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));   // BufferedInputStream - буферизированный поток ввода, FileInputStream - поток ввода из файла
            int readBytes;
            while ((readBytes = buf.read()) != -1) {
                resp.getOutputStream().write(readBytes);    // getOutputStream - возвращает выходной поток байтов
            }
        }
    }
}