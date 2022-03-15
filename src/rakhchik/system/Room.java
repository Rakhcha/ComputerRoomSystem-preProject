package rakhchik.system;

import java.util.ArrayList;
import java.util.List;

public class Room {

    // ID - номер комнаты
    // computerList - список компьютеров в комнате
    private final int ID;
    private final List<Computer> computerList = new ArrayList<>();

    // Конструктор принимающий номер комнаты
    public Room(int ID){
        this.ID = ID;
    }

    // Геттер возвращающий номер комнаты
    public int getID() {
        return ID;
    }

    // Добавление ПК в комнате
    public void addComputer(){
        Computer computer = new Computer();
        computerList.add(computer);
        System.out.println("[Log] Был добавлен новый компьютер с идентификатором " + computer.getUUID() + " под номером - " + computerList.size() + ".");
    }

    // Удаление ПК из комнаты под номером number
    public void removeComputer(int number){
        // Проверка существование ПК
        if(!existPC(number)) return;
        // Если номер ПК существует удаляем его
        computerList.remove(number);
        System.out.println("[Log] Компьютер под номером " + (number + 1) + " был удалён.");
    }

    // Геттер ПК из комнаты под номером number
    public Computer getComputer(int number){
        // Проверка существование ПК
        if(!existPC(number)) return null;
        return computerList.get(number);
    }

    // Если номер ПК меньше длинны листа - 1 и больше 0, возвращаем true
    private boolean existPC(int number){
        // Можно сократить в одну строку, но без сообщения.
        if(number < computerList.size() && number >= 0) return true;
        System.out.println("[Warning] Неверный номер компьютера");
        return false;
    }

    // Вывод статистики всех ПК
    public void getStatistic(){
        for(Computer computer : computerList) computer.getStatistic();
    }

}
