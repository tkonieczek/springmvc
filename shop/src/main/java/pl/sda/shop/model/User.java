package pl.sda.shop.model;

public class User {


    private int id;
    private String mail;
    private String name;
    private String surname;

    public User() {
    }

    public User(int id, String mail, String name, String surname) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
