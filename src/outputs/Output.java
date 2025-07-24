package outputs;

import adresses.Address;

import java.util.Map;

public class Output {

    public void init() {
        System.out.println("Приветствуем вас username!");
    }

    public void newOrder() {
        System.out.println();
        System.out.println("Заполнение нового заказа.");
    }

    public void country() {
        System.out.print("Введите страну: ");
    }

    public void city() {
        System.out.print("Введите город: ");
    }

    public void weight() {
        System.out.print("Введите вес (кг): ");
    }

    public void cost(int cost) {
        System.out.printf("Стоимость доставки составит: %d\n", cost);
    }

    public void totalCost(int totalCost) {
        System.out.printf("Общая стоимость всех доставок: %d\n", totalCost);
    }

    public void gameOver() {
        System.out.println("Программа завершена!");
    }

    public void noSuchAddress(Address address) {
        System.out.printf("Адрес %S %S не обслуживается.\n", address.getCountry(), address.getCity());
    }

    public void uniqueCountries(Map<String, Integer> counter) {
        System.out.printf("Количество уникальных стран в заках: %d\n", counter.size());
        for (Map.Entry<String, Integer> country : counter.entrySet()) {
            System.out.printf("Страна: %s, отправлено %d\n", country.getKey(), country.getValue());
        }
    }
}
//Заполнение нового заказа.
//Введите страну: Россия
//Введите город: Казань
//Введите вес (кг): 13
//Стоимость доставки составит: 2600 руб.
//Общая стоимость всех доставок: 12600 руб.
//
//Заполнение нового заказа.
//Введите страну: Россия
//Введите город: Лысые Пеньки
//Введите вес (кг): 3
//Доставки по этому адресу нет