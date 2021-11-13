package com.training.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> tempList = new ArrayList<>();
        ListNode lnode = new ListNode();
        putTheValuesIntoList(tempList, l1);
        putTheValuesIntoList(tempList, l2);
        Collections.sort(tempList);
        ListNode temp;
        for (int i = 0; i < tempList.size(); i++) {
            if (i == 0) {
                lnode.val = tempList.get(i);
                continue;
            }
            if (i == 1) {
                lnode.next = new ListNode(tempList.get(i));
                continue;
            }
            temp = lnode;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(tempList.get(i));
        }
        return lnode;
    }

    private void putTheValuesIntoList(List<Integer> list, ListNode ln) {
        if (ln != null && ln.next != null) {
            list.add(ln.val);
            while (ln.next != null) {
                ln = ln.next;
                list.add(ln.val);
            }
        }
    }

    public static void main(String[] args) {

        MergeTwoSortedList test = new MergeTwoSortedList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(7, new ListNode(9)))));
        ListNode l2 = new ListNode(3, new ListNode(4, new ListNode(6)));

       ListNode res = test.mergeTwoLists2(l1, l2);
       while (res != null) {
           System.out.println(res.val);
           res = res.next;
       }

    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}