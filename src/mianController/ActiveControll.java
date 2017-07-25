package mianController;

import function.ServerConnect;


/**
 * 自動コントロールクラス<br>
 * ユーザ入力等の制御を行う
 * @author Ryousuke
 */
public class ActiveControll {

	ServerConnect connection;


	/**
	 * コンストラクタ
	 */
	public ActiveControll() {
		connection =new ServerConnect();
	}
}
