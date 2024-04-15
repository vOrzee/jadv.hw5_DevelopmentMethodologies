package ru.netology;

import java.util.*;

public class PhoneBook {
    private final Map<String, String> contactsMap = new TreeMap<>();
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

    public String findByName(String name) {
        return contactsMap.get(name);
    }

    public List<String> printAllNames() {
        ArrayList<String> sortedNames = new ArrayList<>(contactsMap.keySet()); // TreeMap автоматически сортирует ключи в алфавитном порядке при вставке.
        sortedNames.forEach(System.out::println);
        return sortedNames;
    }
}