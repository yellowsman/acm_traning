/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_2013;

import java.util.Scanner;

/**
 *
 * @author syogo
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            int h = scan.nextInt();
            int w = scan.nextInt();
            
            if( h == 0 && w == 0) break;
            
            a(h,w);
        }
    }

    // 解答の範囲を全探索
    public static void a(int h,int w) {
        int base = (h * h) + (w * w);

        int min = 150 * 150;
        int ai = 0;
        int aj = 0;

        for (int i = 1; i <= 150; i++) {
            for (int j = i+1; j <= 150; j++) {
                int c = (i * i) + (j * j);
                if (c == base) {
                    if (i < h) { // 高さが低い方が大きいとされる
                        if (c < min) {
                            min = c;
                            ai = i;
                            aj = j;
                        }
                    }
                }else if (c > base) {
                    if (c < min) {
                        min = c;
                        ai = i;
                        aj = j;
                    }
                }
            }
        }

        System.out.println(ai + " " + aj);
    }
}
