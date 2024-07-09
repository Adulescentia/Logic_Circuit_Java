public class RotateArray {
    public static Parts[][] rotate90(Parts[][] arr, int xCoordinate, int yCoordinate) {
        int n = xCoordinate;
        int m = yCoordinate;
        int num = 1;


        Parts[][] arr2 = new Parts[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr2[i][j] = arr[j][m - 1 - i]; // ##핵심 코드##
            }
        }
        return arr2;
    }
}
