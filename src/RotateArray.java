public class RotateArray {
    public static Parts[][] rotate90(Parts[][] arr){
        int row = arr.length, col = arr[0].length;
        Parts[][] rotatedArr = new Parts[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                rotatedArr[i][j] = arr[(row-1)-j][i];
            }
        }
        return rotatedArr;
    }
}
