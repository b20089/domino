package oit.is.team10.kaizi.domino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.team10.kaizi.domino.model.Room;
import oit.is.team10.kaizi.domino.model.RoomMapper;
import oit.is.team10.kaizi.domino.model.Users;
import oit.is.team10.kaizi.domino.model.UsersMapper;
import oit.is.team10.kaizi.domino.service.AsyncDomino;

@Controller
public class dominoController {
  @Autowired
  RoomMapper roomMapper;

  @Autowired
  UsersMapper userMapper;

  @Autowired
  private AsyncDomino ac56;

  @GetMapping("/domino")
  public String sample21(ModelMap model) {
    Users user = new Users();
    userMapper.insertUser(user);
    model.addAttribute("user1", user);
    return "domino.html";
  }

  @GetMapping("/room")
  public String room(@RequestParam Integer id, @RequestParam Integer roomid, ModelMap model) {
    Room room = new Room();
    Users user = new Users();
    user = userMapper.selectById(id);
    room = roomMapper.selectById(roomid);
    userMapper.updateById(room, user);
    model.addAttribute("user", user);
    model.addAttribute("room", room);
    int count = userMapper.countUsers(user, roomid);
    model.addAttribute("count", count);
    model.addAttribute("alertString2", id);
    return "game.html";
  }

  private final Logger logger = LoggerFactory.getLogger(dominoController.class);

  @GetMapping("/intoRoom")
  public SseEmitter pushCount(@RequestParam int test) {
    // infoレベルでログを出力する
    logger.info("pushCount");

    // finalは初期化したあとに再代入が行われない変数につける（意図しない再代入を防ぐ）
    final SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);//
    // 引数にLongの最大値をTimeoutとして指定する

    try {
      this.ac56.count(emitter, test);
    } catch (IOException e) {
      // 例外の名前とメッセージだけ表示する
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
      emitter.complete();
    }
    return emitter;
  }

  @GetMapping("/dominoSet")
  public String dominoSet(@RequestParam Integer id, @RequestParam Integer userid, ModelMap model) {
    int dominos = roomMapper.selectDominoById(id);
    dominos++;
    roomMapper.updateByDominos(dominos, id);
    Room room = new Room();
    room = roomMapper.selectById(id);
    Users user = new Users();
    user = userMapper.selectById(userid);
    int count = userMapper.countUsers(user, id);
    Users player = new Users();
    player = userMapper.selectById(userid);
    model.addAttribute("room", room);
    model.addAttribute("user", user);
    model.addAttribute("count", count);
    model.addAttribute("player", player);
    model.addAttribute("alertString2", id);

    return "game.html";
  }

  @GetMapping("/dominoKnock")
  public String dominoKnock(@RequestParam Integer id, @RequestParam Integer userid, ModelMap model) {
    int dominos = 0;
    roomMapper.updateByDominos(dominos, id);
    Room room = new Room();
    room = roomMapper.selectById(id);
    Users user = new Users();
    user = userMapper.selectById(userid);
    int count = userMapper.countUsers(user, id);
    model.addAttribute("room", room);
    model.addAttribute("user", user);
    model.addAttribute("count", count);
    model.addAttribute("alertString2", id);

    return "game.html";
  }

  @GetMapping("/back")
  public String back(@RequestParam Integer userid, ModelMap model) {
    Users user1 = new Users();

    user1 = userMapper.selectById(userid);
    userMapper.updateZeroById(user1, 0);

    model.addAttribute("user1", user1);

    return "domino.html";
  }

}
