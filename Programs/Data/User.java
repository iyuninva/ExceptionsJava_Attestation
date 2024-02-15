package Data;


public class User {
    private static String surname;
    private String name;
    private String patronymic;
    private String birthdate; // dd.mm.yyyy.
    private String phoneNomber; // +7 --- --- -- --
    private String gender; // символ латиницей f или m

    public User(String surname, String name, String patronymic, String birthdate, String phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.phoneNomber = phoneNumber;
        this.gender = gender;
    }

    public static String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNomber() {
        return phoneNomber;
    }

    public void setPhoneNomber(String phoneNomber) {
        this.phoneNomber = phoneNomber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s\n\n", surname, name, patronymic, birthdate, phoneNomber, gender);
    }

}
