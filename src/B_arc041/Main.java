/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_arc041;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    int[][] field;
    int[][] result;
    int height, width;

    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.b();
    }

    void b() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        //Scanner scan = new Scanner(new File("C:\\Users\\省吾\\Documents\\NetBeansProjects\\acm_traning\\src\\B_arc041\\testadata"));

        // 初期値設定
        height = scan.nextInt();
        width = scan.nextInt();
        field = new int[height][width];
        result = new int[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(result[i], 0);
        }

        for (int i = 0; i < height; i++) {
            StringBuffer sb = new StringBuffer(scan.next());
            for (int j = 0; j < width; j++) {
                field[i][j] = Integer.parseInt(sb.substring(j, j + 1));
            }
        }

        // 移動処理
        for (int i = 0; i < height - 2; i++) {
            for (int j = 0; j < width; j++) {
                if (isSquare(i, j)) {
                    moveSquare(i, j);
                }
            }
        }

        // 画面出力
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }

    // 4マスをチェックして、4マス全てに0以外が入っていればtrue,そうでなければfalse
    // 引数の値がてっぺん
    boolean isSquare(int s_y, int s_x) {
        if (s_x - 1 < 0 || s_x + 1 > width - 1) {
            return false;
        }
        if (s_y + 2 > height - 1) {
            return false;
        }

        if (field[s_y][s_x] == 0) {
            return false; // 上
        }
        if (field[s_y + 1][s_x - 1] == 0) {
            return false;  //左
        }
        if (field[s_y + 1][s_x + 1] == 0) {
            return false; // 右
        }
        if (field[s_y + 2][s_x] == 0) {
            return false; // 下
        }
        return true;
    }

    void moveSquare(int s_y, int s_x) {
        int min = 999;

        // 最小値を検索
        min = Math.min(min, field[s_y][s_x]);
        min = Math.min(min, field[s_y + 1][s_x - 1]);
        min = Math.min(min, field[s_y + 1][s_x + 1]);
        min = Math.min(min, field[s_y + 2][s_x]);

        // 値の更新
        result[s_y + 1][s_x] = min;
    }
}
