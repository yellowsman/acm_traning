/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_abc025;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();

        StringBuilder s = new StringBuilder();
        int d = 0; // +なら東 -なら西

        int p = 0; //直大くんの位置
        for (int i = 0; i < n; i++) {
            s.append(scan.next());
            d = scan.nextInt();

            if (d < a) {
                d = a;
            }
            if (d > b) {
                d = b;
            }

            if (s.charAt(0) == 'E') {
                p += d;
            } else {
                p -= d;
            }
            
            s.delete(0, s.length());
        }

        if (p > 0) {
            System.out.print("East ");

        } else if (p < 0) {
            System.out.print("West ");
        }
        System.out.println(Math.abs(p));
    }
}
