# source.oysterworld.jpへのデプロイ手順（warファイルの場合）

## spring projectからwarファイル作成する
※注意※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
この手順はgradleプロジェクトの場合なのでmavenでspringプロジェクトを作成している場合には適用されません。
※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※

1. コマンドプロンプトを開く
2. cd eclipseのプロジェクトのルートディレクトリ(gradlewがあるディレクトリ）
3. gradlew build -x test コマンドを実行する
(内部コマンド～と出たらjavaのパスが通ってない以下参照 https://www.javadrive.jp/start/install/index4.html)
4. eclipseのプロジェクトルートディレクトリ\build\libsにwarファイルが作成されるので確認（*/plainが作られている場合はじゃない方を使用）

## ec2サーバーにアクセス

1. teratermかwinscpをダウンロード
teratermのみでもいいが、winscpの併用がおすすめ　ファイル移動がドラッグアンドドロップでできるので。

winscp : https://winscp.net/eng/download.php　　
teraterm : http://ttssh2.osdn.jp/index.html.ja

2. ホスト名：source.oysterworld.jp
ユーザー名：ec2-user
を入力

3. 
RSA/DSA/ECDSA/ED25519鍵を使う」にチェック
会社のdropboxアカウントから秘密鍵を取得
場所はDropbox/オイスターワールド/60_ホームページ/オイスターワールド/key.pem
（winscpの場合は秘密鍵は.ppkファイルになるがアプリ内で勝手に変換してくれる）

4. サーバー内にログインする


## tomcat内にwarファイル配置
既にtomcatとhttpdが作成されているのでそのファイル内にwarファイルを配置する

1. ファイルをアップロード（winscpを使用してドラッグアンドドロップ）
2. cd ファイルをアップロードした場所
3. sudo mv ファイル名.war /var/lib/tomcat/webapps/　でファイルを移動させる
4. sudo systemctl restart httpd
5. sudo systemctl restart tomcat



## URIを設定（自前で準備してもいいが作られているものを流用する方法）
1. cd /etc/httpd/conf.d/springboot.conf
で移動
2. 
<VirtualHost *:80>タグ内にProxyPassとajp接続を設定
ProxyPass /"作成したファイル名"/ ajp://localhost:8009/"作成したファイル名"/　と記載

3. 
white.source.oysterworld.jp/作成したファイル名/
でアクセス（末尾の/を忘れないこと）


## その他

### ログの場所
見るべきは/usr/share/tomcat/logs内
catalina.日付.logファイル　…　立上げ履歴？が記載されている。
localhost.日付.logファイル　…エラーログが格納されているインフラ側で立ち上がらなかった場合は大体こっちにログがあることが多い
履歴はUS時間になっているので注意　現在の日付はdateコマンドで確認できる

### jarファイルはテスト用に使用する
jarファイルは配置して
java -jar ファイル名.jar --server.port=ポート番号
で起動できる。ここで立ち上がるのはサーバー内のlocalhostの接続なのでテスト用にどうぞ







