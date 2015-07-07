/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package K_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yellow
 */
public class K {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new File("C:\\Users\\ESCP-SHOGO\\Documents\\NetBeansProjects\\acm_traning\\src\\K_2015\\testdata"));
        FileWriter fw = new FileWriter(new File("C:\\Users\\ESCP-SHOGO\\Documents\\NetBeansProjects\\acm_traning\\src\\K_2015\\answer"));

        int n = scan.nextInt();
        int m = scan.nextInt();
        while (n != 0 || m != 0) {
            fw.write("" + ((double) n / m));
            fw.write(System.getProperty("line.separator"));
            n = scan.nextInt();
            m = scan.nextInt();
        }
        fw.flush();
        fw.close();
    }

}
