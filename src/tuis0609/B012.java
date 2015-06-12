/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuis0609;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author g15002se
 */
public class B012 {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);

        Scanner scan = new Scanner(new File("C:\\Users\\g15002se\\Documents\\NetBeansProjects\\acm\\src\\tuis0609\\testdata"));

        int n = scan.nextInt();
        //int[][] nsquare = new int[n][15];
        int[][] esquare = new int[n][8];
        int[][] osquare = new int[n][7];

        String line;
        for (int i = 0; i < n; i++) {
            line = scan.next();
            line = line.substring(0, line.length() - 1);
            for (int j = 0; j < 15; j++) {

                // 配列要素の問題で、割り切れた時にodd,そうでない時にeven
                if (j % 2 == 0) {
                    esquare[i][j / 2] = Integer.parseInt(line.substring(j, j + 1));
                } else {
                    osquare[i][j / 2] = Integer.parseInt(line.substring(j, j + 1));;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int even = compEven(esquare[i]);
            int odd = compOdd(osquare[i]);
            int evenodd = even + odd;
            int plus = 10 - (evenodd % 10);
            System.out.println(plus);

        }
    }

    static int compEven(int[] digits) {
        int sum = 0;
        for (int s : digits) {
            switch (s) {
                case 5:
                    sum += 1;
                    break;
                case 6:
                    sum += 3;
                    break;
                case 7:
                    sum += 5;
                    break;
                case 8:
                    sum += 7;
                    break;
                case 9:
                    sum += 9;
                    break;
                default:
                    sum += s * 2;
            }
            
        }
        return sum;
    }

    static int compOdd(int[] digits) {
        int sum = 0;
        for (int s : digits) {
            sum += s;
        }

        return sum;
    }

}
