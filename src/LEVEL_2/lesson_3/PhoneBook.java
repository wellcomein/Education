package LEVEL_2.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, String> phoneBook = new HashMap<>();

    void add(String phone, String surname) throws PhoneNumberDuplicateException {
        if (this.phoneBook.containsKey(phone))
            throw new PhoneNumberDuplicateException();
        this.phoneBook.put(phone, surname);
    }

    ArrayList<String> get(String surname) throws SurnameNotFoundException {
        ArrayList<String> number = new ArrayList<>();
        if (phoneBook.containsValue(surname)) {
            Iterator iterator = phoneBook.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                if (entry.getValue().equals(surname)) number.add((String)entry.getKey());
            }
        } else throw new SurnameNotFoundException();

        return number;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        try {
            phoneBook.add("+7 999 777 00 11", "Wane");
            phoneBook.add("+7 666 192 57 12", "Clark");
            phoneBook.add("+7 666 192 57 10", "Clark");

            System.out.println(phoneBook.get("Clark"));

        } catch (PhoneNumberDuplicateException e) {
            e.printStackTrace();
        } catch (SurnameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class PhoneNumberDuplicateException extends Exception {
    PhoneNumberDuplicateException() {
        super("Duplicate phone number. Change phone number or delete old contact.");
    }
}
class SurnameNotFoundException extends Exception {
    SurnameNotFoundException () {
        super("Surname not found.");
    }
}
