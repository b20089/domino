package oit.is.team10.kaizi.domino.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class DominoAuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    // このクラスの下部にあるPasswordEncoderを利用して，ユーザのビルダ（ログインするユーザを作成するオブジェクト）を作成する
    UserBuilder users = User.builder();

    // UserBuilder usersにユーザ名，パスワード，ロールを指定してbuildする
    // このときパスワードはBCryptでハッシュ化されている．
    // ハッシュ化されたパスワードを得るには，この授業のbashターミナルで下記のように末尾にユーザ名とパスワードを指定すると良い(要VPN)
    // $ sshrun htpasswd -nbBC 10 user1 p@ss
    // ロールを複数追加することもできる
    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER", "MANAGER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();
    UserDetails user3 = users
        .username("user3")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();
    // $ sshrun htpasswd -nbBC 10 customer1 p@ss
    UserDetails user4 = users
        .username("user4")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();
    // $ sshrun htpasswd -nbBC 10 customer2 p@ss
    UserDetails user5 = users
        .username("user5")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();
    // $ sshrun htpasswd -nbBC 10 seller p@ss
    UserDetails user6 = users
        .username("user6")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();
    UserDetails user7 = users
        .username("user7")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();
    UserDetails user8 = users
        .username("user8")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build(); 
    UserDetails user9 = users
        .username("user9")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();  
    UserDetails user10 = users
        .username("user10")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("USER")
        .build();      
    return new InMemoryUserDetailsManager(user1, user2, user3,user4,user5,user6,user7,user8,user9,user10);
  }

  /**
   * 認可処理に関する設定（認証されたユーザがどこにアクセスできるか）
   *
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // Spring Securityのフォームを利用してログインを行う（自前でログインフォームを用意することも可能）
    http.formLogin();
    // http://localhost:8000/sample3 で始まるURLへのアクセスはログインが必要
    // mvcMatchers().authenticated()がmvcMatchersに指定されたアクセス先に認証処理が必要であることを示す
    // authenticated()の代わりにpermitAll()と書くと認証不要となる
    http.authorizeHttpRequests()
        .mvcMatchers("/domino/**").authenticated();
    http.logout().logoutSuccessUrl("/"); // ログアウト時は "http://localhost:8000/" に戻る
    /**
     * 以下2行はh2-consoleを利用するための設定なので，開発が完了したらコメントアウトすることが望ましい
     * CSRFがONになっているとフォームが対応していないためアクセスできない
     * HTTPヘッダのX-Frame-OptionsがDENYになるとiframeでlocalhostでのアプリが使えなくなるので，H2DBのWebクライアントのためだけにdisableにする必要がある
     */
    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  /**
   *
   * UserBuilder users = User.builder();で利用するPasswordEncoderを指定する．
   *
   * @return BCryptPasswordEncoderを返す
   */
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
