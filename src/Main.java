import adresses.Address;
import inputs.UserInput;
import outputs.Output;

import java.io.IOException;
import java.util.Map;

import static inputs.FileInput.loadFromCSV;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput(); //Обработка всех вводов пользователя
        Output output = new Output(); //Обработка всех выводов в консоль
        try {
            Map<Address, Integer> costPerAddress = loadFromCSV("ListOfCountries.csv");

            output.init();
            boolean state = true;
            while (state) {
                output.newOrder();
                Address address = new Address(
                        userInput.fromConsole("country"),
                        userInput.fromConsole("city")
                );
                int weight = Integer.parseInt(userInput.fromConsole("weight"));
                System.out.println(costPerAddress.get(address) * weight);

            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }


    }
}

//...
//
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