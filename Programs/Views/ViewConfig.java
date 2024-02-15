package Views;

import java.util.Scanner;

public class ViewConfig {

    public static String inputCommands(String commands) {
        Scanner in = new Scanner(System.in);
        System.out.print(commands);
        return in.nextLine();
    }

}
