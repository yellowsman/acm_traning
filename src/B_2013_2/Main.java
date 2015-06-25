/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_2013_2;

/**
 *
 * @author syogo
 */
public class Main {
    public static void main(String[] args){
        
    }
    
    public static void b(){
        //Scanner scan = new Scanner(System.in);
        
        
        // hashmap<integer,double>>にチームと問題数を登録
        // 問題を解いた時間は1次元配列で別途に持つ,また、ペナルティも1次元配列で持つ(チーム毎,ペナルティは合計しても構わない)
        // 全てのデータを格納したら、解答数が同じチームの順位付けをするため、同じ成績で取り出す(forループで1~問題数まで回す)
        // 取り出した問題が1つなら処理を飛ばす、2つ以上なら、それぞれで、経過時間とペナルティの数を観て、小さい方に、1以下の数値を加算する
        // つまり、0.1や0.2などである。並べ替えの順番が降順なので、解答数が同じチーム数/10で割り出した値をforループで割り振っていく
        // 同解答数の順位付けが終わったら、順位付け用のリストを用意し、hashmapからチーム番号でデータを取り出す
        // リストは問題によって昇順にならべる　つまり、先に格納されている値と比較し、小さかったら後ろ、大きかったら前に挿入する
        // 最後に、出力する
        // 現在出力している値を監視し、前と同じなら"="、違うなら","を出力する
    }
}
