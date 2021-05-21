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

    // rabbit in forest
    public int numRabbits(int[] answers) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:answers){
            if(!map.containsKey(ele)){ 
                map.put(ele,1);
                count+=ele+1;
            }
            else map.put(ele,map.get(ele)+1);
            if(map.get(ele)==ele+1) map.remove(ele);
            
        }
        return count;
    }

    // gfg a+b=c+d
    public int findPairs(int arr[],int n) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=arr[i]+arr[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
                if(map.get(sum)==2) return 1;
            }
        }
        return 0;
    }

    // incomplete Array
    int countElements(int N, int A[]) {
        // code here
        if(N==1) return 0;
        int min=(int)1e8;
        int max=-(int)1e8;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:A){
            map.put(ele,map.getOrDefault(ele,0)+1);
            if(min>ele) min=ele;
            if(max<ele) max=ele;
        }
        return (max-min-1)-(map.size()-2);
    }

    // kth largest in stream
    
}


