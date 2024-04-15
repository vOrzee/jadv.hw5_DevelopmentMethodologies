package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> contactsMap = new HashMap<>();
    public int add(String name, String phoneNumber) {
        if (!contactsMap.containsValue(phoneNumber)) {
            contactsMap.put(name, phoneNumber);
        }
        return contactsMap.size();
    }

    public String findByNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : contactsMap.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

}