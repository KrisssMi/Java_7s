package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final ConnectionPool instance = new ConnectionPool(10);

    private final BlockingQueue<Connection> pool;   // BlockingQueue - очередь с блокировкой для многопоточного приложения

    public ConnectionPool(int maxPoolSize) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://objective_kare:1433;databaseName=uwsr;user=sa;password=r00t.R00T;trustServerCertificate=true";
            this.pool = new LinkedBlockingQueue<>(maxPoolSize);
            for (int i = 0; i < maxPoolSize; i++) {
                try {
                    pool.offer(DriverManager.getConnection(url));   // offer - добавляет элемент в очередь
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();             // take - извлекает элемент из очереди
    }

    public void returnConnection(Connection connection) {
        if (connection != null) pool.offer(connection);
    }
}