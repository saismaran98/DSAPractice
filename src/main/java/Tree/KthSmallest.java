package Tree;

import java.util.Stack;

public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        //using iterative dfs
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while( !stack.isEmpty() || cur!=null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
                //get to leaf node.
            }
            cur = stack.pop();
            k--;
            if(k==0)
                return cur.val;

            cur = cur.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Create a binary search tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        /*
                            5
                           / \
                          3   6
                         / \
                        2   4
                       /
                      1
       * */

        // Test kthSmallest for different k values
        int k1 = 4; // Find the 3rd smallest element
        System.out.println("The " + k1 + "rd smallest element is: " + kthSmallest(root, k1));

        int k2 = 1; // Find the smallest element
        System.out.println("The " + k2 + "st smallest element is: " + kthSmallest(root, k2));

        int k3 = 5; // Find the 5th smallest element
        System.out.println("The " + k3 + "th smallest element is: " + kthSmallest(root, k3));

        int k4 = 6; // Find the 6th smallest element (last in this BST)
        System.out.println("The " + k4 + "th smallest element is: " + kthSmallest(root, k4));
    }
}

