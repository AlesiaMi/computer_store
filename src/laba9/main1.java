package laba9;

import java.util.Scanner;

public class  main1 {
    //variant6
    public static void main(String[] args) {

        ComputerService computerService = new ComputerService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Инициализировать данные");
            System.out.println("2. Показать все элементы файла");
            System.out.println("3. Добавить элемент");
            System.out.println("4. Найти самый мощный компьютер");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    computerService.initializeData();
                    break;
                case 2:
                    computerService.showAllComputers();
                    break;
                case 3:
                    Computer newcomp = Computer.addComputer(scanner);
                    ComputerService.adddComputer(newcomp);
                    break;
                case 4:
                    computerService.findMostPowerfulComputer();
                    break;
                case 5:
                    System.out.println("Выход.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
