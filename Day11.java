class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor){
            return image;
        }
        fillColor(image, image[sr][sc], newColor,sr,sc);
        return image;
    }
    
    public void fillColor(int[][] image, int color , int newColor, int i , int j){
        if(i >= image.length || i < 0 || j >= image[i].length || j < 0 || image[i][j] != color){
            return;
        }
        image[i][j] = newColor;
        fillColor(image, color, newColor, i,j+1);
        fillColor(image, color, newColor, i,j-1);
        fillColor(image, color, newColor, i+1,j);
        fillColor(image, color, newColor, i-1,j);
        
    }
}