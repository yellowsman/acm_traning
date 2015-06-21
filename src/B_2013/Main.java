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

    // memo:最後の出力に、同順を管理する必要がある
    // 現在のデータ構造だと、同順を管理することができないため、新しいデータ構造を考える必要がある(ランク要素を追加しても良いけど、管理が非常に煩雑になる)
    public static void main(String[] args) {
        b();

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
                    insert(score, i, j - 1);

                } else { // 同値
                    if (score[j][2] < t) { // 右に挿入
                        insert(score, i, j + 1);
                    } else { // 左に挿入
                        insert(score, i, j - 1);
                    }

                }

            }
        }


        // 出力
        // 前の値と同値 = 同順位ならば"="を出力、そうでないなら","を出力
        int pre1 = 0;
        int pre2 = 0;
        System.out.print(score[0][0]);
        pre1 = score[0][1];
        pre2 = score[0][2];
        for (int i = 1; i < score.length; i++) {
            int[] r = score[i];
            if (r[1] == pre1 && r[2] == pre2) {
                System.out.print("=");
            } else if (r[2] != pre2) {
                System.out.print(",");
            }
            System.out.println(r[0]);

            pre1 = r[1];
            pre2 = r[2];
        }

    }

    // positionの位置にinsの要素を挿入、それより後ろの要素を動かす
    static void insert(int[][] arr, int ins, int position) {
        int[] insert = arr[ins];

        for (int i = ins; i > position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = insert;
    }
}
