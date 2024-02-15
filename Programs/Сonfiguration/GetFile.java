package Сonfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Data.User;
import Data.Directory.GetDirectory;
import Views.ViewConfig;

public class GetFile {

    public static User newUser() {
        String dataUser = ViewConfig.inputCommands(
                "Введите данные пользователя: Фамилия Имя Отчество Дата рождения (dd.mm.yyyy) Номер телефона Пол (f/m): ");
        String[] lineData = dataUser.split(" ");
        if (DataValidity.validityDataUser(lineData) == true) {
            try {
                User user = new User(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5]);
                return CreatedNewFileUser(user);
            } catch (Exception e) {
                System.err.println("\nERROR: Enter the required amount of data  - " + e.getMessage() + "\n");
                return newUser();
            }
        } else {
            return newUser();
        }
    }

    public static User CreatedNewFileUser(User user) {
        File newFile;
        String temp = String.valueOf(user);
        try {
            newFile = new File(GetDirectory.PathDirectory(), User.getSurname());
            try {
                FileWriter newDataLine = new FileWriter(newFile, true);
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

    public static void DeleteFileUser() {
        String nameFile = ViewConfig.inputCommands("Введите имя файла: ");
        Path path;
        try {
            path = Paths.get(GetDirectory.PathDirectory() + "\\" + nameFile + ".txt");
            Files.delete(path);
            System.out.println("--- File Delete ---");
        } catch (IOException e) {
            System.err.println("\nERROR: File not found - " + e.getMessage() + "\n");
        }
    }

    public static void SearchFileUser() {
        System.out.println("--- Found files ---");
        File dir;
        try {
            dir = new File(GetDirectory.PathDirectory());
            List<File> lst = new ArrayList<>();
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    lst.add(file);
                }
            } System.out.println(lst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}