/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_arc041;

import java.util.Scanner;

/**
 *
 * @author syogo
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int x = scan.nextInt();
        int y = scan.nextInt();
        int k = scan.nextInt();
        
        if(y > k){ // yがkよりも大きい
            System.out.println(k+x);
        }else{
            System.out.println(x-(k-y)+y);
        }
        
    }
    
}
