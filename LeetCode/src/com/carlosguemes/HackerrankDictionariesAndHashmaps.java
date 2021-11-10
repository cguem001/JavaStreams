package com.carlosguemes;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HackerrankDictionariesAndHashmaps {

    /**
     * Complete the ´checkMagazine´ function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     * */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        int counter = 0;

        for (int i=0; i<note.size(); i++) {
            for (int j=0; j<magazine.size(); j++) {
                if (note.get(i).equals(magazine.get(j))) {
                    magazine.remove(j);
                    i += 1;
                    j = -1;
                    counter++;
                }
                if (counter > note.size()-1) {
                    break;
                }
            }
        }
        if (counter==note.size()) {
            System.out.println("Yes");
        } else {
            System.out.println("");
        }
    }

    /**
     * Complete the 'itemsSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY items as parameter.
     */

    public static List<Integer> itemSorted(List<Integer> items) {
        items.remove(0);
        Collections.sort(items);


        List<Integer> uniqueElements = items
                .stream()
                .distinct()
                .collect(Collectors.toList());
        int count = Collections.frequency(items, uniqueElements.stream().iterator());
        System.out.println(count);

//        List<Integer> dcDetails = item.getDc();
//        if (!CollectionUtils.isEmpty(dcDetails)) {
//            // If any valid local dc present localStock flag should be true
//            var validLocalDcDetail = dcDetails
//                    .stream()
//                    .filter(DcStock::isLocal)
//                    .filter(dcDetail -> dcDetail.getQty() > 0)
//                    .filter(dcDetail -> !dcDetail.isRestricted()).findAny();
//            deltaStockLevel.setLocalStock(validLocalDcDetail.isPresent() ? String.valueOf(true) : String.valueOf(false));
//        }
        return items;
    }

    public static List<Integer> itemsSort(List<Integer> items) {
        items.remove(0);
        Collections.sort(items);

        System.out.println(items);
        int counter = 0;
        int counter1 = 0;

        List<Integer> uniqueElements =  items
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Tbis is unique elements" + uniqueElements);
        for (int i=0; i<uniqueElements.size(); i++) {
            counter = 0;
            int final1=0;
            for (int j=0; j<items.size(); j++) {
                if (uniqueElements.get(i).equals(items.get(j))) {
                    final1 = j;
                    counter++;
                }
            }
            int myCounter = counter;
            if (counter < counter1) {
                while (counter > 0) {
                    items.remove(final1);
                    items.add(0, uniqueElements.get(i));
                    counter--;
                }
            }
            if (counter==counter1) {
                if (items.get(final1) < items.get(0)) {
                    items.remove(final1);
                    items.add(0, uniqueElements.get(i));
                }
            }
            counter1 = myCounter;
        }

        System.out.println(items);


//        List<Integer> repeated = new ArrayList<>();
//        // Extract repeated elements into repeated
//        for (int i=0; i<items.size(); i++) {
//            for (int j=i+1; j<items.size(); j++) {
//                if (items.get(i).equals(items.get(j))) {
//                    repeated.add(items.get(i));
//                    repeated.add(items.get(j));
//                    items.remove(items.get(i));
//                    items.remove(items.get(i));
//                    j--;
//                }
//                    if (items.get(i).equals(repeated.get(repeated.size()-1))) {
//                        repeated.add(items.get(i));
//                        items.remove(items.get(i));
//                    }
//            }
//        }
//
//        int temp1 = 0;
//        int temp2 = 0;
//        int temp3 = 0;
//
//        //Setting the repeated elements with less frequency at the top of the array
//        for (int i=0; i<repeated.size()-1; i++) {
//
//            if (repeated.get(i) == repeated.get(i+1)) {
//                temp2++;
//            }
//            if (temp2!=0 && (!repeated.get(i).equals(repeated.get(i + 1))) && temp2+1 < temp1) {
//                temp3 = temp2+i;
//                temp2++;
//                while (temp2 != 0) {
//                    repeated.add(0, repeated.get(i));
//                    temp2--;
//                }
//                while (repeated.get(0) == repeated.get(temp3)) {
//                    repeated.remove(temp3);
//                }
//            }
//            if (repeated.get(i) != repeated.get(i+1)) {
//                temp1 = temp2+1;
//                temp2=0;
//            }
//
//        }
//        System.out.println("This is item: " + items);
//        System.out.println("This is repeated: " + repeated);
//
//        items.addAll(repeated);
        return items;
    }

}
