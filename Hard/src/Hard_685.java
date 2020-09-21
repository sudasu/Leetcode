public class Hard_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nums = edges.length;
        int cycleFlag = -1;
        int conflictFlag = -1;
        Union union = new Union(nums);
        int[] parent = new int[nums+1];
        for(int i=1; i<nums+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<nums; i++){
            int[] tempEdge = edges[i];
            if(parent[tempEdge[1]]!=tempEdge[1]){
                conflictFlag = i;
                continue;
            }
            
            if(union.findAncestor(tempEdge[0])==union.findAncestor(tempEdge[1])){
                cycleFlag = i;
            }else{
                union.Union(tempEdge[0], tempEdge[1]);
            }
            parent[tempEdge[1]] = tempEdge[0];
        }

        if(conflictFlag<0){
            return new int[]{edges[cycleFlag][0], edges[cycleFlag][1]};
        }else{
            if(cycleFlag<0){
                return new int[]{edges[conflictFlag][0], edges[conflictFlag][1]};
            }else{
                return new int[]{parent[edges[conflictFlag][1]], edges[conflictFlag][1]};
            }
        }
    }

}
class Union{
    int[] ancestor;

    public Union(int n){
        ancestor = new int[n+1];
        for(int i=1; i<n+1; i++){
            ancestor[i] = i;
        }
    }

    public void Union(int a, int b){
        ancestor[findAncestor(b)] = findAncestor(a);
    }

    public int findAncestor(int n){
        if(ancestor[n] != n)
            ancestor[n] = findAncestor(ancestor[n]);
        return ancestor[n];
    } 
}