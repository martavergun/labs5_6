package org.example.menu;

import org.example.menu.command.*;
import org.example.model.PassengerTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final List<ICommand> commands = new ArrayList<>();
    private final List<PassengerTrain> trains = new ArrayList<>();

    public Menu() {
        initializeCommands();
    }

    private void initializeCommands() {
        commands.add(new AddTrainCommand(trains));
        commands.add(new AddWagonCommand(trains));
        commands.add(new CalculateTotalPassengersCommand(trains));
        commands.add(new FindWagonsCommand(trains));
        commands.add(new SortWagonsCommand(trains));
        commands.add(new SaveTrainsToFileCommand(trains));
        commands.add(new LoadTrainsFromFileCommand(trains));
        commands.add(new DeleteTrainCommand(trains));
        commands.add(new RemoveWagonCommand(trains));
        commands.add(new SimpleCommand());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();
            if (choice == -1)
                break;
            if (choice >= 0 && choice < commands.size()) {
                commands.get(choice).execute();
                if (choice == commands.size() - 1) break; // Вихід
            } else {
                System.out.println("Неправильний вибір, спробуйте ще раз.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(i + ". " + commands.get(i).getName());
        }
        System.out.println("-1. Exit");
    }
}
