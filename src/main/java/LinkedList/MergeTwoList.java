package LinkedList;
class MyNode {
    int val;
    MyNode next;
    MyNode() {}
    MyNode(int val) { this.val = val; }
    MyNode(int val, MyNode next) { this.val = val; this.next = next; }
}
public class MergeTwoList {
    public static MyNode mergeTwoLists(MyNode l1, MyNode l2) {
        MyNode dummyNode = new MyNode();
        MyNode tail = new MyNode();
        tail = dummyNode; // all tail.next = dummyNode -> tail -> tail.next ... hence dummyNode.next = head.
        while(l1 != null && l2!= null){ // loop whiel both have some element in it.
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) // l1 len is more than l2 or item still remaining in l1.
            tail.next = l1;
        else if (l2!=null)
            tail.next = l2;

        return dummyNode.next; // first head where i started my tail.
    }
    public static void main(String[] args) {
        // Create test lists
        MyNode list1 = new MyNode(1);
        list1.next = new MyNode(2);
        list1.next.next = new MyNode(4);

        MyNode list2 = new MyNode(1);
        list2.next = new MyNode(3);
        list2.next.next = new MyNode(4);



        MyNode result = MergeTwoList.mergeTwoLists(list1, list2);

        // Print result
        while(result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
