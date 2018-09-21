/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
* @autor Guozhu Zhu
* @date 2018
* @version 1.0
*
*/
class Solution {
    
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        for (Node node : root.children) {
            res = Math.max(res, maxDepth(node)+1);
        }
        return res;
    }
    
}
