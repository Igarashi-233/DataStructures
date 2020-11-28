package com.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0: 表示没有棋子     1: 表示黑子     2: 表示蓝子

        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        //输出原始数组
        System.out.println("原始二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //二维数组 转 稀疏数组 的思想
        //遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        //创建对应稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组  将非0值存放到稀疏数组
        int count = 0;// 用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~~~~~~~~");

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组 转 原始二维数组
        /*
            1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
            2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         */
        int[][] NewchessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        System.out.println(sparseArr.length);

        for (int i = 1; i < sparseArr.length; i++) {
            NewchessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //恢复后的二维数组
        for (int[] row : NewchessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
