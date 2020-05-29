class Solution {
    public boolean canFinish(int numCourses, int[][] pr) {
        ArrayList<Integer>[] aL = new ArrayList[numCourses];
        for(int i = 0; i<numCourses;i++) {
            aL[i] =  new ArrayList();
        }
        for(int[] pre : pr) {
            aL[pre[0]].add(pre[1]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i<numCourses ; i++)
            if(visited[i] == 0 && !dfs(aL,visited,i)) return false;
        return true;
    }
    private boolean dfs(ArrayList<Integer>[] adj, int[] visited, int v) {
        if(visited[v] == 1) return false;
        visited[v] = 1;
        for(int ad : adj[v])
            if(!dfs(adj,visited,ad)) return false;
         visited[v] = 2;
        return true;
    }
}