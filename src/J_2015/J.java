/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yellow
 */
public class J {
    public static void main(String[] args) throws FileNotFoundException{
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new File("C:\\Users\\ESCP-SHOGO\\Documents\\NetBeansProjects\\acm_traning\\src\\J_2015\\testdata"));
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("C:\\Users\\ESCP-SHOGO\\Documents\\NetBeansProjects\\acm_traning\\src\\J_2015\\answer"));
            
            int max = 0;
            int n = scan.nextInt();
            while(n != 0){
                max = Math.max(max, n);
                n = scan.nextInt();
            }
            
            fw.write(""+max);
            fw.flush();
            fw.close();
            System.out.println(max);
        } catch (IOException ex) {
            Logger.getLogger(J.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
