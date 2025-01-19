package Tree;

import java.util.ArrayList;
import java.util.List;

public class BST_Inorder {
    public static List<Integer> res; // keep track of the same res obj.
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        return res;
    }

    public static void inorder(TreeNode root){
        // if leaf node encountered return control;
        if(root == null)
            return;
        // traverse the tree till the left dept/lead node or minNode.
        inorder(root.left); // keep going left until you find min value.
        res.add(root.val);// add the min value and return to search right min
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Create the tree:
        //         1
        //          \
        //           2
        //          /
        //         3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Test the inorderTraversal method
        BST_Inorder main = new BST_Inorder();
        List<Integer> result = main.inorderTraversal(root);

        // Print the result
        System.out.println("Inorder Traversal Result: " + result);

        // Test Case 2: Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(8);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(9);

        List<Integer> result2 = main.inorderTraversal(root2);
        System.out.println("Inorder Traversal Result for Test Case 2: " + result2);

    }

}
