package Tree;

public class BST {
    public boolean search(TreeNode root, int target){
        if(root == null)
            return false; // bst does not have any element.

        if(root.val < target) // cur val < target, look right for value greater than cur.
            return search(root.right, target);

        else if(root.val > target) // cur val > target, look left for smaller element.
            return search(root.left, target);

        else
            return true; //found the element.
    }




    // Helper method to insert a node into the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null)
            return null; // cannot delete from empty tree.

        if(val > root.val) // search in right subtree
            root.right = deleteNode(root.right, val);
        else if(val < root.val) // search in left subTree.
            root.left = deleteNode(root.left, val);
        else{
            // if cur node has 0 or 1 child node
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            // else cur node has 2 child, mind right min and replace with cur.
            else {
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val; // find min right subTree node to swap.
                root.right = deleteNode(root.right, minNode.val); //delete duplicate minNode from leaf
            }
        }
        return root; // after deleting the node. return root of new tree.
    }
    public TreeNode minValueNode(TreeNode root){
        TreeNode cur = root;
        while(cur!=null && cur.left !=null){
            cur = cur.left;
        }
        return cur;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode root = null;

        // Insert data into the BST
        int[] values = {10, 5, 15, 3, 7, 12, 18};
        for (int val : values) {
            root = bst.insert(root, val);
        }

        // Search for elements in the BST
        int target1 = 7;
        int target2 = 20;

        System.out.println("Is " + target1 + " present in the BST? " + bst.search(root, target1));
        System.out.println("deleting node"+target1);
        bst.deleteNode(root, 7);
        System.out.println("Is " + target1 + " present in the BST? " + bst.search(root, target2));
    }
}
