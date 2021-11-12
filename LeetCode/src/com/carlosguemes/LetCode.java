package com.carlosguemes;

import java.util.LinkedList;

public class LetCode {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     */
    public int[] twoSum(int[] nums, int target) {

        int[] myArray = new int[2];

        for (int i=0; i<nums.length-1; i++) {
            for (int j=1; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && i != j) {
                    myArray[0] = i;
                    myArray[1] = j;
                    i = nums.length - 1;
                }
            }
        }
        return  myArray;
    }

    public ListNode addTwoClasses(ListNode l1, ListNode l2) {
        int x = 0;
        int y = 0;
        int z = 1;

        while(l1 != null){
            x += z*l1.val;
            z*=10;
            l1 = l1.next;
        }

        z = 1;
        while(l2 != null){
            y += z*l2.val;
            z*=10;
            l2 = l2.next;
        }

        int sum = x + y;
        if (sum == 0) {
            return new ListNode(0);
        }

        ListNode node = null, head = null;
        while(sum > 0){
            int digit = sum % 10;
            ListNode n = new ListNode(digit);
            if (node == null) {
                head = node = n;
            } else {
                node.next = n;
                node = node.next;
            }

            sum = sum / 10;
        }

        return head;

    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public LinkedList addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> myList1 = new LinkedList<>();
        LinkedList<Integer> myList2 = new LinkedList<>();
        LinkedList<String> myList = new LinkedList<>();
        String myString1 = "";
        String myString2 = "";

        //Loop to add l1 to myList1 in reverse order
        for (int i = l1.size()-1; i>=0; i--) {
            myList1.add(l1.get(i));
        }

        //Loop to add l2 to myList2 in reverse order
        for (int i = l2.size()-1; i>=0; i--) {
            myList2.add(l2.get(i));
        }

        //Loop to add myList1 into myString1
        for (int i=0; i<myList1.size(); i++) {
            myString1 += myList1.get(i);
        }

        //Loop to add myList2 into myString2
        for (int i=0; i<myList2.size(); i++) {
            myString2 += myList2.get(i);
        }
        int number1 = Integer.parseInt(myString1);
        int number2 = Integer.parseInt(myString2);

        int finalSum = number1 + number2;
        String lastOne = String.valueOf(finalSum);


        for (int i = lastOne.length()-1; i >=0; i--) {
            myList.add(String.valueOf(lastOne.charAt(i)));
        }
//        System.out.println(myList);



        return myList;

    }

}
