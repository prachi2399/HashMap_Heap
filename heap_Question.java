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
}

