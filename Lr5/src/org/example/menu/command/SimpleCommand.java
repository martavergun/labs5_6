package org.example.menu.command;

public class SimpleCommand implements ICommand {

    @Override
    public void execute() {
        System.out.println("Я команда!");
    }

    @Override
    public String getName() {
        return "Проста команда";
    }
}
