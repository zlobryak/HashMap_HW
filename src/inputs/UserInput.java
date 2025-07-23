package inputs;

import outputs.Output;

import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);
    Output output = new Output();


    public String fromConsole(String value) {
        switch (value) {
            case "country":
                output.country();
                break;
            case "city":
                output.city();
                break;
            case "weight":
                output.weight();
                break;
        }

        return scanner.nextLine();
    }
}
