
package ru.spbstu.telematics.java;

public class snakeAdding {
    public static int[][] snakeadd (int size){
        int [][] snakeArray = new int[size][size];
        int value = 1;
        for (int i = 0; i < size; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < size; j++) {
                    snakeArray[i][j] = value++;
                }
            }else {
                for (int j = size - 1; j >= 0; j--) {
                    snakeArray[i][j] = value++;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(snakeArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        return snakeArray;
    }
}
