package org.example.menu.command;

public class ExitCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Вихід з програми...");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "Вихід";
    }
}
