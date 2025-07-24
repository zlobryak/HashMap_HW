package inputs;

import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public String input() {
        return scanner.nextLine();
    }
}
