package com.bstu.lab15;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

public class EmailAdmin {
    public static String showMessages(final String userEmail, final String password) throws MessagingException, IOException {
        String host = "imap.googlemail.com";        // Адрес почтового сервера
        Properties properties = new Properties();
        properties.put("mail.imaps.ssl.trust", "*");
        Store store = Session.getInstance(properties, new javax.mail.Authenticator() {  // Проверка подлинности
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, password);
            }
        }).getStore("imaps");   // Получение хранилища
        store.connect(host, userEmail, password);
        Folder folder = store.getFolder("INBOX");   // Получение папки с входящими сообщениями
        folder.open(Folder.READ_ONLY);                 // Открытие папки в режиме только для чтения

        StringBuilder result = new StringBuilder();
        Message[] folderMessages = folder.getMessages(folder.getMessageCount()-5,folder.getMessageCount()); // Получение сообщений из папки

        for (Message message: folderMessages) {
            result.append("<div  style='cursor: pointer;'>");
            result.append("<p>Sender:   ").append(InternetAddress.toString(message.getFrom())).append("<br/>");
            result.append("Theme:   ").append(message.getSubject()).append("<br/>");
            String messageContent = new String();           // Получение содержимого сообщения
            String contentType = message.getContentType();  // Получение типа содержимого сообщения

            if (contentType.contains("multipart")) {        // Если сообщение состоит из нескольких частей
                Multipart multiPart = (Multipart) message.getContent();
                int numberOfParts = multiPart.getCount();   // Получение количества частей
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);    // Получение части
                    messageContent = part.getContent().toString();                          // Получение содержимого
                }
            } else if (contentType.contains("text/plain")
                    || contentType.contains("text/html")) {
                Object content = message.getContent();
                if (content != null) {
                    messageContent = content.toString();
                }
            }
            else {
                messageContent = message.getContent().toString();
            }
            result.append("Message: ").append(messageContent).append("<br/>");
            result.append("Date:    ").append(message.getSentDate()).append("</p>");
            result.append("</div>");
            result.append("\n-----------------------------------------------");
            result.append("</br>");
        }
        folder.close(true);
        store.close();              // Закрытие соединения
        return result.toString();
    }
}