package Сonfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataValidity {

    public static boolean validityDataUser(String[] lineData) {
        if (validityBasicDataUser(lineData) == true) {
            if (validityDateUser(lineData) == true) {
                if (validityPhoneNomberUser(lineData) == true) {
                    if (validityGenderUser(lineData) == true) {
                        return true;
                    } else {
                        System.out.println("ERROR: input gender");
                        return false;
                    }
                } else {
                    System.out.println("ERROR: input phone nomber");
                    return false;
                }
            } else {
                System.out.println("ERROR: input birthdate");
                return false;
            }
        } else {
            System.out.println("ERROR: input basic data user");
            return false;
        }
    }

    public static boolean validityBasicDataUser(String[] lineData) {
        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        String temp;
        int count = 0;
        char currentCharacter;
        for (int i = 0; i <= 2; i++) {
            temp = lineData[i];
            for (int j = 0; j < temp.length(); j++) {
                currentCharacter = temp.charAt(j);
                if (Character.isDigit(currentCharacter)) {
                    count++;
                } else if (specialChars.contains(String.valueOf(currentCharacter))) {
                    count++;
                }
            }
        }
        if (count > 0) {
            System.out.println("ERROR: invalid characters (Surname Name Patronymic)");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validityDateUser(String[] lineData) {
        String temp = lineData[3].replaceAll("[^\\d]", ".");
        String format = "dd.MM.yyyy";
        java.util.Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(temp);
            if (!temp.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public static boolean validityPhoneNomberUser(String[] lineData) {
        String temp = lineData[4].replaceAll("[^\\d]", "");
        if (temp.length() == 11) {
            if (temp.matches("\\d+")) {
                return true;
            } else {
                System.out.println("ERROR: not numbers");
                return false;
            }
        } else {
            System.out.println("ERROR: not 11 number");
            return false;
        }
    }

    public static boolean validityGenderUser(String[] lineData) {
        String temp = lineData[5].toLowerCase();
        if (temp.equals("m") || temp.equals("f")) {
            return true;
        } else {
            System.out.println("ERROR: non f/m");
            return false;
        }
    }

}
