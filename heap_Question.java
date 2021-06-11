public class heap_Question {

    // four sum
    public List<List<Integer>> fourSum(int[] arr, int target) {
          Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            while(i!=0&&i<n&&arr[i]==arr[i-1]) i++;
            for(int l=i+1;l<n;l++){
            while(l>i+1 &&l<n&&arr[l]==arr[l-1]) l++;    
            int j=l+1,k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k]+arr[l];
                if(sum==target){
                    list.add(Arrays.asList(arr[i],arr[l],arr[j],arr[k]));
                    
                    j++; k--;
                    while(j<k&&arr[j]==arr[j-1]) j++;
                    while(j<k&&arr[k]==arr[k+1]) k--;
                }
                else if(sum<target) j++;
                else k--;
             }
          }
        }
        return list;
    }

    // 4 sum -ii
    public int fourSumCount(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int i=0,j=B.length-1;
        int ans=0;
        while(i<A.length&&j>=0){
            int sum = A[i]+B[j];
            if(sum<0){
                i++;
            }else if(sum>0){
                j--;
            }else{
                int countA=1,countB=1;
                while(++i<A.length&&A[i]==A[i-1]) countA++;
                while(--j>=0&&B[j]==B[j+1]) countB++;
                ans+=countA*countB;
                
            }
        }
        return ans;
        
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int[] AB=new int[n*n];
        int[] CD = new int[n*n];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                AB[k]=A[i]+B[j];
                CD[k]=C[i]+D[j];
                k++;
            }
        }
        return fourSumCount(AB,CD);
    }
    //
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
    
    //exceptional odd number
    int getOddOccurrence(int[] arr, int n) {
       
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int res=0;
        for(int key:map.keySet()){
            if(map.get(key)%2!=0) {
                res=key;
                return res;
            }
        }
        return res;
    }

    //most frequent ele
    String solve(String s) 
    { 
        HashMap<Integer,Integer> map = new HashMap<>();
        int res=0;
        int maxCount=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i)-'0',map.getOrDefault(s.charAt(i)-'0',0)+1);
        }
        for(int ch:map.keySet()){
            if(map.get(ch)>=maxCount){
                res=ch;
                maxCount=map.get(ch);
            }
        }
        
        StringBuilder sb =  new StringBuilder();
        sb.append(res);
        return new String(sb);
    }
    //distinct elements 
    static int distinct(int M[][], int N)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res=0;
        int maxCount=0;
        for(int i=0;i<N;i++){
            map.put(M[0][i],1);
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                if(map.get(M[i][j])!=null&&map.get(M[i][j])==i){
                    map.put(M[i][j],i+1);
                }
                
            }
        }
        int count=0;
        for(int key:map.keySet()){
            if(map.get(key)==N) count++;
        }
        return count;
    }
    //pair with given relation
    ong findPairs(long a[],int n)
    {
         HashMap<Long,Integer> map = new HashMap<>();
         
         int count=-1;
         for(int i=0;i<n-1;i++){
             for(int j=i+1;j<n;j++){
                long product=a[i]*a[j];
                if(map.containsKey(product)) return 1;
                map.put(product,map.getOrDefault(product,0)+1);
                //return 1;
            }
        }
         
       // leetcode 1002 find common char
       public List<String> commonChars(String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<words[0].length();i++){
            char ch = words[0].charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> temp;
        for(int i=1;i<words.length;i++){
            temp = new HashMap<>();
            for(int j=0;j<words[i].length();j++){
                char ch = words[i].charAt(j);
                temp.put(ch,temp.getOrDefault(ch,0)+1);
            }
            
            for(char ch:map.keySet()){
                if(!temp.containsKey(ch)){
                    map.put(ch,0);
                }
                if(temp.containsKey(ch)){
                    int minCount=Math.min(map.get(ch),temp.get(ch));
                    map.put(ch,minCount);
                }
            }
        }
        
        List<String> str = new ArrayList<>();
        for(char ch : map.keySet()){
            int count=map.get(ch);
            while(count-->0){
                String s = new String(ch+"");
                str.add(s);
            }
            System.out.println(ch+"->"+map.get(ch));
        }
        return str;
    }

    // find pair with givem sum
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here 
        HashMap<Long,Integer> map = new HashMap<>();
        for(long ele:A){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int count=0;
        for(long ele:B){
            if(map.containsKey(X-ele)){
                count++;
            }
        }
        pair[] res = new pair[count];
        int i=0;
        for(long ele:B){
            if(map.containsKey(X-ele)){
                res[i++]=new pair(X-ele,ele);
            }
        }
        Arrays.sort(res,(a,b)->{
            return (int)a.first-(int)b.second;
        });
        return res;
    }

    //find the differnce
    public char findTheDifference(String s, String t) {
        char S[] = s.toCharArray();
        Arrays.sort(S);
        
        char T[] = t.toCharArray();
        Arrays.sort(T);
        
        int i=0,j=0;
        while(j<t.length()&&i<s.length()){
            if(S[i]!=T[i]) return T[i];
            i++;j++;
        }
        if (j==t.length()-1)
            return T[T.length-1];
        return '0';
    }

    // first come first serve
    static int firstElement(int arr[], int n, int k) { 
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        for(int ele:arr){
            if(map.get(ele)==k) return ele;
        }
        return -1;
    }

    // first unique char
    public int firstUniqChar(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
    
        for(int i=0;i<s.length();i++){
             char ele = s.charAt(i);
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(int i=0;i<s.length();i++){
             char ele = s.charAt(i);
            if(map.get(ele)==1) return i;
        }
        
        return -1;
    }

    // intersection of 2 array
    public int[] intersection(int[] nums1, int[] nums2) {
        int count=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> temp = new HashMap<>();
        for(int ele:nums1){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(int ele:nums2){
            temp.put(ele,temp.getOrDefault(ele,0)+1);
            
        }
    
        ArrayList<Integer> res = new ArrayList<>();
        for(int ele:map.keySet()){
            if(temp.containsKey(ele)) res.add(ele);
        }
        int[] arr = res.stream().mapToInt(i -> i).toArray();
        return arr;
    }
    // alt
    public int[] intersection(int[] nums1, int[] nums2) {
        int count=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:nums1){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int ele:nums2){
            if(map.containsKey(ele)&&!res.contains(ele)) res.add(ele);
        }
        int[] arr = res.stream().mapToInt(i -> i).toArray();
        return arr;
    }
    //stones and jewels
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> map = new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            map.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            char ch = stones.charAt(i);
            if(map.contains(ch)) count++;
        }
        return count;
    }
    //kth largest
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return a-b;
        });
        
        for(int ele: nums){
            pq.add(ele);
            while(pq.size()>k) pq.remove();
        }
        return pq.peek();
    }

    // kth closest point to origin
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int r1 =(a[0]*a[0]+a[1]*a[1]);
            int r2 = (b[0]*b[0]+b[1]*b[1]);
        return r2 - r1;   
        });
        
        for(int[] ele: points){
            pq.add(new int[]{ele[0],ele[1]});
            while(pq.size()>k) pq.remove();
        }
        int[][] res = new int[k][2];
        int i=0;
        while(pq.size()!=0){
            int[] rem=pq.remove();
            res[i][0]=rem[0];
            res[i][1]=rem[1];
            i++;
        }
        return res;
    }
    // keyborad row
    public String[] findWords(String[] words) {
        String row_1="qwertyuiop";
        String row_2="asdfghjkl";
        String row_3="zxcvbnm";
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<row_1.length();i++){
            map.put(row_1.charAt(i),1);
        }
        for(int i=0;i<row_2.length();i++){
            map.put(row_2.charAt(i),2);
        }
        for(int i=0;i<row_3.length();i++){
            map.put(row_3.charAt(i),3);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            HashSet<Integer> set = new HashSet<>();
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                if(map.containsKey(ch)) set.add(map.get(ch));
            }
            if(set.size()==1) ans.add(s);
        }
        String[] an=new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            an[i]=ans.get(i);
        }
        return an;
    }
    //height of heap
    static int heapHeight(int N, int arr[]){
         Double a = Math.log(N+1) / Math.log(2);
         int b = (int)Math.ceil(a)-1;
        
        return b;
    }

    // uncommon words in 2 sentences 
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();
        
        String[] s = s1.split(" ");
        String[] t = s2.split(" ");
        
        int count=0;
        for(String ele:s){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(String ele:t){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        
        List<String> ans = new LinkedList();
        int i=0;
        for(String e:map.keySet()){
            if(map.get(e)==1) ans.add(e);
        }        
        return ans.toArray(new String[ans.size()]);
    }
    // union
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        HashSet<Integer> set = new HashSet<>();
        for(int ele:a){
            if(!set.contains(ele)) set.add(ele);
        }
        for(int ele:b){
            if(!set.contains(ele)) set.add(ele);
        }
        return set.size();
    }

    // Anagram
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        int i=0,j=0;
        boolean res=true;
        while(i<s.length()&&j<t.length()){
            if(S[i]!=T[j]){
                res=false;
                return res;
            }
            i++;
            j++;
        }
        return res;
    }

    // intersection of aray
    public int[] intersect(int[] S, int[] T) {
        Arrays.sort(S);
        Arrays.sort(T);
        int i=0,j=0;
        List<Integer> res = new ArrayList<>();
        while(i<S.length&&j<T.length){
            if(S[i]==T[j]){
                System.out.print(S[i]+" ");
                res.add(S[i]);
                i++;
                j++;
            }
            else if(S[i]<T[j]) i++;
            else j++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    //findMissing
    ArrayList<Long> findMissing(long A[], long B[], int N, int M)
    {
        HashSet<Long> set = new HashSet<>();
        for(long ele:B){
            if(!set.contains(ele)) set.add(ele);
        }
        ArrayList<Long> res = new ArrayList<>();
        for(long ele:A){
            if(!set.contains(ele)) res.add(ele);
        }
        return res;
    }

    // max num char diff
    public int maxChars(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxDiff=-1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) maxDiff=Math.max(maxDiff,i-map.get(s.charAt(i))-1);
            else map.put(s.charAt(i),i);
        }
        return maxDiff;
    }
    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int si=0,ei=0,len=0;
        int[] freq = new int[128];
        int count=0;
        while(ei<s.length()){
            if(freq[s.charAt(ei++)]++>0)   count++;
            while(count>0){
                if(freq[s.charAt(si++)]-->1) count--;
            }
            len = Math.max(len,ei-si);
        }
        return len;
    }

    //409. Longest Palindrome
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.get(s.charAt(i))==2){
                len+=2;
                map.put(s.charAt(i),0);
            }
        }
        
        return len==s.length()?len:len+1;
    }

    // Largest subarray with 0 sum 
    int maxLen(int arr[], int n)
    {
        int maxLen=0;
        int currSum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            currSum+=arr[i];
            if(currSum==0){
                maxLen=i+1;
            }
            if(map.containsKey(currSum)){
                maxLen=Math.max(maxLen,i-map.get(currSum));
            }
            if(!map.containsKey(currSum)){
                map.put(currSum,i);
            }

        }
        return maxLen;
    }

    // employees under manager
    import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine());
    String ceo = "";

    HashMap<String, HashSet<String>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] parts = scn.nextLine().split(" ");
      String emp = parts[0];
      String man = parts[1];

      if (man.equals(emp)) {
        ceo = man;
        continue;
      }

      if (map.containsKey(man)) {
        HashSet<String> emps = map.get(man);
        emps.add(emp);
      } else {
        HashSet<String> emps = new HashSet<>();
        emps.add(emp);
        map.put(man, emps);
      }
    }

    HashMap<String, Integer> ans = new HashMap<>();
    size(map, ceo, ans);

    for (String emp : ans.keySet()) {
      System.out.println(emp + " " + ans.get(emp));
    }
  }

  public static int size(
    HashMap<String, HashSet<String>> map,
    String man,
    HashMap<String, Integer> ans
  ) {
    if(map.containsKey(man) == false){
      ans.put(man, 0);
      return 1;
    }

    int sz = 0;
    
    for (String emp : map.get(man)) {
      int cs = size(map, emp, ans);
      sz += cs;
    }
    ans.put(man, sz);
    return sz + 1;
  }
    // longest consecutive subsequence
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int ele:nums) map.add(ele);
        
        int len=0;
        for(int ele:nums){
            if(!map.contains(ele)) continue;
            map.remove(ele);
            int prev=ele-1;
            int next=ele+1;
            while(map.contains(prev)){
                map.remove(prev);
                prev--;
            }
            while(map.contains(next)){
                map.remove(next);
                next++;
            }
            len=Math.max(len,next-prev-1);
        }
        return len;
    }

    //count the characeters
    int getCount (String S, int N)
    {
        int[] freq = new int[26];
        int i=0,j=1;
        freq[S.charAt(i)-'a']++;
        while(j<S.length()){
            if(S.charAt(i)!=S.charAt(j)) freq[S.charAt(j)-'a']++;
            i++;
            j++;
        }
        
        int count=0;
        for(int k=0;k<26;k++){
            if(freq[k]==N) count++;
        }
        return count;
    }
    // group anagram
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> bmap = new HashMap<>();
        
        for(String s:strs){
            HashMap<Character,Integer> fmap = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            if(bmap.containsKey(fmap)==false){
                List<String> ans = new ArrayList<String>();
                ans.add(s);
                bmap.put(fmap,ans);
            }else{
                List<String> ans = bmap.get(fmap);
                ans.add(s);
            }   
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> val:bmap.values()){
            res.add(val);
        }
        return res;
    }
}


                        
            
}



