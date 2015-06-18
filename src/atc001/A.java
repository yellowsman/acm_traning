/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atc001;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
    static boolean[][] memo;
    static int h, w;

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("C:\\Users\\省吾\\Documents\\NetBeansProjects\\acm_traning\\src\\atc001\\testdata"));

        h = scan.nextInt();
        w = scan.nextInt();

        map = new char[h][w];
        memo = new boolean[h][w];
        for (boolean[] b : memo) {
            Arrays.fill(b, false);
        }

        int count = 0;
        // mapの生成
        for (int i = 0; i < h; i++) {
            String s = scan.next();
            for (int j = 0; j < w; j++) {
                count++;
                System.out.println(count);
                map[i][j] = s.charAt(j);
                if (map[i][j] == 's') {
                    if (i - 1 >= 0) {
                        if (memo[i - 1][j]) {
                            queue.add(new XY(i - 1, j));
                        }

                    }
                    if (i + 1 < w) {
                        if (memo[i + 1][j]) {
                            queue.add(new XY(i + 1, j));
                        }

                    }
                    if (j - 1 >= 0) {
                        if (memo[i][j - 1]) {
                            queue.add(new XY(i, j - 1));
                        }

                    }
                    if (j + 1 < h) {
                        if (memo[i][j + 1]) {
                            queue.add(new XY(i, j + 1));
                        }

                    }
                    memo[i][j] = true;
                }

            }
            //scan.nextLine();
        }
        int result = 0;

        do {
            if (queue.size() > 0) {
                result = Math.max(result, deepSearch(queue.get(0)));
            }
        } while (queue.isEmpty() == false);

        if (result > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static int ct = 0;

    static int deepSearch(XY xy) {
        ct++;
        System.out.println(ct);
        int x = xy.x;
        int y = xy.y;

        //System.out.println();
        if (map[x][y] == '.') {
            System.out.println("y");
        }

        if (map[x][y] == '.') {
            if (x - 1 >= 0 || memo[x][y]) {
                queue.add(new XY(x - 1, y));
            }
            if (x + 1 < w || memo[x][y]) {
                queue.add(new XY(x + 1, y));
            }
            if (y - 1 >= 0 || memo[x][y]) {
                queue.add(new XY(x, y - 1));
            }
            if (y + 1 < h || memo[x][y]) {
                queue.add(new XY(x, y + 1));
            }
            return 0;
        }
        if (map[x][y] == 'g') {
            return 1;
        }
        if (map[x][y] == 's' || map[x][y] == '#') {
            queue.remove(new XY(x, y));
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
