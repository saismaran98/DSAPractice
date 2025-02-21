package LinkedList;


public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while(l1 != null || l2!= null || carry!=0){
            int value1 = l1 !=null ? l1.val : 0;
            int value2 = l2 !=null ? l2.val : 0;

            // new digit
            int val = value1 + value2 + carry;

            carry = val/10;
            val = val % 10;

            cur.next = new ListNode(val);

            //update ptrs.
            cur = cur.next;
            l1 = l1 !=null ? l1.next : null;
            l2 = l2 !=null ? l2.next : null;

        }
        return dummy.next;
    }
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Test Case 1: 342 + 465 = 807
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = createLinkedList(arr1);
        ListNode l2 = createLinkedList(arr2);

        System.out.println("Test Case 1:");
        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);
        System.out.print("Result: ");
        printList(addTwoNumbers(l1, l2));

        // Test Case 2: 0 + 0 = 0
        System.out.println("\nTest Case 2:");
        l1 = createLinkedList(new int[]{0});
        l2 = createLinkedList(new int[]{0});
        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);
        System.out.print("Result: ");
        printList(addTwoNumbers(l1, l2));

        // Test Case 3: 9999999 + 9999 = 10009998
        System.out.println("\nTest Case 3:");
        l1 = createLinkedList(new int[]{9,9,9,9,9,9,9});
        l2 = createLinkedList(new int[]{9,9,9,9});
        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);
        System.out.print("Result: ");
        printList(addTwoNumbers(l1, l2));
    }
}
