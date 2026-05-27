package org.example.repository;

import org.example.entity.QuantityMeasurementEntity;
import org.example.exception.DatabaseException;
import org.example.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    @Override
    public void save(
            QuantityMeasurementEntity entity) {

        String sql =
                "INSERT INTO quantity_measurements " +
                "(operation, measurement_type, " +
                "value1, value2, result) " +
                "VALUES (?, ?, ?, ?, ?)";

        try(Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    entity.getOperation()
            );

            statement.setString(
                    2,
                    entity.getMeasurementType()
            );

            statement.setDouble(
                    3,
                    entity.getValue1()
            );

            statement.setDouble(
                    4,
                    entity.getValue2()
            );

            statement.setString(
                    5,
                    entity.getResult()
            );

            statement.executeUpdate();

        } catch (Exception e) {

            throw new DatabaseException(
                    "Save Failed",
                    e
            );
        }
    }

    @Override
    public List<QuantityMeasurementEntity>
    findAll() {

        List<QuantityMeasurementEntity>
                list = new ArrayList<>();

        String sql =
                "SELECT * FROM quantity_measurements";

        try(Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery()) {

            while(resultSet.next()) {

                QuantityMeasurementEntity entity =
                        new QuantityMeasurementEntity(
                                resultSet.getString("operation"),
                                resultSet.getString("measurement_type"),
                                resultSet.getDouble("value1"),
                                resultSet.getDouble("value2"),
                                resultSet.getString("result")
                        );

                list.add(entity);
            }

        } catch (Exception e) {

            throw new DatabaseException(
                    "Fetch Failed",
                    e
            );
        }

        return list;
    }

    @Override
    public long getTotalCount() {

        String sql =
                "SELECT COUNT(*) FROM quantity_measurements";

        try(Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery()) {

            if(resultSet.next()) {

                return resultSet.getLong(1);
            }

        } catch (Exception e) {

            throw new DatabaseException(
                    "Count Failed",
                    e
            );
        }

        return 0;
    }

    @Override
    public void deleteAll() {

        String sql =
                "DELETE FROM quantity_measurements";

        try(Connection connection =
                    ConnectionPool.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)) {

            statement.executeUpdate();

        } catch (Exception e) {

            throw new DatabaseException(
                    "Delete Failed",
                    e
            );
        }
    }
}
