/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acm;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yellow
 */
public class ProgC2012 {
    Cye[][][] field = new Cye[3][3][20];
    int[] point = new int[6];
    int[][] top = new int[3][3]; //サイコロのある一番高い位置
    int p;
    int up=0;
    int front=0;
    int max;
    
    
    
    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("samp.txt");

                /*ファイル読み込み*/
                fr.read();
                
                //BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
                
                while(true){
                    Cye cc = new Cye(5,10);
                   
                }
                
                
                        
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProgC2012.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("正しいファイルを選択してください");
        }catch (IOException ex) {
                Logger.getLogger(ProgC2012.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    
    public int drop(Cye cye){
        field[1][1][top[1][1]] = cye;
        top[1][1]++;
        
        
        
        
        return 1;
    }
    
    //サイコロの目の回数を数える
    public void result(){
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
              p =  field[a][b][top[a][b]].up;
              point[p]++;
            }
            
        }        
    }
    
    
    public void init(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                top[i][j]=0;
            }
        }
    }
    
}

class Cye{
    int up;
    int down;
    int lear;
    int front;
    int right; //frontと向い合って右の面
    int left;   //frontと向い合って左の面
    int esc;    //逃げ
    
    int[] panel = new int[6];
    
    
    
    public Cye(int front,int up){
        panel[2] = front;   //正面
        panel[0] = up;     //上
        panel[1] = 7 - up;  //底面
        panel[3] = 7 - front;   //裏
        int fl = front * lear;
        int ud = up * down;
        int lr;
        //それぞれの組みごとに掛け算してその値で判別する    12,10,6のペアが存在する 引くと5,3,1
        
        if(fl == 12 && ud == 10) lr = 6;
        if(fl == 12 && ud == 6) lr = 10;
        if(fl == 10 && ud == 6) lr = 12;
        if(fl == 10 && ud == 12) lr = 6;
        if(fl == 6 && ud == 12) lr = 10;
        if(fl == 6 && ud == 10) lr = 12;
        
        
        //正面=1 上=2 左=3 の編成とする　これ以外の構成は存在しない
        //正面と上と構成ルールの情報のみで全面の目が判明できないのか検討中
        if(front == 1 && up == 2)   set(1,6,2,5,4,3);//左は3 
            
              
        if(front == 1 && up == 3)   set(1,6,3,4,2,5);
        if(front == 1 && up == 4)   set(1,6,4,3,5,2);
        if(front == 1 && up == 5)   set(1,6,5,2,3,4);//左は4
            
        if(front == 2 && up == 1)
        if(front == 2 && up == 6)//左は3
        if(front == 2 && up == 6)//左は4
        if(front == 3 && up == 2)//左は6
        if(front == 3 && up == 1)
            
            
        for(int aa=1;aa<7;aa++){
            for(int bb=1;bb<7;bb++){
                if(front == aa && up == bb){}
                if(front == bb && up == aa){}
            }
        }
        
                
    }
    
    public void set(int f,int l,int u,int d,int r,int le){
        panel[2] = f;
        panel[0] = u;
        panel[1] = d;
        panel[3] = l;
        panel[4] = r;
        panel[5] = le;
    }
    
    //手前に転がる
    public void spinFront(){
        esc = front;
        front = up;
        up = lear;
        lear = down;
        down = esc;
    }
    //奥に転がる
    public void spinLear(){
        esc = lear;
        lear = up;
        up = front;
        front = down;
        down= esc;
        
    }
    //右に転がる
    public void spinRight(){
        esc = right;
        right = up;
        up = left;
        left = down;
        down = esc;
        
               
        
    }
    //左に転がる
    public void spinLeft(){
        esc = left;
        left = up;
        up = right;
        right = down;
        down = esc;
        
    }
    
    public int getUp(){
        return up;
    }
    
    
    
}
