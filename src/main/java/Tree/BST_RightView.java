package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST_RightView {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int depth){
        if(node == null)
            return;

        if(res.size() == depth){
            res.add(node.val);
        }
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
    private List<Integer> bfs(TreeNode root){
        //travel the root store res in res list.
        res.clear();
        // queue to keep track of cur node and its children
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode rightMost =null;
            int qLen = q.size();
            for(int i = 0; i<qLen;i++){
               TreeNode cur = q.poll();
                if(cur != null) {
                    rightMost = cur;
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
            if(rightMost!=null)
                res.add(rightMost.val);

        }
        return res;

    }

    public static void main(String[] args) {
        // Test case 1z: root = [1, 2, 3]
        BST_RightView ob = new BST_RightView();
       /* TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Right view of tree 1: " + ob.rightSideView(root1));*/

        // Test case 2: root = [1, 2, 3, 4, 5, 6, 7]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

      //  System.out.println("Right view of tree 2: " + ob.rightSideView(root2));
        System.out.println("bfs view : "+ob.bfs(root2));

    }

}
