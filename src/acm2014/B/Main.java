/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm2014.B;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Yellow
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        b();
    }

    public static void b() throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("C:\\Users\\ESCP-SHOGO\\Documents\\NetBeansProjects\\acm\\src\\acm2014\\B\\testdata.txt"));

        while (true) {
            int height = scan.nextInt();
            if (height == 0) {
                return;
            }

            int[][] data = new int[height][5];

            // データ格納
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < 5; j++) {
                    data[i][j] = scan.nextInt();
                }
            }

            // 初期化   
            int sum, combo;
            sum = combo = 0;
            boolean ismove, iscombo;

            do {
                /* 
                 左端から順次探索
                 chacheと数字を比較
                 一致していればコンボに追加
                 違っていれば、コンボ数に応じて処理
                 5件を超えたら、comboを0へ
                 */

                iscombo = ismove = false;
                int s = 0;

                for (int i = 0; i < height; i++) {
                    int d = data[i][0];
                    combo = 1;
                    for (int j = 1; j < 5; j++) {
                        if (data[i][j] == d) {
                            iscombo = true;
                            combo++;
                        } else {
                            iscombo = false;
                            combo = 1;
                            d = data[i][j];
                        }

                        if (combo > 2) {
                            s = combo * d;

                            for (int k = 0; k < combo; k++) {
                                data[i][j - k] = 0;
                            }
                        }

                    }
                    if (combo > 2) {
                        s = combo * d;
                    }
                    sum += s;
                }

                
                // 落とす処理
                // 途中までは正しいが、最後から2列目(上から2列目)になると全てに0が入れられてしまう
                // 無限ループにも入ってしまう
                for (int i = height-1; i > 0; i--) {
                    for (int j = 0; j < 5; j++) {
                        if (data[i][j] <= 0) {
                            if (data[i - 1][j] <= 0) {
                                data[i - 1][j] = data[i][j] - 1;
                            } else {
                                int u = i - data[i][j];
                                data[u][j] = data[i-1][j];
                                data[i-1][j] = 0;
                            }
                            ismove = true;
                        }
                    }
                }

            } while (ismove);
            System.out.println(sum);
        }
    }
}
