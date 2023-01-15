# DominoGame
## セットアップマニュアル + ユーザーマニュアル
---
本プログラムはisdev22-byodで実行でき、ブラウザ上で動作します。isdev22-byodの推奨バージョンはisdev-bash-2.35.2-64であり、それ以外では動作の保証がされません。(動作が保証されているブラウザ Chome,Opera,FireFox)
最終更新日23/01/13

---

## セットアップマニュアル
**※必ずお読みください**

## Server編

### サーバに接続する
学内VPNに接続し、isdev22-byodを起動して以下のコマンドを実行します

`
$ ssh isdev22@150.89.233.210
`

パスワードを聞かれるので、`isDev22?210`と入力します。

`
isdev22@ubuntu210:~$
`

と表示されていれば接続成功です。

### Javaのインストール

次にJavaのインストールを行います。

> **Note**
> 
> コンソールに java と入力したときにコマンドの一覧が表示された場合は既にインストールされているので以下の手順は不要です。
> 

次の3つのコマンドを実行します。

`
$ wget -O- https://apt.corretto.aws/corretto.key | sudo apt-key add -
`
`
$ sudo add-apt-repository 'deb https://apt.corretto.aws stable main'
`
`
$ sudo apt-get update; sudo apt-get install -y java-11-amazon-corretto-jdk
`

3つのコマンドを実行し終えたら、正しくインストールされていることを確認するため以下のコマンドを実行します。

`
$ java -version
`

実行結果が以下のようになっていたらJavaのインストールは成功です。
`
isdev22@ubuntu210:~$ java -version
openjdk version "11.0.17" 2022-10-18 LTS
OpenJDK Runtime Environment Corretto-11.0.17.8.1 (build 11.0.17+8-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.17.8.1 (build 11.0.17+8-LTS, mixed mode)
`

### DominoGameのダウンロード

次に本プログラムをダウンロードします。
`cd ~ `を実行し、ホームディレクトリ上で以下のコマンドを実行します。

`
$ git clone https://github.com/b20089/domino.git
`

lsコマンドを実行し、dominoという名前のフォルダがあることを確認してください。

確認できたらcdコマンドでdominoをカレントディレクトリにします

`
$ cd domino
`

GradlewをBashを利用して実行します

`
$ bash ./gradlew
`

以下のコマンドでプロジェクトを実行します

`
$ bash ./gradlew bootrun
`

実行後、ブラウザで以下のURLを参照します。画面に`dominoへのGETをリクエスト(認証付き)`と表示されていれば成功です。

### [http://150.89.233.210](http://150.89.233.210)

## PC編

### DominoGameのダウンロード
本プログラムをGitHubよりZip形式でダウンロードし、解凍します。
`
画面右上「<>Code▼」から「Download ZIP」を選択、ダウンロードした物を解凍する。
`

解凍されたフォルダを好きな場所に配置します。

### DominoGameの実行

isdev22-byodを起動し、cdコマンドを使って解凍されたフォルダまで移動します。移動後、pwdコマンド・lsコマンドを実行して以下のように表示されることを確認してください。

`
$ pwd
/***/domino-main/domino-main
`

> **Note**
> 
> ※***の部分は個人の環境によって変わります。
> 


`
$ ls
build.gradle  gradle/  gradlew*  gradlew.bat  settings.gradle  src/
`

### DominoGameの起動

ゲームを起動するため、以下のコマンドを実行します。

`
$ gradle bootrun
`

コンソールに`<==========---> 80% EXECUTING`と表示されたら起動完了です。以下のURLにアクセスして画面に`dominoへのGETをリクエスト(認証付き)`と表示されることを確認してください。

### [localhost](http://localhost)
