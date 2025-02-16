package laba9;

import java.io.Serializable;
import java.util.Scanner;

public class Computer implements Serializable {

    private static final long serialization = 1L;

    private String name;
    private double processorSpeed;
    private int ram;
    private int hdd;
    private String monitorType;
    private int monitorSize;
    private double price;

    public Computer(String name, double processorSpeed, int ram, int hdd, String monitorType, int monitorSize, double price) {
        setName(name);
        setProcessorSpeed(processorSpeed);
        setRam(ram);
        setHdd(hdd);
        setMonitorType(monitorType);
        setMonitorSize(monitorSize);
        setPrice(price);
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public double getProcessorSpeed() {return processorSpeed;}
    public void setProcessorSpeed(double processorSpeed){this.processorSpeed = processorSpeed;}

    public int getRam() {return ram;}
    public void setRam(int ram){this.ram = ram;}

    public int getHdd() {return hdd;}
    public void setHdd(int hdd){this.hdd = hdd;}

    public String getMonitorType() {return monitorType;}
    public void setMonitorType(String monitorType){this.monitorType = monitorType;}

    public int getMonitorSize() {return monitorSize;}
    public void setMonitorSize(int monitorSize){this.monitorSize = monitorSize;}

    public double getPrice() {return price;}
    public void setPrice(double price){this.price = price;}

    public static Computer addComputer(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название компьютера: ");
        String name = scanner.nextLine();
        System.out.print("Введите частоту процессора: ");
        double processorSpeed = scanner.nextDouble();
        System.out.print("Введите объем оперативной памяти (ГБ): ");
        int ram = scanner.nextInt();
        System.out.print("Введите объем жесткого диска (ГБ): ");
        int hdd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите тип монитора: ");
        String monitorType = scanner.nextLine();
        System.out.print("Введите размер монитора (дюймы): ");
        int monitorSize = scanner.nextInt();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();
        return new Computer(name, processorSpeed, ram, hdd, monitorType, monitorSize, price);
    }

    @Override
    public String toString() {
        return "Computer{" + "name='" + getName() + '\'' + ", processorSpeed=" + getProcessorSpeed() + ", ram=" + getRam() + ", hdd=" + getHdd() + ", monitorType='" + getMonitorType() + '\'' + ", monitorSize=" + getMonitorSize() + ", price=" + getPrice() + '}';
    }

}
