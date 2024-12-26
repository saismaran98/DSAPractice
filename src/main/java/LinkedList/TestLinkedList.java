package LinkedList;


import java.util.ArrayList;


public class TestLinkedList {
        MyNode head; //  pointing to null equivalent.
        MyNode tail;
        public TestLinkedList() {
            // dummy node.
           // head = new ListNode(-1);
            //tail = head; // initially head and tail both point to null. head, tail -> null
        }

        public int get(int index) {
            MyNode curr = head.next;
            int i = 0;
            while (curr != null) {
                if (i == index) {
                    return curr.val;
                }
                i++;
                curr = curr.next;
            }
            return -1;  // Index out of bounds or list is empty
        }

    public void insertHead(int val) {
        MyNode newNode = new MyNode(val);
            if(this.head == null) {
                this.head = newNode;
                this.head.next = null;
                this.tail = head;
            }else {
                newNode.next = head;
                head = newNode;
            }


    }

        public void insertTail(int val) {
            this.tail.next=new MyNode(val);
            this.tail = this.tail.next;
        }

    public boolean remove(int index) {
        int i = 0;
            MyNode cur = this.head;
        while(i < index-1 && cur != null)
        {
            i++;
            cur = cur.next;
        }
        if(cur!=null && cur.next != null) {
            cur.next = cur.next.next;

            return true;
        }

        return false;

    }

        public ArrayList<Integer> getValues() {
            ArrayList<Integer> res = new ArrayList<>();
            MyNode cur= this.head;
            while(cur!=null){
                res.add(cur.val);
                cur = cur.next;
            }
            return res;
        }

    public static void main(String[] args) {
        TestLinkedList tes = new TestLinkedList();
        tes.insertHead(1); // [1]
        tes.insertTail(2); // 1->2
        tes.insertHead(0); // 0 -> 1 ->2
        tes.remove(1); // 0 -> 2
        System.out.println("after operations: " + tes.getValues());;
    }
    }


