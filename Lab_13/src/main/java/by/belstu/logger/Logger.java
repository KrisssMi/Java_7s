package by.belstu.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public static void info(String message) {
        try (FileWriter writer = new FileWriter("src/logs/stdout/log.txt", true)) {
            writer
                    .append(formatter.format(new Date()))
                    .append(" ")
                    .append(message)
                    .append(String.valueOf('\n'));
            writer.flush();         // Очищает выходной поток и принудительно записывает все буферизованные выходные байты
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}