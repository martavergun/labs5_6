package org.example.menu.command;

import org.example.model.PassengerTrain;

import java.util.List;
import java.util.Scanner;

public class AddTrainCommand implements ICommand {
    private List<PassengerTrain> trains;

    public AddTrainCommand(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга: ");
        int trainNumber = scanner.nextInt();

        // Створюємо новий потяг із порожнім списком вагонів
        PassengerTrain newTrain = new PassengerTrain(trainNumber);
        trains.add(newTrain);
        System.out.println("Потяг додано: номер " + trainNumber);
    }

    @Override
    public String getName() {
        return "Додати потяг";
    }
}
