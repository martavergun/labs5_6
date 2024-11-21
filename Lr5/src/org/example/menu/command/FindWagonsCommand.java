package org.example.menu.command;

import org.example.model.PassengerTrain;
import org.example.model.Wagon;

import java.util.List;
import java.util.Scanner;

public class FindWagonsCommand implements ICommand {
    private List<PassengerTrain> trains;

    public FindWagonsCommand(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мінімальну кількість пасажирів: ");
        int minPassengers = scanner.nextInt();
        System.out.print("Введіть максимальну кількість пасажирів: ");
        int maxPassengers = scanner.nextInt();

        boolean found = false;
        for (PassengerTrain train : trains) {
            for (Wagon wagon : train.getWagons()) {
                int passengerCount = wagon.getPassengerCount();
                if (passengerCount >= minPassengers && passengerCount <= maxPassengers) {
                    wagon.displayInfo();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Не знайдено вагонів, що відповідають заданому діапазону.");
        }
    }

    @Override
    public String getName() {
        return "Знайти вагони за кількістю пасажирів";
    }
}
