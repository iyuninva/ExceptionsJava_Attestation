package Views;

import Сonfiguration.GetFile;

public class ViewUser {

    public static void runProgramm() {
        infoCommands();
        Commands com = Commands.NONE;
        try {
            String commands = ViewConfig.inputCommands("Введите команду: ");
            com = Commands.valueOf(commands.toUpperCase());
            switch (com) {
                case ADD:
                    GetFile.newUser();
                    break;
                case LIST: // будет дорабатываться
                    GetFile.SearchFileUser();
                    break;
                case DELETE:
                    GetFile.DeleteFileUser();
                    break;
                case EXIT:
                    System.out.println(" --- Program Exit --- ");
                    break;
            }
        } catch (Exception e) {
            System.err.println("\nERROR: input commands - " + e.getMessage() + "\n");
            runProgramm();
        }
    }

    public static void infoCommands() {
        System.out.println(
                " - ADD (Добавить пользователя) \n - LIST (Выдать полный список пользователей) \n - DELETE (Удалить пользователя) \n - EXIT (Закрыть программу)\n");
    }
}
