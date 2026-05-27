package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionPool {

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if(connection == null ||
                    connection.isClosed()) {

                Class.forName(
                        ApplicationConfig.getProperty(
                                "app.database.driver"
                        )
                );

                connection = DriverManager.getConnection(
                        ApplicationConfig.getProperty(
                                "app.database.url"
                        ),
                        ApplicationConfig.getProperty(
                                "app.database.username"
                        ),
                        ApplicationConfig.getProperty(
                                "app.database.password"
                        )
                );

                createSchema(connection);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;
    }

    private static void createSchema(
            Connection connection) {

        String sql = """
                CREATE TABLE IF NOT EXISTS quantity_measurements (

                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    operation VARCHAR(100),
                    measurement_type VARCHAR(100),
                    value1 DOUBLE,
                    value2 DOUBLE,
                    result VARCHAR(100),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        try(Statement statement =
                    connection.createStatement()) {

            statement.execute(sql);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
