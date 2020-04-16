class Solution {
    
    public void doCompleteRotation(int[][] matrix, int start_x, int start_y){
        int length = matrix.length - 1;
        int firstValue = matrix[start_y][start_x];
        int secondValue = matrix[start_x][length - start_y];
        int thirdValue = matrix[length - start_y][length-start_x];
        int fourthValue = matrix[length - start_x][start_y];
        
        int tempVariable = secondValue;
        int tempVariable2 = thirdValue;
        int tempVariable3 = fourthValue;
        
        matrix[start_x][length - start_y] = firstValue;
        matrix[length - start_y][length-start_x] = tempVariable;
        matrix[length - start_x][start_y] = tempVariable2;
        matrix[start_y][start_x] = tempVariable3;
    }
    
    public void rotate(int[][] matrix) {
        int numberOfLayers = (int)Math.floor(matrix.length / 2);
        int numberRotations = matrix.length%2==0 || matrix.length==2?numberOfLayers:numberOfLayers+1;
        for(int layer=0; layer<numberOfLayers; layer++){
            for(int x=0; x<numberRotations; x++) {
                doCompleteRotation(matrix, x, layer);
            }
        }
    }
    
}
