package app;

import java.util.Random;
import java.util.Scanner;

import operator.AwardList;

public class Main {

	static AwardList awardList; // 報酬リスト
	static String PATH_SEPARATOR; // パスの区切り文字
	static Scanner sc;

	static {
		// OSに応じてパスの区切り文字を設定する
		String os_name = System.getProperty("os.name").toLowerCase();
		if (os_name.contains("windows")) {
			PATH_SEPARATOR = "\\";
		} else if (os_name.contains("mac") || os_name.contains("linux")) {
			PATH_SEPARATOR = "/";
		}

		// 報酬リストファイルのパスを作成
		String user_dir_path = System.getProperty("user.dir");
		String project_path = user_dir_path.substring(0, user_dir_path.lastIndexOf(PATH_SEPARATOR));
		String award_path = project_path + PATH_SEPARATOR + "src" + PATH_SEPARATOR + "award" + PATH_SEPARATOR
				+ "award.txt";

		awardList = new AwardList(award_path);
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {

		// プログラム終了時に awardList の報酬をファイルに上書きする
		Runtime.getRuntime().addShutdownHook(new Thread(() -> awardList.writeToFile()));

		// コマンドライン引数がない場合は，ランダムな報酬を出力する
		if (args.length == 0) {

			int index = new Random().nextInt(awardList.count()); // 報酬の数の範囲内で乱数を取得

			// 乱数が示す報酬を出力
			System.out.println(awardList.get(index));
		}

		// コマンドライン引数がある場合は，その種類に応じて処理を分岐する
		else {
			switch (args[0]) {
				case "add":
					// 編集前状態を表示
					awardList.show();

					// 報酬を追加する
					awardList.add(getAward());
					break;
				case "set":
					// 編集前状態を表示
					awardList.show();

					// 指定した報酬を上書きする
					awardList.replase(getIndex(), getAward());
					break;
				case "remove":
					// 編集前状態を表示
					awardList.show();

					// 指定した報酬を削除する
					awardList.remove(getIndex());
					break;
				case "show":
					// 中身の表示
					awardList.show();

					// そのまま終了
					sc.close();
					System.exit(0);
			}

			// 結果の表示
			System.out.println();
			awardList.show();
			sc.close();
		}
	}

	/**
	 * コンソールから，報酬を取得する
	 * 
	 * @return 報酬
	 */
	private static String getAward() {
		System.out.print("報酬...");
		return sc.next();
	}

	/**
	 * コンソールから，インデックスを取得する
	 * 
	 * @return 編集する報酬リストのインデックス
	 */
	private static int getIndex() {
		System.out.print("インデックス...");
		return sc.nextInt();
	}
}