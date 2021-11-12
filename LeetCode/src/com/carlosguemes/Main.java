package com.carlosguemes;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(10);

        System.out.println(list);

        int [] integer = new int[]{2, 5, 5, 11};
        int target = 10;

        LetCode letCode = new LetCode();
//        System.out.println(Arrays.toString(letCode.twoSum(integer, target)));

        LinkedList list1 = new LinkedList();
        list1.add(9);
//        list1.add(7);
//        list1.add(6);
//        list1.add(4);

        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(9);
        list2.add(9);
//        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);
        list2.add(9);


        ListNode l1 = new ListNode();

        ListNode l2 = new ListNode();

        System.out.println(letCode.addTwoNumbers(list1, list2));
    }
}
