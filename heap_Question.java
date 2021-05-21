public class heap_Question {

    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        int n=matrix.length;
        int m=matrix[0].length;
        
        for(int i=0;i<matrix.length;i++){
            pq.add(new int[]{matrix[i][0],i,0});
        }
        
        while(k-->1){
            int[] rem = pq.remove();
            int r = rem[1];
            int c = rem[2];
            if(c+1<m) pq.add(new int[]{matrix[r][c+1],r,c+1});
        }
        return pq.remove()[0];
    }

    //Grouping Values
    static int isPossible(int N, int arr[], int K)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        for(int key:map.keySet()){
            if(map.get(key)>2*K){
                return 0;
            }
        }
        return 1;
    }

    
}


