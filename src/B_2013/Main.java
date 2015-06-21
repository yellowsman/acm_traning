/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author syogo
 */
public class Main {

    public static void main(String[] args) {
        int[] aaa = new int[6];
        for (int i = 1; i < aaa.length; i++) {
            aaa[i] = (int) (Math.random() * 10);
        }

        Arrays.sort(aaa);
        System.out.println();

    }

    public static void b() {
        Scanner scan = new Scanner(System.in);

        int bm = scan.nextInt();
        int bt = scan.nextInt();
        int bp = scan.nextInt();
        int br = scan.nextInt();

        int[][] score = new int[bt][3]; // チーム番号、問題数、経過時間
        int[][] penalty = new int[bt][bp];

        for (int i = 0; i < br; i++) {
            int m = scan.nextInt();
            int t = scan.nextInt();
            int p = scan.nextInt();
            int j = scan.nextInt();

            if (j == 0) {
                score[t][0] = t;
                score[t][1]++; // 正解数
                score[t][2] += (m + (penalty[t][p] * 20)); // 経過時間
            } else {
                penalty[t][p]++;
            }
        }

        // ソート
        // 正解数を基準に挿入ソートでやる
        for (int i = 1; i < score.length; i++) {
            int s = score[i][1];
            int t = score[i][2];
            for (int j = 0; j < i; j++) {
                if (score[j][1] < s) { // より大きい
                    insert(score, i, j + 1);

                } else if (score[j][1] > s) { // より小さい
                    insert(score,i,j-1);

                } else { // 同値
                    if(score[j][2] < t){ // 右に挿入
                        insert(score,i,j+1);
                    }else{ // 左に挿入
                        insert(score,i,j-1);
                    }

                }

            }
        }
        
        for(int i=0;i<score.length;i++){
            int rank = 1;
            
        }
        
        for(int[] r:score){
            
        }

    }

    // positionの位置にinsの要素を挿入、それより後ろの要素を動かす
    static void  insert(int[][] arr, int ins, int position) {
        int[] insert = arr[ins];

        for (int i = ins; i > position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = insert;
    }
}
