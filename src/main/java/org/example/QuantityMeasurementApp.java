package org.example;

import org.example.controller.QuantityMeasurementController;
import org.example.repository.IQuantityMeasurementRepository;
import org.example.repository.QuantityMeasurementDatabaseRepository;
import org.example.service.IQuantityMeasurementService;
import org.example.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository
                repository =
                new QuantityMeasurementDatabaseRepository();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(
                        repository
                );

        QuantityMeasurementController controller =
                new QuantityMeasurementController(
                        service
                );

        boolean compare =
                controller.compare(10,10);

        double add =
                controller.add(10,20);

        System.out.println(
                "Compare Result : " + compare
        );

        System.out.println(
                "Add Result : " + add
        );

        System.out.println(
                "Total Records : " +
                repository.getTotalCount()
        );

        repository.deleteAll();

        System.out.println(
                "UC16 PROJECT RUN SUCCESSFULLY"
        );
    }
}
