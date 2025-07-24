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
        int totalCost = 0;
        try {
            //Объект для хранения адресов и цен
            Map<Address, Integer> costPerAddress = loadFromCSV("ListOfCountries.csv");

            output.init(); //Приветственное сообщение

            while (true) {
                output.newOrder();

                output.country();
                String country = userInput.input(); //Вводим название страны
                if (country.equals("end")) {
                    break;
                }

                output.city();
                String city = userInput.input(); // Вводим название города
                if (city.equals("end")) {
                    break;
                }
                Address address = new Address(country, city);
                System.out.println(address);//Создаем объект, чтобы использовать его как ключ и проверить наличие в мапе
                if (!costPerAddress.containsKey(address)){
                    output.noSuchAddress(address);
                    continue;
                }
                output.weight();
                String endCheck = userInput.input(); //Сохраним в переменную, чтобы проверить на завершение программы
                if (endCheck.equals("end")) {
                    break;
                } else {
                    int cost = costPerAddress.get(address) *Integer.parseInt(endCheck);
                    output.cost(cost);
                    totalCost = totalCost + cost;
                    output.totalCost(totalCost);
                }
            }

            output.gameOver();

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

    }
}
//Вашей задачей будет написание сервиса услуг доставки товаров по миру.
//
//Адрес доставки будет задаваться двумя данными: страна (country) и город (city).
// Создайте для этих целей класс Address.
//
//В main создайте несколько адресов и мапу costPerAddress, в которой ключом будет адрес,
// а значением — цена доставки 1 кг груза. Заполните мапу созданными адресами
// и произвольными значениями цен доставки по этим адресам.
//
//Далее в цикле пользователь вводит заказы (или end). Каждый заказ состоит из трёх частей:
// страны, города и веса в кг доставляемого товара. В ответ нужно написать,
// что такой адрес не обслуживается, или написать стоимость доставки и
// общую сумму всех сделанных доставок.

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