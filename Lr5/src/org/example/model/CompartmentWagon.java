package org.example.model;

public class CompartmentWagon extends Wagon {

    public CompartmentWagon(int passengerCount, int baggageCount) {
        super(passengerCount, baggageCount, 2); // Рівень комфорту для купейного вагона = 2
    }

    @Override
    public void displayInfo() {
        // Якщо потрібно вивести в консоль більш детальну інформацію
        System.out.println("Купейний вагон - Пасажири: " + getPassengerCount() +
                ", Багаж: " + getBaggageCount() + ", Рівень комфорту: " + getComfortLevel());
    }

    @Override
    public String toString() {
        // Виведення у форматі для збереження в файл
        return "CompartmentWagon," + getPassengerCount() + "," + getBaggageCount();
    }
}
