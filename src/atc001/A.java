/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atc001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author syogo
 */
public class A {

    static char[][] map;
    static ArrayList<XY> queue = new ArrayList<XY>();
    static int h, w;

    public static void main(String[] args) {
        
        char[] c = {'.','#','s','g'};
        ArrayList<Integer> cd = new ArrayList<Integer>();
        for(char cc:c){
            System.out.println((int)cc);
            cd.add((int)cc);
        }
        for(int n:cd){
            System.out.println((char)n);
        }
        
        
        
        Scanner scan = new Scanner(System.in);

        h = scan.nextInt();
        w = scan.nextInt();
        
        map = new char[w][h];
        
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                //map[i][j] = scan.next();
            }
        }

    }

    static int deepSearch(XY xy) {
        int x = xy.x;
        int y = xy.y;

        if (map[x][y] == '.') {
            if (x - 1 >= 0) {
                queue.add(new XY(x - 1, y));
            }
            if (x + 1 < w) {
                queue.add(new XY(x + 1, y + 1));
            }
            if (y - 1 >= 0) {
                queue.add(new XY(x + 1, y + 1));
            }
            if (y + 1 < h) {
                queue.add(new XY(x + 1, y + 1));
            }
            return 0;
        }
        if (map[x][y] == 'g') {
            return 1;
        }

        return 0;
    }

}

class XY {

    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
