/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
      if(root==null){
            return new ArrayList();
        }
        List<List<Integer>> resList=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        int cur = 1;
        int next = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
                TreeNode tempNode=queue.poll();
                list.add(tempNode.val); 
                cur--;
                if(tempNode.left!=null){
                    queue.offer(tempNode.left);
                    next++;
                }
                if(tempNode.right!=null){
                    queue.offer(tempNode.right);
                    next++;
                }   
                if (cur == 0) {
                    cur = next;
                    next = 0;
                    resList.add(list);
                    list = new ArrayList<Integer>();
                }     
        }
        return resList;  

    }

}