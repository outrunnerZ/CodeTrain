package Test.ArrayandString;

public class Day20190105 {
    // 因为java只有值传递（没有引用传递）,所以使用swap之后数值没有变化
    public static void rotate(int[][] matrix){
        if(matrix==null || matrix.length ==1){
            return;
        }
        int length = matrix.length;
        int temp; //For swap
        for(int i=0; i<length/2; i++){
            for(int j=0;j<length;j++){
//                swap(matrix[i][j], matrix[length-1-i][j]);
                temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-1-i][j]=temp;
            }

        }
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
//                swap(matrix[i][j],matrix[j][i]);
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void swap(int a, int b){
        int s;
        s = a;
        a = b;
        b = s;
    }

    public static void main(String[] strings){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix.length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
