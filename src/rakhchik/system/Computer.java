package rakhchik.system;

import java.util.Random;

public class Computer {

    // UUID: уникальный идентификатор ПК
    //  powered: true - ПК включен; false - ПК выключен
    //  locked: true - ПК заблокирован; false - ПК разблокирован
    private final String UUID;
    private boolean powered = false;
    private boolean locked = true;

    // Конструктор ПК, где генерируется случайный идентификатор с помощью метода generateUUID
    public Computer(){
        this.UUID = generateUUID();
    }

    // Геттер возвращающий идентификатор ПК
    public String getUUID(){
        return UUID;
    }

    // Включение ПК
    public void turnOn(){
        // Если пк уже включен, выводим об этом информацию
        if(powered) {
            System.out.println("[Warning] Компьютер уже включен.");
            return;
        }
        // Если пк выключен - включаем
        powered = true;
        System.out.println("[Log] Компьютер включен.");
    }

    // Выключение ПК
    public void turnOff(){
        // Если пк уже выключен, выводим об этом информацию
        if(!powered) {
            System.out.println("[Warning] Компьютер номер уже выключен.");
            return;
        }
        // Перед выключением блокируем пк, если он не заблокирован
        if (!locked) lock();
        // Если пк включен - выключаем
        powered = false;
        System.out.println("[Log] Компьютер номер выключен.");
    }

    // Блокировка ПК
    public void lock(){
        // Если ПК выключен выводим информацию об этом
        if(!powered){
            System.out.println("[Warning] Компьютер номер выключен.");
            return;
        }
        // Если ПК уже заблокирован выводим информацию об этом
        if(locked) {
            System.out.println("[Warning] Компьютер номер уже заблокирован.");
            return;
        }
        // Если ПК включен и разблокирован - блокируем
        locked = true;
        System.out.println("[Log] Компьютер номер заблокирован.");
    }

    // Разблокирование ПК
    public void unlock(){
        // Если ПК выключен выводим информацию об этом
        if(!powered){
            System.out.println("[Warning] Компьютер номер выключен.");
            return;
        }
        // Если ПК уже разблокирован выводим информацию об этом
        if(!locked) {
            System.out.println("[Warning] Компьютер номер уже разблокирован.");
            return;
        }
        // Если ПК включен и заблокирован - разблокируем
        locked = false;
        System.out.println("[Log] Компьютер номер разблокирован.");
    }

    // Получение информации о ПК
    public void getStatistic(){
        System.out.println("Компьютер " + UUID
                + ":\n\tПитание: " + (powered ? "включен" : "выключен")
                + ";\n\tСостояние: " + (locked ? "заблокирован" : "разблокирован") + ";");
    }

    // Генерация UUID
    private String generateUUID(){
        // Создается строка с символами
        String data = "88ABCD55EFG44HIJ99KLM33NOP66QRS22TUVW77XYZ11";
        StringBuilder UUID = new StringBuilder();
        // Циклом создается случайная строка с помощью Random
        for(int i = 0; i < 16; i++) UUID.append(data.charAt(new Random().nextInt(data.length())));
        return UUID.toString();
    }

}
