# DominoGame
## セットアップマニュアル + ユーザマニュアル
---

最終更新日23/01/16

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

---

## ユーザーマニュアル
**※必ずお読みください**

###ログインする

DominoGameにアクセスし、画面の`dominoへのGETをリクエスト(認証付き)`をクリックしてください。
ログイン画面が表示されるので、ユーザ名とパスワードを入力します。
ユーザ名とパスワードは以下の通りです。

| ユーザ名 | パスワード |
| --- | --- |
| user1 | p@ss |
| user2 | p@ss |
| user3 | p@ss |
| user4 | p@ss |
| user5 | p@ss |
| user6 | p@ss |
| user7 | p@ss | 
| user8 | p@ss |
| user9 | p@ss |
| user10 | p@ss |

### 部屋を選ぶ

ログインが成功するとタイトル画面に移行します。画面下部からNo.1からNo.3までのいずれかの部屋のURLにアクセスします。
No.1からNo.3までの部屋は別々の存在であり、入室しているユーザ、設置されているドミノの数が独立しています。

### ゲーム画面の説明

部屋を選択するとゲーム画面に移行します。画面左上`もどる`をクリックすると、タイトル画面に戻ります。
`もどる`の下に、あなたの居る部屋の番号が表示されています。
部屋の番号の下には、あなたのID・部屋にいる人数が表示されています。
部屋にいる人数の下には各部屋に設置されているドミノの数が表示されています。
RoomNo.3のドミノの数の下には`ドミノを設置`ボタンが用意されています。このボタンについては次項に詳しく解説します。
ドミノを設置ボタンの下には`ドミノを倒す`ボタンが用意されています。このボタンについては次項で詳しく解説します。
ドミノを倒すボタンの下には現在のドミノの数を表す画像が表示されています。

### ドミノを設置する

ドミノを設置するボタンを押すと、ドミノが部屋にドミノが一枚追加されます。
ドミノの数は部屋内で共有されているため、同じ部屋内にいる全てのユーザに影響します。
ドミノの数は10秒ごとに自動で更新され、またドミノを設置した際にも更新されます。

### ドミノを倒す

ドミノを倒すボタンを押すと、部屋のドミノが倒れます。
ドミノが倒れていく様子はドミノを倒した本人にしか確認できません。
`ドミノを倒す`はクリックされると`満足した`に変化します。
満足したをクリックすることで、部屋内のドミノの数は0になり、ドミノを置き直すことができるようになります。
ドミノの数は部屋内で共有されているため、同じ部屋内にいる全てのユーザに影響します。
> **Note**
> 
> 協力し合って設置したドミノが倒れていく様子を確認できるのは、倒した本人のみです。
> ドミノを倒す快感、倒れていく爽快感、仲間を裏切る罪悪感をじっくり味わいください
> 