# todo_servercode
### 環境構築①
vagrantとVMboxのインストール  
https://qiita.com/aoi70/items/b66a451f4b7f5f05beec  
を参考にインストールする  

### 環境構築②
https://github.com/RyoYoshida/MyVagrant  
からvagrantファイルをクローン  
クローンはgithub desktopがおすすめ  
https://docs.github.com/ja/desktop/installing-and-configuring-github-desktop/installing-and-authenticating-to-github-desktop/installing-github-desktop

### 環境構築③
コマンド操作  
vagrant up  
10分くらいかかる。逆にかからなかったらどこかおかしいかも  

vagrant reload  
2分くらい。  

起動問題ないかは以下で確認  
①VMBox内のMyVagrant_default_数字の羅列みたいなファイルが起動中になっているか見る  
②vagrant sshで仮想環境内に入れるか　先頭が$みたいなマークが入った画面に切り替われば成功  

### 環境構築④
phpMyAdminでMySQL操作  
ブラウザでlocalhost:8082/phpMyAdminにアクセス (ポートが8082ではないかもなので違ったらVagrantfileのポートを変更)  
ideaedge_dbを作成 (これだけ作成できていれば実行時に自動で必要なカラムを作成してくれます)  
userの作成 (localhostとgatewayどちらも作成 パスワードはideaEdgeで)  

### 環境構築⑤
spring boot内でスタータープロジェクト作成する  
必要パッケージは以下で作成  
spring devtool lombok springdata jpa mysqldriver springsecurity springweb  
gradleプロジェクトの場合はこれにthymeleafも追加  
### 環境構築⑥
https://github.com/OysterSource/ideaEDGE_server_code. 
内のapplication.propertiesを作成したproject内のものにcopy＆paste  
内容はjavaファイル以下に置いてあります  

### 環境構築⑦
spring starter mailも導入。  
https://reasonable-code.com/spring-boot-mail/  
gradleの場合は上の依存関係をbuild.gradleに追加  
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail  
mavenの場合は上の依存関係をpom.xmlに追加  


### 起動
