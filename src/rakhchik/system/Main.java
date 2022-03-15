package rakhchik.system;

public class Main {

    public static void main(String[] args) {
        Room room = new Room(1);
        room.addComputer();
        room.getStatistic();
        System.out.println("Удаление пк -1");
        room.removeComputer(-1);
        System.out.println("Удаление пк 1");
        room.removeComputer(1);
        System.out.println("Удаление пк 0");
        room.removeComputer(0);
        System.out.println("\n====================\n\n");
        System.out.println("Добавление ПК");
        room.addComputer();
        Computer computer = room.getComputer(0);
        computer.getStatistic();
        System.out.println("Попытка разблокировать выключенный пк");
        computer.lock();
        System.out.println("Попытка заблокировать выключенный пк");
        computer.unlock();
        System.out.println("\n====================\n\nВключение пк");
        computer.turnOn();
        System.out.println("Попытка блокировки заблокированного пк");
        computer.lock();
        System.out.println("Попытка разблокировки заблокированного пк");
        computer.unlock();
        System.out.println("Попытка блокировки разблокированного пк");
        computer.lock();
        System.out.println("\n====================\n\nВыключение пк");
        computer.turnOff();

        System.out.println("\n====================\n\nВывод всей статистики ПК");
        room.addComputer();
        room.addComputer();
        room.addComputer();
        room.getStatistic();

    }

}
