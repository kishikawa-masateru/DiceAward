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
}
