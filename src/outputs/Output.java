package outputs;

public class Output {

    public void init() {
        System.out.println("Приветствуем вас username!");
        System.out.println();
    }

    public void newOrder() {
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

    public void prise() {
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