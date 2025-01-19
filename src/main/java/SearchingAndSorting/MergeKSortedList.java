package SearchingAndSorting;


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0 || lists ==null)
            return null;
        //given head node for list of linkedlist.
        // use divide and conquer.
        if(lists.length <= 1)
            return lists[0]; // head node for sorting.
        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[lists.length - mid];
        for(int l = 0;l<mid;l++)
            left[l] = lists[l];
        int i = 0;
        for(int r = mid;r < lists.length;r++) {
            right[i++] = lists[r];
        }

        ListNode leftMerged = mergeKLists(left);
        ListNode rightMerged = mergeKLists(right);

        return merge(leftMerged, rightMerged);

    }

    private static ListNode merge(ListNode l, ListNode r) {
        // we got two array with two linked list now merge them in sorted order.
        // merge two linked list in sorted order.

        // create a result linked list with mmerged values.
        ListNode head = new ListNode(); // dummy Head.
        ListNode tail = new ListNode(); // dummy Tail.
        tail = head;


        ListNode cur = new ListNode(-1);
        while(l !=null && r !=null){
            if(l.val < r.val) {
                tail.next = l;
                l = l.next;
            }else{
                tail.next = r;
                r = r.next;
            }
            tail = tail.next; // move tail.
        }
       if(l != null)
           tail.next = l;
       else if(r != null)
           tail.next = r;

       return head.next; // dummyHead.next which is actual head of res.
    }

    public static void main(String[] args) {
        // Test Case 1: [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists1 = new ListNode[3];
        lists1[0] = createLinkedList(new int[]{1,4,5});
        lists1[1] = createLinkedList(new int[]{1,3,4});
        lists1[2] = createLinkedList(new int[]{2,6});

        System.out.println("Test Case 1:");
        System.out.println("Input lists:");
        for (ListNode list : lists1) {
            printList(list);
        }
        ListNode result1 = mergeKLists(lists1);
        System.out.println("Merged list:");
        printList(result1);
        System.out.println();

       /* // Test Case 2: []
        ListNode[] lists2 = new ListNode[0];
        System.out.println("Test Case 2:");
        ListNode result2 = mergeKLists(lists2);
        System.out.println("Merged list:");
        printList(result2);
        System.out.println();*/
    }
    // Helper method to create a linked list from array
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
