package LinkedList;

import java.util.LinkedList;

public class ReverseALinkedList {
    public static ListNode reverseList(ListNode head) {
       ListNode prev = null;
       ListNode cur = head;

       while ( cur !=null){
           ListNode nextTemp = cur.next; // next node
           cur.next = prev;
           prev = cur;
           cur = nextTemp;

       }
       return  prev;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");  // End of the list
    }
    public static void main(String[] args) {
        // Create a sample linked list: 0 -> 1 -> 2 -> 3 -> null
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        // Print the original linked list
        System.out.print("Original List: ");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Print the reversed linked list
        System.out.print("Reversed List: ");
        printList(reversedHead);
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

}
