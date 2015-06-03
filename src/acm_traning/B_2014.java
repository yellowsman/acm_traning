/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm_traning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author syogo
 */
public class B_2014 {
    /*
     ブロックを5*hの一次元配列blocksで持つ
     同様に、消えたブロックを扱うint型一次元配列=fall[]も持つ
     終了フラグfinishを用意
     ---S----
     配列の下端から、11111~99999,1111~9999,111~999など、各桁ごとに総当り
     ブロックが消えたら、fallに消えた要素に"1"を入れる
     最後まで見たら、
     0~hでループ(a)
     0~4でループ(b)
     int型変数moveを用意
     ループカウント(b)*5でfallを見ていき、0ならblocksをループカウント(b)*moveで移動させる
     blocks[move*(b)] = blocks[12-move*(b)] 　そして、合計値にmove*(b)をプラスする
     1ならmoveに加算する
     
     ここまで来たら、--S--に戻る
     消すブロックが無くなったら合計値を出力して終わり
          
        
    　
     */

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        scan = new Scanner(new File("C:\\Users\\省吾\\Documents\\NetBeansProjects\\acm_traning\\btest.txt"));

        while (true) {

            // 1 <= h <= 10
            int h = scan.nextInt();
            if (h == 0) {
                break;
            }

            StringBuffer blocks = new StringBuffer();
            int[] fall = new int[h * 5];

            // 入力
            // 上の段から順番に入力する
            StringBuffer line = new StringBuffer();
            for (int i = 0; i < h; i++) {
                line.delete(0, line.capacity());
                for (int j = 0; j < 5; j++) {
                    line.append(scan.next());
                }
                blocks.replace(0, blocks.capacity(), blocks.toString() + line.toString());
            }

            // ブロック消滅の判定
            // 消したブロックの合計点
            int point = 0;

            // ブロックに揃う文字が出現しなくなったら終了
            while (true) {
                Arrays.fill(fall, 0);
                for (int i = 0; i < h; i++) {
                    boolean roopout = false;

                    for (int j = 1; j < 10; j++) {

                        // 
                        StringBuffer compare = new StringBuffer("" + j + j + j + j + j);
                        int length = 5; // length = 文字列の長さ
                        for (int s = 0; s < 1; s++) { // s = trimする文字列の長さ 5=0,4=1~2,3=1~3
                            compare.setLength(length);
                            String substr = blocks.substring((i * 5) + s, (i * 5) + length);
                            if (compare.toString().equals(substr)) {
                                point += j * length;
                                for (int k = s + (i * 5); k < s + (i * 5) + length; k++) {
                                    fall[k] = 1;
                                    blocks.replace(k, k + 1, "0");
                                }
                                roopout = true;
                                break;
                            }
                        }
                        if (roopout) {
                            break;
                        }

                        length = 4;
                        for (int s = 0; s < 2; s++) {

                            compare.setLength(length);
                            String substr = blocks.substring((i * 5) + s, (i * 5) + length + s);
                            if (compare.toString().equals(substr)) {
                                point += j * length;
                                for (int k = s + (i * 5); k < s + (i * 5) + length; k++) {
                                    fall[k] = 1;
                                    blocks.replace(k, k + 1, "0");
                                }
                                roopout = true;

                                break;
                            }
                        }
                        if (roopout) {
                            break;
                        }

                        length = 3;
                        for (int s = 0; s < 3; s++) {
                            compare.setLength(length);
                            String substr = blocks.substring((i * 5) + s, (i * 5) + length + s);
                            if (compare.toString().equals(substr)) {
                                point += j * length;
                                for (int k = s + (i * 5); k < s + (i * 5) + length; k++) {
                                    fall[k] = 1;
                                    blocks.replace(k, k + 1, "0");
                                }
                                roopout = true;
                                break;
                            }

                        }
                        if (roopout) {
                            break;
                        }

                    }

                }

                // 消えたブロックチェック
                // 後ろから読んでいく
                for (int k = blocks.length() - 1; k > 4; k--) {
                    if (blocks.charAt(k) == '0') {
                        blocks.replace(k, k + 1, "" + blocks.charAt(k - 5));
                        blocks.replace(k - 5, k - 4, "" + 0);
                        System.out.println(blocks.toString());
                    }
                }
                // fallに1があるならループ継続
                boolean whileout = true;
                for (int f : fall) {
                    if (f == 1) {
                        whileout = false;
                        break;
                    }
                }

                if (whileout || blocks.length() <= 5) {
                    break;
                }

            }

            System.out.println(point);
        }

    }

    StringBuffer plug(StringBuffer sb, int h) {
        // ここで文字列を横向き(縦の情報を横に表示する)に変換
        // つまり、90度右方向に傾ける
        // 

        
        
        
        int[] data = new int[h];
        Arrays.fill(data, 0);
        int counter = 0;
        

        for (int g = 5; g > 0; g--) {
            for (int i = h-1; i >= 0; i--) {
                if(sb.charAt(g+(5*i)) != '0'){
                    data[counter] = sb.charAt(g+(5*i));
                    counter++;
                }
            }
            for(int j=h; j>counter;j--){
                sb.replace(g*j, g*j+1, ""+data[counter]);
                counter++;
            }

        }

        return null;
    }
}
