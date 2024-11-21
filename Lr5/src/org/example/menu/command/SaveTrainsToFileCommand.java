package org.example.menu.command;

import org.example.model.PassengerTrain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveTrainsToFileCommand implements ICommand {
    private final List<PassengerTrain> trains;

    public SaveTrainsToFileCommand(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        String filePath = "C:\\Users\\ADMIN\\IdeaProjects\\Lr5\\trains.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (PassengerTrain train : trains) {
                writer.write("Train:" + train.getTrainNumber());
                writer.newLine();
                train.getWagons().forEach(wagon -> {
                    try {
                        writer.write(wagon.toString());
                        writer.newLine();
                    } catch (IOException e) {
                        System.out.println("Помилка запису вагона: " + e.getMessage());
                    }
                });
            }
            System.out.println("Дані про потяги збережено у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Зберегти потяги у файл";
    }
}
