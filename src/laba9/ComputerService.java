package laba9;

import java.io.*;

public class ComputerService {

    private static final String FILE_NAME = "computers.dat";

    public void initializeData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)))) {
            oos.writeObject(new Computer("Computer1", 3.5, 4, 500, "LCD", 24, 450.0));
            oos.writeObject(new Computer("Computer2", 2.5, 8, 1000, "LED", 27, 550.0));
            oos.writeObject(new Computer("Computer3", 3.5, 16, 10000, "LCD", 27, 1000.0));
            oos.writeObject(new Computer("Computer4", 2, 4, 1000, "LED", 21, 550.0));
            oos.writeObject(new Computer("Computer5", 1, 8, 500, "LCD", 32, 550.0));
            oos.writeObject(new Computer("Computer6", 4, 16, 500, "LED", 27, 400.0));
            oos.writeObject(new Computer("Computer7", 3, 8, 1000, "LCD", 27, 500.0));
            oos.writeObject(new Computer("Computer8", 2, 4, 1000, "LED", 24, 600.0));
            oos.writeObject(new Computer("Computer9", 2.5, 8, 1000, "LED", 21, 550.0));
            oos.writeObject(new Computer("Computer10", 1, 8, 1000, "LCD", 27, 800.0));
            oos.writeObject(new Computer("Computer11", 3.5, 8, 1000, "LCD", 27, 450.0));
            oos.writeObject(new Computer("Computer12", 4, 16, 10000, "LED", 32, 650.0));
            oos.writeObject(new Computer("Computer13", 4, 8, 1000, "LCD", 27, 700.0));
            oos.writeObject(new Computer("Computer14", 2, 8, 1000, "LED", 32, 600.0));
            oos.writeObject(new Computer("Computer15", 3.5, 8, 1000, "LED", 27, 800.0));

            System.out.println("Данные инициализированы и записаны в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при инициализации данных: " + e.getMessage());
        }
    }

    public void showAllComputers() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            while (true) {
                Computer computer = (Computer) ois.readObject();
                System.out.println(computer);
            }
        } catch (EOFException e) {
            // Конец файла, прекращаем чтение
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении данных: " + e.getMessage());
        }
    }

    public static void adddComputer(Computer newComputer) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME, true))) {
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        }) {
            oos.writeObject(newComputer);
            System.out.println("компьютер добавлен.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    public void findMostPowerfulComputer() {
        Computer mostPowerfulComputer = null;
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            while (true) {
                Computer computer = (Computer) ois.readObject();
                if (computer.getRam() >= 2 && (mostPowerfulComputer == null || computer.getProcessorSpeed() > mostPowerfulComputer.getProcessorSpeed())) {
                    mostPowerfulComputer = computer;
                }
            }
        } catch (EOFException e) {
            // Конец файла достигнут, прекращаем чтение
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении данных: " + e.getMessage());
        }

        if (mostPowerfulComputer != null) {
            System.out.println("Самый мощный компьютер: " + mostPowerfulComputer);
        } else {
            System.out.println("Подходящий компьютер не найден.");
        }
    }
}
