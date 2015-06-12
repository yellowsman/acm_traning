/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm_traning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author g15002se
 */
public class B_2014_rev2 {

	public static void main(String[] args) throws FileNotFoundException {
		B_2014_rev2 b2 = new B_2014_rev2();
		b2.b();
	}

	public void b() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		//scan = new Scanner(System.in);
		scan = new Scanner(new File("C:\\Users\\g15002se\\Documents\\NetBeansProjects\\acm_traning\\src\\acm_traning\\testdata"));
		int[][] blocks;

		int sum = 0;

		while (true) {
			// 1 <= h <= 10
			sum = 0;
			int h = scan.nextInt();
			if (h == 0) {
				break;
			}

			// 受け取り配列　探索を用意にするために一行一列多い
			blocks = new int[h][5];

			// 配列0列目が一番上
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < 5; j++) {
					blocks[i][j] = scan.nextInt();
				}
			}

			// ブロック落とし
			// 消えたブロックの計算
			boolean flag = true;
			while (flag) {
				flag = false;

				// ブロックが消えるか判断
				for (int i = h - 1; i >= 0; i--) {
					for (int j = 0; j < 3; j++) {
						if (blocks[i][2] == 0) {
							//flag = false;
							break;
						}
						if (blocks[i][0 + j] == blocks[i][1 + j] && blocks[i][1 + j] == blocks[i][2 + j]) {
							// 3つ揃った時
							sum += blocks[i][0 + j] * 3;
							blocks[i][0 + j] = blocks[i][1 + j] = 0;

							// 終わりません
							flag = true;

							// 見た位置が左か真ん中 
							if (j < 2) {
								if (blocks[i][2 + j] == blocks[i][3 + j]) {
									sum += blocks[i][3 + j];
									blocks[i][2 + j] = 0;

									// 見た位置が一番左
									if (j < 1) {
										if (blocks[i][3 + j] == blocks[i][4 + j]) {
											sum += blocks[i][4 + j];
											blocks[i][4 + j] = 0;
										}
									}
									blocks[i][3 + j] = 0;
								}
							}
							blocks[i][2 + j] = 0;

						}

					}
				}

				// ブロック落とし
				// 配列を縦に見て、0以外の数値を取得して格納する
				// 配列の添字に使われている文字が、いままでと逆になっているので注意
				ArrayList<Integer> mlist = new ArrayList<Integer>();

				// 配列を上から見ていって、0ではない数値を退避
				for (int i = 0; i < 5; i++) {
					mlist.clear();
					for (int j = 0; j < h; j++) {
						if (blocks[j][i] != 0) {
							mlist.add(blocks[j][i]);
							blocks[j][i] = 0;
						}
					}

					// 値を配列下から配置していく
					int d = 1;
					for (int j = h - 1; j >= h - mlist.size(); j--) {
						blocks[j][i] = mlist.get(mlist.size() - d);
						d++;
					}
				}
			}
			System.out.println(sum);
		}
	}

}
