package com.chavan.ranjit.phonebook;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by ranjit on 10/11/17.
 */

public class ContactName {
    private ArrayList<Object> contact=new ArrayList<Object>();
    private Contacts c=new Contacts();
    ContactName(){
        c.setId(0);
    }
    public void addContact(String name,String phone){
        c.setId(c.getId()+1);
        c.setName(name);
        c.setPhonenumber(phone);
        contact.add(c);
    }



    public Contacts getInformation(int id) {

        Contacts c=null;
        ListIterator li = contact.listIterator();
        while (li.hasNext()) {
            c = (Contacts) li.next();
            if (c.getId() == id) {
                return c;
            }

        }

        return c;
    }


}
