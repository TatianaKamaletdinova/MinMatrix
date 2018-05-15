package com.company;
import java.util.Scanner;

public class Main {

    private static int[][] mArray;
    private static int mRow;
    private static int mColumn;
    private static int mMinRowArray[][];
    private static int mMinColumnArray[][];
    private static int mMin;

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
        /*
        массив в расположением минимальных чисел в стоках
         */
        MinRow();

         /*
        массив в расположением минимальных чисел в столбцах
         */
        MinColumn();
        mArray = null;

         /*
        количество элементов в матрице
         */
        CountMin();
    }

    /*
           массив в расположением минимальных чисел в стоках
            */
    private static void MinRow() {

        mMinRowArray = new int [mRow][mColumn];
        for (int min = 0; min < mRow; min++) {
            mMin = mArray[min][0];
            for (int j = 0; j < mColumn; j++) {
                if (mMin >= mArray[min][j]) {
                    mMin = mArray[min][j];
                }
            }

            for (int j = 0; j < mColumn; j++) {
                if (mMin >= mArray[min][j]) {
                    mMin = mArray[min][j];
                    mMinRowArray[min][j] = 1;
                }
            }
        }
    }


    /*
        массив в расположением минимальных чисел в столбцах
         */
    private static void MinColumn() {

        mMinColumnArray = new int[mRow][mColumn];

        for (int min = 0; min < mColumn; min++) {
            mMin = mArray[0][min];
            for (int j = 0; j < Main.mRow; j++) {
                if (mMin >= mArray[j][min]) {
                    mMin = mArray[j][min];
                }
            }
            for (int j = 0; j < mRow; j++) {
                if (mMin >= mArray[j][min]) {
                    mMin = mArray[j][min];
                    mMinColumnArray[j][min] = 1;
                }
            }
        }

    }

    /*
       количество элементов в матрице
        */
    private static void CountMin() {

        int mCountMin = 0;
        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mColumn; j++) {
                mCountMin = mCountMin + mMinRowArray[i][j] * mMinColumnArray[i][j];
            }

        }
        System.out.println(mCountMin);
    }
}