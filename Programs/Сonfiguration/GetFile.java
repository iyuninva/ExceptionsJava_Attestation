package Сonfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import Data.User;
import Data.Directory.GetDirectory;
import Views.ViewConfig;

public class GetFile {

    public static User newUser() {
        String dataUser = ViewConfig.inputCommands(
                "Введите данные пользователя: Фамилия Имя Отчество Дата рождения (dd.mm.yyyy) Номер телефона Пол (f/m): ");
        String[] temp = dataUser.split(" ");
        try {
            User user = new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
            return CreatedNewFileUser(user);
        } catch (Exception e) {
            System.err.println("\nERROR: Enter the required amount of data  - " + e.getMessage() + "\n");
            return newUser();
        }
    }

    public static User CreatedNewFileUser(User user) {
        try {
            File newFile = new File(GetDirectory.PathDirectory(), User.getSurname());
            newFile.createNewFile();
            try {
                FileWriter newDataLine = new FileWriter(newFile);
                String temp = String.valueOf(user);
                newDataLine.write(temp);
                newDataLine.close();
                System.out.println("--- Created new File ---");
            } catch (FileNotFoundException e) {
                System.err.println("\nERROR: File not found - " + e.getMessage() + "\n");
            }
        } catch (IOException e) {
            System.err.println("\nERROR: File not bee created - " + e.getMessage() + "\n");
        }
        return user;
    }

}
