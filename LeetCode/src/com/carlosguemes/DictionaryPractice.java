package com.carlosguemes;

import java.util.HashMap;
import java.util.Map;

public class DictionaryPractice {
    public static void main(String[] args) {
        // English to spanish dictionary
        Map<String, String> englSpanDictionary = new HashMap<>();

        //Putting things inside our dictionary
        englSpanDictionary.put("Monday", "Lunes");
        englSpanDictionary.put("Tuesday", "Martes");
        englSpanDictionary.put("Wednesday", "Miércoles");
        englSpanDictionary.put("Thursday", "Jueves");
        englSpanDictionary.put("Friday", "Viernes");
        englSpanDictionary.put("Saturday", "Sábado");
        englSpanDictionary.put("Sunday", "Domingo");

        //Retrieve things from our dictionary
        System.out.println(englSpanDictionary.get("Monday"));
        System.out.println(englSpanDictionary.get("Tuesday"));
        System.out.println(englSpanDictionary.get("Wednesday"));
        System.out.println(englSpanDictionary.get("Thursday"));
        System.out.println(englSpanDictionary.get("Friday"));
        System.out.println(englSpanDictionary.get("Saturday"));
        System.out.println(englSpanDictionary.get("Sunday"));

        // Print out all keys
        System.out.println(englSpanDictionary.keySet());

        // Print out all values
        System.out.println(englSpanDictionary.values());

        // Print out size
        System.out.println(englSpanDictionary.size());

        System.out.println();
        System.out.println();

        //Shopping List
        Map<String, Boolean> shoppingList = new HashMap<>();

        //Put some stuff in dictionary
        shoppingList.put("Ham", true);
        shoppingList.put("Bread", Boolean.TRUE);
        shoppingList.put("Oreos", Boolean.TRUE);
        shoppingList.put("Eggs", Boolean.FALSE);
        shoppingList.put("Sugar", false);

        //Retrieve items
        System.out.println(shoppingList.get("Ham"));
        System.out.println(shoppingList.get("Oreos"));

        //Key value pairs print out
        System.out.println(shoppingList.toString());

        //Is empty
        System.out.println(shoppingList.isEmpty());

        // Clear our dictionary
//        shoppingList.clear();
        System.out.println(shoppingList.toString());

        //Is empty
        System.out.println(shoppingList.isEmpty());

        //Remove things
        shoppingList.remove("Eggs");

        //Replace value for a certain key
        shoppingList.replace("Bread", Boolean.FALSE);
        System.out.println(shoppingList.toString());

        System.out.println();

        for (Map.Entry pairEntry : englSpanDictionary.entrySet()) {
            System.out.println(pairEntry.getKey() + " : " + pairEntry.getValue());
        }

        englSpanDictionary.containsKey("Monday"); // returns true, if key is found
        englSpanDictionary.containsValue("Lunes"); // returns true, if value is found

        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("John", 12345);
        empIds.put("Carl", 456456);
        empIds.put("Jerry", 65567);



    }
}
