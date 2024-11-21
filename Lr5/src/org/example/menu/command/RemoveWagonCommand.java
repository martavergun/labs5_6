package org.example.menu.command;

import org.example.model.PassengerTrain;
import org.example.model.Wagon;
import java.util.List;
import java.util.Scanner;

public class RemoveWagonCommand implements ICommand {
    private List<PassengerTrain> trains;  // список потягів

    public RemoveWagonCommand(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Вивести список потягів
        System.out.println("Список потягів:");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println(i + 1 + ". Потяг №" + trains.get(i).getTrainNumber());
        }

        // Запитати номер потяга для вибору
        System.out.print("Введіть номер потяга для видалення вагона: ");
        int trainIndex = scanner.nextInt() - 1;

        // Перевірка на правильність введеного індексу
        if (trainIndex >= 0 && trainIndex < trains.size()) {
            PassengerTrain selectedTrain = trains.get(trainIndex);

            // Вивести список вагонів потяга
            System.out.println("Список вагонів потяга №" + selectedTrain.getTrainNumber() + ":");
            for (int i = 0; i < selectedTrain.getWagons().size(); i++) {
                Wagon wagon = selectedTrain.getWagons().get(i);
                System.out.println(i + 1 + ". " + "Вагон - Пасажири: " + wagon.getPassengerCount() + ", Багаж: " + wagon.getBaggageCount() + ", Рівень комфорту: " + wagon.getComfortLevel());
            }

            // Запитати номер вагона для видалення
            System.out.print("Введіть номер вагона для видалення: ");
            int wagonIndex = scanner.nextInt() - 1;

            // Перевірка на правильність введеного індексу
            if (wagonIndex >= 0 && wagonIndex < selectedTrain.getWagons().size()) {
                Wagon removedWagon = selectedTrain.getWagons().remove(wagonIndex);
                System.out.println("Вагон з пасажирами: " + removedWagon.getPassengerCount() + " успішно видалено.");
            } else {
                System.out.println("Невірний номер вагона.");
            }
        } else {
            System.out.println("Невірний номер потяга.");
        }
    }

    @Override
    public String getName() {
        return "Видалити вагон";
    }
}
