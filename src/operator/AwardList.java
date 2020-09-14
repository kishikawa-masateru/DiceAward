package operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 報酬リストを管理するクラス<br>
 * ・指定した報酬の書き換え<br>
 * ・報酬の削除<br>
 * ・報酬をファイルへ書き込む
 * @author masateru
 *
 */
public class AwardList {
	private List<String> awardList;	// 報酬リスト
	private String awardPath;		// 報酬リストを書き込むクラス

	/**
	 * コンストラクタ<br>
	 *
	 * 1．引数で指定したパスで awardPath を初期化<br>
	 * 2．awardPath が指しているファイルから報酬を読み込む<br>
	 * 3．読み込んだ報酬を awardList に追加<br>
	 */
	public AwardList(String awardPath) {
		this.awardPath = awardPath;
		awardList = new ArrayList<>();

		File awardFile = new File(this.awardPath);

		if (!awardFile.exists()) {
			System.err.println("ファイル award.txt が存在しません");
			System.exit(1);
		}

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(awardFile), "UTF-8"))) {

			reader.lines().forEach(award -> awardList.add(award));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * index 番目の報酬を award に置き換える
	 */
	public void replase(int index, String award) {
		awardList.set(index, award);
	}

	/**
	 * @param index
	 * @return index 番目の報酬
	 */
	public String get(int index) {
		return awardList.get(index);
	}

	/**
	 * @return 報酬の数
	 */
	public int count() {
		return awardList.size();
	}

	/**
	 * 報酬リストの末尾に報酬を追加する
	 * @param award
	 */
	public void add(String award) {
		awardList.add(award);
	}

	/**
	 * 報酬のリストをファイルに書き込む
	 */
	public void writeToFile() {
		try (PrintWriter writer = new PrintWriter(
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream(awardPath), "UTF-8")))) {

			for (String award : awardList) {
				writer.println(award);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * index 番目の報酬を削除する
	 * @param index 報酬リストで削除したいインデックス
	 */
	public void remove(int index) {
		awardList.remove(index);
	}

	/**
	 * 報酬リストを表示する
	 */
	public void show() {
		System.out.println(this);
	}

	/**
	 * 報酬リストからコンソール出力用フォーマットを作成
	 * @return コンソール出力用のフォーマット
	 */
	@Override
	public String toString() {
		int i = 0;
		StringBuilder builder = new StringBuilder();

		for (String award : awardList) {
			builder.append(i++).append(" : ").append(award + "\n");
		}

		return builder.toString();
	}
}
