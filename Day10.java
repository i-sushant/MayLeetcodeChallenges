class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N == 1){
            return N;
        }
        Map<Integer,Integer> freq = new HashMap<>();
        Map<Integer, Integer> tmap = new HashMap<>();
        int m = trust.length;
        for(int i = 0; i<m;i++){
            int a = trust[i][0];
            int b = trust[i][1]; 
            if(!freq.containsKey(b)){
                freq.put(b,1);
            } else {
                freq.put(b, freq.get(b) + 1);
            }
        }
        
        Set<Map.Entry<Integer,Integer>> entries = freq.entrySet();
        int maxFreq = N-1;
        int count = 0;
        int judge = 0;
        for(Map.Entry<Integer,Integer> entry : entries){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == maxFreq){
                judge = key;
                count++;
            }
        }
        boolean flag = true;
        for(int i = 0; i<m;i++){
            if(trust[i][0] == judge){
                flag = false;
            }
        }
        if(count == 1 && judge > 0 && flag){
            return judge;
        }
        return -1;
    }
}