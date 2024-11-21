package org.example.model;

public class PassengerWagon extends Wagon {

    public PassengerWagon(int passengerCount, int baggageCount) {
        super(passengerCount, baggageCount, 1); // Рівень комфорту для пасажирського вагона = 1
    }

    @Override
    public void displayInfo() {
        // Виводить інформацію про пасажирський вагон
        System.out.println("Пасажирський вагон - Пасажири: " + getPassengerCount() +
                ", Багаж: " + getBaggageCount() + ", Рівень комфорту: " + getComfortLevel());
    }

    @Override
    public String toString() {
        // Виведення у форматі для збереження в файл
        return "PassengerWagon," + getPassengerCount() + "," + getBaggageCount();
    }
}
