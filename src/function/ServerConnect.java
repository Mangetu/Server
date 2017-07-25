package function;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * データ編集関係クラス
 * 基本的にURL関係の処理担当
 * @author Ryousuke
 *
 */
public class ServerConnect {

	//接続サーバーリスト
	private List<URL> urlListData;

	/**
	 * コンストラクタ
	 */
	public ServerConnect() {
		urlListData = new ArrayList<URL>();
	}

	/**
	 * 現在設定しているURLリストを取得
	 * @return URLのリスト
	 */
	public List<URL> getUrlListData(){
		return urlListData;
	}

	/***
	 * 接続状態更新処理<br>
	 * 現在のフィールドのUrlListのstatusを順に返す
	 * @return urlListdata
	 * @throws IOException
	 */
	public List<String> connect() throws IOException{

		HttpsURLConnection data;
		List<String> ansList =new ArrayList<String>();

		//フィールドチェック
		if(!CheckUrlList()){
			ansList.add("未設定");
			return ansList;
		}

		for(Iterator<URL> count=urlListData.iterator();count.hasNext();){
			data=(HttpsURLConnection)(count.next().openConnection());
			data.setRequestMethod("GET");
			data.setInstanceFollowRedirects(false);
			data.getContent();

			if(data.getResponseCode()==HttpURLConnection.HTTP_OK){
				ansList.add("Green");
			}else{
				ansList.add("yellow");
			}
			data.disconnect();
		}

		return ansList;
	}

	/***
	 * 接続サーバー追加処理<br>
	 * 引数のURLのListをフィールドに設定し、その順でstatusを返す
	 * @param ULRのリスト
	 * @return 引数のサーバステータスリスト
	 * @throws IOException
	 */
	public List<String> connect(List<String> urlList) throws IOException {

		this.urlListData=new ArrayList<URL>();

		try{
			for(Iterator<String> count=urlList.iterator();count.hasNext();){
				urlListData.add(new URL(count.next()));
			}
		}catch(MalformedURLException e){
			List<String> ans = new ArrayList<String>();
			ans.add("エラー");
			return ans;
		}

		return connect();
	}

	/**
	 * URLリストチェック
	 * @return
	 */
	private boolean CheckUrlList(){
		if(this.urlListData==null){
			return false;
		}else{
			return true;
		}
	}
}
