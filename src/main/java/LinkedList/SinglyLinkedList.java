package LinkedList;

import java.util.ArrayList;

class ListNode {
    int val;
    MyNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class SinglyLinkedList {
    MyNode head; //  pointing to null equivalent.
    MyNode tail;
    public SinglyLinkedList(){
        head = new MyNode(-1);
        tail = head; // initially head and tail both point to null. head, tail -> null
    }
    public void insertEnd(int val){
        // insert val in the end of the linked list.
        tail.next=new MyNode(val);
        tail = tail.next;
    }
    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        MyNode cur= head;
        if(cur!=null && cur.next!=null){
            res.add(cur.val);
        }
        res.add(cur.val);
        return res;
    }
    public void insertHead(int val) {
        MyNode cur = new MyNode(val);
        if(head!=null){
            head = cur;
            head.next = head;
        }
    }
    public void insertInIthIndex(int i){
        MyNode newNode = new MyNode(5);
        MyNode cur = head;
        int counter = 0;
        while(head!=tail && counter++ < i){
            cur = cur.next;
        }
        // insert at ith.
        newNode.next = cur.next.next;
        cur.next = newNode;
        print();

    }
    public int get(int index) {
        int curIndex = 0;
        MyNode curr = head.next;
        // traverse to ith index given
        while(curIndex < index && curr != null){
            curr = curr.next;
            curIndex++;
        }
        if (curr == null) {
           return -1;
        }
        return curr.val;
    }
    public void remove(int index){
        int curIndex = 0;
        MyNode curr = head;
        // traverse to ith index given
        while(curIndex < index && curr != null){
            curr = curr.next;
            curIndex++;
        }
        //remove the
        if(curr != null && curr.next != null)
            curr.next = curr.next.next;

    }
    public void print() {
        MyNode curr = head.next; // as default head value is -1,
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println();
    }

        public static void main(String[] args) {
            // Create a new SinglyLinkedList instance
            SinglyLinkedList linkedList = new SinglyLinkedList();

            // Insert elements at the end
            linkedList.insertEnd(10); // index: 0
            linkedList.insertEnd(20); // index: 1
            linkedList.insertEnd(30); // index: 2
            linkedList.insertEnd(40); // index: 3
            linkedList.insertInIthIndex(2); // insert at 2nd index.
            System.out.println("item at index 4 : "+linkedList.get(4));
            // Print the list
            System.out.println("Initial List:");
            linkedList.print();

            // Remove element at index 2 (value 30)
            System.out.println("Removing element at index 2 ( 30 ):");
            linkedList.remove(2);
            linkedList.print();

            // Remove element at index 0 (value 10)
            System.out.println("Removing element at index 0 (10) :");
            linkedList.remove(0);
            linkedList.print();

            // Insert another element
            System.out.println("Inserting 50 at the end:");
            linkedList.insertEnd(50);
            linkedList.print();

            // Try removing an element at an out-of-bounds index
            System.out.println("Attempting to remove element at index 5 (out of bounds):");
            linkedList.remove(5);
            linkedList.print();

    }
}

