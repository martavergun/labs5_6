package org.example.menu.command;

import org.example.model.PassengerTrain;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class DeleteTrainCommand implements ICommand {
    private List<PassengerTrain> trains;

    public DeleteTrainCommand(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Виводимо список потягів
        System.out.println("Список потягів:");
        for (int i = 0; i < trains.size(); i++) {
            System.out.println((i + 1) + ". Потяг №" + trains.get(i).getTrainNumber());
        }

        // Запитуємо номер потяга для видалення
        System.out.print("Введіть номер потяга для видалення: ");
        int trainNumber = scanner.nextInt();

        // Шукаємо потяг з вказаним номером
        Iterator<PassengerTrain> iterator = trains.iterator();
        boolean trainFound = false;

        while (iterator.hasNext()) {
            PassengerTrain train = iterator.next();
            if (train.getTrainNumber() == trainNumber) {
                // Якщо потяг знайдений, видаляємо його з колекції
                iterator.remove();
                System.out.println("Потяг №" + trainNumber + " успішно видалено.");
                trainFound = true;
                break;
            }
        }

        if (!trainFound) {
            System.out.println("Невірний номер потяга.");
        }
    }

    @Override
    public String getName() {
        return "Видалити потяг";
    }
}
