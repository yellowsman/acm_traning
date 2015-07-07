/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_abc025;

/**
 *
 * @author syogo
 */
import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    int n = scan.nextInt();
    String[] a = new String[25];
    int p = 0;
    for(int i=1;i<=s.length();i++){
      for(int j=1;j<=s.length();j++){
        a[p] = ""+s.charAt(i-1) + s.charAt(j-1);
        p++;
      }
    }

    System.out.println(a[n-1]);
  }
}
