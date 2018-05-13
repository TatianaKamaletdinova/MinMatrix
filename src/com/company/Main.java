package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    private static int[][] mArray;
    private static int mRow;
    private static int mColumn;
    private static int mMinRowArray[][];
    private static int mMinColumnArray[][];

    public static void main(String[] args) {

        /*
        ввод строк и столбцов
         */
        Scanner sc = new Scanner(System.in);

        /*
        кол-во строк
         */
        mRow = sc.nextInt();


        /*
        кол-во столбцов
         */
        mColumn = sc.nextInt();


        /*
        формирование массива
         */
        mArray = new int[mRow][mColumn];
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mColumn; j++) {
                mArray[i][j] = sc.nextInt();
            }
        }

        MinRow();
        MinColumn();
        CountMin();

    }

    private static void MinRow() {

        int mMinRow = 0;
        mMinRowArray = new int [Main.mRow][mColumn];
        for (int i = 0; i < Main.mRow; i++) {
            for (int min = 0; min < Main.mRow; min++) {
                mMinRow = mArray[min][0];
                for (int j = 0; j < mColumn; j++) {
                    if (mMinRow >= mArray[i][j]) {
                        mMinRow = mArray[i][j];
                    }
                }
            }
            for (int j = 0; j < mColumn; j++) {
                if (mMinRow >= mArray[i][j]) {
                    mMinRow = mArray[i][j];
                    mMinRowArray[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(mMinRowArray));

    }


    private static void MinColumn() {

        int mMinColumn = 0;
        mMinColumnArray = new int[Main.mRow][mColumn];
        for (int min = 0; min < mColumn; min++) {
            mMinColumn = mArray[0][min];
            for (int j = 0; j < Main.mRow; j++) {
                if (mMinColumn >= mArray[j][min]) {
                    mMinColumn = mArray[j][min];
                }
            }
            for (int j = 0; j < Main.mRow; j++) {
                if (mMinColumn >= mArray[j][min]) {
                    mMinColumn = mArray[j][min];
                    mMinColumnArray[j][min] = 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(mMinColumnArray));
    }

    private static void CountMin() {

        int mCountMin = 0;
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mColumn; j++) {
                mCountMin = mCountMin + mMinRowArray[i][j] * mMinColumnArray[i][j];
            }

        }
        System.out.println("count " + mCountMin);
    }
}
