import adresses.Address;
import inputs.UserInput;
import outputs.Output;

import java.io.IOException;
import java.util.HashMap;
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

            //Объект для учета уникальных стран
            Map<String, Integer> uniqueCountriesCounters = new HashMap<>();

            output.init(); //Приветственное сообщение

            while (true) {
                output.newOrder();

                output.country();
                String country = userInput.input(); //Вводим название страны
                if (country.equals("end")) {
                    break;
                }
                if (uniqueCountriesCounters.containsKey(country)){
                    uniqueCountriesCounters.replace(country, uniqueCountriesCounters.get(country) + 1);
                } else{
                    uniqueCountriesCounters.put(country, 1);

                }

                output.city();
                String city = userInput.input(); // Вводим название города
                if (city.equals("end")) {
                    break;
                }
                Address address = new Address(country, city);//Создаем объект, чтобы использовать его как ключ и проверить наличие в мапе

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
                output.uniqueCountries(uniqueCountriesCounters);
            }

            output.gameOver();

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

    }
}
//Добавьте, кроме общей суммы, вывод информации о том,
// в какое количество уникальных стран были оформлены доставки.
// Уникальность означает, что если по России было отправлено,
// например, три заказа, то учитываться это должно как одна страна.

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