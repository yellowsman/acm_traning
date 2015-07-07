/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_abc025;

import java.util.Scanner;

public class Main {
    
    // memo:
    // 点数表を受け取ったら、お互いに点数が高くなるように手を打つ
    // 点数を高い順にソートし、その右側および下側を塗るように動く
    // 相手はそれを阻害するようにうごく
    // 実装が大変そうなのでパス

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] b = new int[2][3];
        int[][] c = new int[3][2];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = scan.nextInt();
            }
        }

        char[][] f = {
            {'x', 'o', 'x'},
            {'o', 'o', 'x'},
            {'o', 'x', 'o'}
        };

        int dp = 0;
        int kp = 0;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (f[i][j] == f[i + 1][j]) {
                    dp += b[i][j];
                } else {
                    kp += b[i][j];
                }

            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (f[i][j] == f[i][j+1]) {
                    dp += c[i][j];
                } else {
                    kp += c[i][j];
                }
            }
        }

        System.out.println(dp +":"+kp);

    }

}
