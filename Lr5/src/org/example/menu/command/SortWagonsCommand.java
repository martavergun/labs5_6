package org.example.menu.command;

import org.example.model.PassengerTrain;
import java.util.List;
import java.util.Scanner;

public class SortWagonsCommand implements ICommand {
    private List<PassengerTrain> trains;

    public SortWagonsCommand(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        if (trains.isEmpty()) {
            System.out.println("Немає потягів для сортування.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер потяга для сортування за комфортом:");
        int trainNumber = scanner.nextInt();

        // Знаходимо потяг за номером
        PassengerTrain selectedTrain = null;
        for (PassengerTrain train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain != null) {
            // Сортуємо вагони та виводимо результат
            selectedTrain.sortWagonsByComfort();
            System.out.println("Відсортовані вагони за рівнем комфорту:");
            selectedTrain.displayWagons(); // Виводимо інформацію про вагони
        } else {
            System.out.println("Потяг з номером " + trainNumber + " не знайдено.");
        }
    }

    @Override
    public String getName() {
        return "Сортувати вагони за комфортом";
    }
}
