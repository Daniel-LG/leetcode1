package leetcode236;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Result{
    public TreeNode node;
    public boolean isAncestor;
    public Result(TreeNode node, boolean isAncestor){
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestor(root, p, q);
        if (r.isAncestor)
            return r.node;
        return null;
    }
    private Result commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return new Result(null, false);
        if (root ==p && root == q)
            return new Result(root, true);
        Result left = commonAncestor(root.left, p, q);
        if (left.node != null && left.isAncestor)
            return left;
        Result right = commonAncestor(root.right, p, q);
        if (right.node != null && right.isAncestor)
            return right;
        if (left.node != null && right.node != null)
            return new Result(root, true);
        if (root == p || root == q){
            boolean isAnc = left.node != null || right.node != null ? true : false;
            return new Result(root, isAnc);
        }
        return new Result(left.node != null ? left.node : right.node, false);
    }
    public static void main(String[] args) {
		LowestCommonAncestor l = new LowestCommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		l.lowestCommonAncestor(root, root, root.left);
	}
}
