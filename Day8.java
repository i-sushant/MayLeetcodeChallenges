class Solution {
    public boolean checkStraightLine(int[][] coord) {
        if(coord.length == 0){
            return false;
        }
        
        double x1 = coord[0][0];
        double y1 = coord[0][1];
        
        Double slope = null;
        for(int i = 1; i<coord.length;i++){
            double x2 = coord[i][0];
            double y2 = coord[i][1];
            
            if(x1-x2 == 0){
                return false;
            }
            if(slope == null){
                slope = (y2-y1)/(x2-x1);
                continue;
            }
            double slope2 = (y2-y1)/(x2-x1);
            if(slope != slope2){
                return false;
            }
        }
        return true;
    } 
}
