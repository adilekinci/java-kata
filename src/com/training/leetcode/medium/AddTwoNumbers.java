package com.training.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstNumber = extractTheNumber(l1);
        int secondNumber = extractTheNumber(l2);
        int sum = firstNumber + secondNumber;
        Stack<Integer> numberStack = revertNumberAndPutItinList(sum);
        ListNode returnNode = new ListNode();
        while (!numberStack.isEmpty()) {
            new ListNode(numberStack.pop());
        }
        return returnNode;

    }

    private Stack<Integer> revertNumberAndPutItinList(int number) {
        Stack<Integer> numbers = new Stack<>();
        while(number>0) {
            numbers.push(number % 10);
            number = number/10;
        }
        return numbers;
    }

    private int extractTheNumber(ListNode node) {
        List<Integer> numbers = new ArrayList<>();
        while (node.next !=null) {
            numbers.add(node.val);
            node= node.next;
        }
        numbers.add(node.val);
        System.out.println(numbers);
        return convertToNumber(numbers);

    }
    private int convertToNumber(List<Integer> numbers) {
        int size = numbers.size()-1;
        int endNumber=0;
        for (; size>=0; size--) {
           endNumber += numbers.get(size) * Math.pow(10, size);
        }
        return endNumber;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(6)));
        AddTwoNumbers test = new AddTwoNumbers();
        System.out.println(test.extractTheNumber(l1));
        System.out.println(test.revertNumberAndPutItinList(6589741));

        Stack<Integer> sayilar = new Stack<>();
        sayilar.push(1);
        sayilar.push(2);
        sayilar.push(3);
        while (!sayilar.isEmpty()) {
            System.out.println(sayilar.pop());
        }

    }
}




 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }