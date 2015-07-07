/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_2014;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Yellow
 */
public class C_2014 {

    /*
     極論を言えば、もっとも中央に近く、もっとも低い位置さえ覚えておけば良い
     影がある空間を管理する配列と、それぞれの位置における高さを管理する配列を用意する
     ・影配列は{0,1,2}を範囲とする。0=影がない、1=重複しておらず隙間がある影 2=重複しており隙間がない影
     ・高さ配列は位置*高さで計算した評価値を持つ　新しい高さが記述されたら、この値を更新する
     高さ配列が最も低い値をもっとも影が低い場所とする
    
     [影配列]
     -3 -2 -1 0 1 2 3
     |----|
     |----|
     |---|
    
     1 2  2  1 1 2 1  ===> 重複した部分や間は2 重複していない端は1 0と1の間に隙間がある事を表現している　1で最も中央に近いものが穴
      
    
    
    
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bs, be, bh;
        bs = be = 0;
        bh = 20;

        int r = scan.nextInt();
        int n = scan.nextInt();

        int[][] data = new int[n][3];

        for (int i = 0; i < n; i++) {
            data[i][0] = scan.nextInt();
            data[i][1] = scan.nextInt();
            data[i][2] = scan.nextInt();
        }

        System.out.println(limit(data, r, n));

        //data = sort(data);
    }

    // いつまで太陽が隠れるか判定
    public static double limit(int[][] data, int r, int n) {

        int[] shadows = new int[r * 2 + 1];
        int[] heights = new int[r * 2 + 1];

        Arrays.fill(shadows, 0);
        Arrays.fill(heights, 0);

        for (int i = 0; i < n; i++) {

            // 建物に幅の始点と終点
            int start = data[i][0];
            int end = data[i][1];
            int height = data[i][2];

            // 建物がrの範囲内に入るか判定
            // 入力された建物が、rの範囲外でなければ次の処理へ
            //
            // s  e     |-r ------------- r|     s  e
            if ((start < -r && end < -r) || (start > r && start > r)) {
                System.out.println("out of range");
            } else {
                if (start < -r) {
                    start = -r;
                }
                if (end > r) {
                    end = r;
                }

                // 影配列の管理
                if (shadows[start + r] + 1 <= 2) {
                    shadows[start + r]++;
                }
                if (shadows[end + r] + 1 <= 1) {
                    shadows[end + r]++;
                }
                for (int j = start + 1; j <= end - 1; j++) {
                    shadows[j + r] = 2;
                }

                // 高さ配列の管理
                for (int k = start; k <= end; k++) {
                    if (k != 0) {
                        heights[k + r] = Math.max(heights[k + r], Math.abs(k * height)); // 高さを評価
                    } else {
                        heights[k + r] = Math.max(heights[k + r], Math.abs(height)); // 高さを評価
                    }
                }
            }
        }
        return -1.0;
    }

    // 最初から昇順で値が渡されるので不要
    public static int[][] sort(int[][] target) {
        int[] tmp = new int[3];

        for (int i = 1; i < target.length; i++) {
            for (int j = 0; j < target.length - i; j++) {
                if (target[j][0] > target[j + 1][0]) {
                    tmp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = tmp;
                }
            }
        }

        return target;
    }

}
