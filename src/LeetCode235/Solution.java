package LeetCode235;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t=root;
        List<Integer> ancestorsOfP=new ArrayList<Integer>();
        List<Integer> ancestorsOfQ=new ArrayList<Integer>();
        while(t!=null){
        	ancestorsOfP.add(t.val);
            if(p.val<t.val)
            	t=t.left;     
            else if(p.val>t.val)
            	t=t.right;
                else
                    break;
        }
        t=root;
        while(t!=null){
        	ancestorsOfQ.add(t.val);
            if(q.val<t.val)
                t=t.left;
            else if(q.val>t.val)
                t=t.right;
                else
                    break;           
        }
        for(int i=ancestorsOfP.size()-1;i>=0;i--){
            int a=(int)ancestorsOfP.get(i);
            if(ancestorsOfQ.contains(a))
                return new TreeNode(a);
        }
        return null;
    }
    public static void main(String[] args){
    	TreeNode t1=new TreeNode(2);
    	TreeNode t2=new TreeNode(1);
    	t1.left=t2;
    	Solution s=new Solution();
    	s.lowestCommonAncestor(t1,t1,t2);
    }
}