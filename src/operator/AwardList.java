package operator;

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

	}

	/**
	 * index 番目の報酬を award に置き換える
	 */
	public void replase(int index, String award) {

	}

	/**
	 * @param index
	 * @return index 番目の報酬
	 */
	public String get(int index) {

	}

	/**
	 * @return 報酬の数
	 * @return
	 */
	public int count() {

	}

	/**
	 * 報酬リストの末尾に報酬を追加する
	 * @param award
	 */
	public void add(String award) {

	}

	/**
	 * 報酬のリストをファイルに書き込む
	 */
	public void writeToFile() {

	}

	/**
	 * index 番目の報酬を削除する
	 * @param index 報酬リストで削除したいインデックス
	 */
	public void remove(int index) {

	}
}
