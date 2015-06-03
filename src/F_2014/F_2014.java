/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package F_2014;

import java.util.Scanner;

/**
 *
 * @author syogo
 */
public class F_2014 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isend;

        while (true) {
            isend = true;
            int[] limit = new int[6];
            int[] count = new int[6];
            String strManip = "";
            
            for (int i = 0; i < 6; i++) {
                limit[i] = scan.nextInt();
                if(limit[i] != 0) isend = false; // 0以外があれば継続
            }
            if(isend) break;
            
            
            int p = scan.nextInt();
            int q = scan.nextInt();
            int head = limit[0]; //最も小さい数字
            
            
            for(int i=0;i<q;i++){
                for(int j=head;j<limit.length;j++){
                    strManip+="";
                    count[j]++;
                    if(limit[j] <= count[j]){
                        head++;
                    }
                }
            }
            
            for(int i=p;i<=q;i++){
                System.out.print(strManip.charAt(i));
            }
            System.out.println();
        }

    }
}
