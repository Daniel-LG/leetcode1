package leetCode216CombinationSum3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> oneCombination=new ArrayList<Integer>();
        if(k==0||n==0)
            return res;
        if(k==1){
        	if(n<=9){
        		oneCombination.add(n);
                res.add(oneCombination);
        	}
            return res;
        }
        int biggest=n/k;
        for(int i=1;i<=biggest;i++){
            List<List<Integer>> last=combinationSum3(k-1,n-i);
            for(List<Integer> li:last){
                if(li.get(0)<=i)
                    continue;
                oneCombination.add(i);
                oneCombination.addAll(li);
                List<Integer> tmp=new ArrayList<Integer>(oneCombination);
                res.add(tmp);
                oneCombination.clear();
            }
        }
        return res;
    }
	public static void main(String[] args) {
		List<List<Integer>> ans=new CombinationSum3().combinationSum3(3, 15);
		for(List li:ans){
			System.out.println(li);
		}
	}
}

