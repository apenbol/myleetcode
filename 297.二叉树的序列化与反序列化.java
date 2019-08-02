import java.util.Queue;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        dfs(root,res);
        return res.toString();
    }
    public void dfs(TreeNode root,StringBuffer str){
        if(root==null){
            str.append("# ");
            return;
        }
        str.append(root.val+" ");
        dfs(root.left,str);
        dfs(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] dataArray = data.split("\\s");//注意这  以及不管最后一个字符放不放空格 所得数组大小一样
        return dfs2(new LinkedList(Arrays.asList(dataArray)));
    }
    public TreeNode dfs2(Queue<String> data){
        if(data.peek().equals("#")){
            data.poll();
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(data.poll()));
        cur.left = dfs2(data);
        cur.right=dfs2(data);
        return cur;
    };
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

