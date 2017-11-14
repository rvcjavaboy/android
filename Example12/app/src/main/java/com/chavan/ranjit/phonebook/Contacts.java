package com.chavan.ranjit.phonebook;

/**
 * Created by ranjit on 10/11/17.
 */

public class Contacts {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Contacts.id = id;
    }

    private String name,phonenumber;
    private static int id;

}
