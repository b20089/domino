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

import oit.is.team10.kaizi.domino.model.Room;
import oit.is.team10.kaizi.domino.model.RoomMapper;
import oit.is.team10.kaizi.domino.model.Users;
import oit.is.team10.kaizi.domino.model.UsersMapper;

@Controller
public class dominoController {

  @Autowired
  RoomMapper roomMapper;

  @Autowired
  UsersMapper userMapper;

  @GetMapping("/domino")
  public String sample21(ModelMap model) {
    Users user = new Users();
    userMapper.insertUser(user);
    model.addAttribute("user1", user);
    return "domino.html";
  }

  @GetMapping("/no1")
  public String no1(@RequestParam Integer id, @RequestParam Integer roomid, ModelMap model) {
    Room room = new Room();
    Users user = new Users();
    user = userMapper.selectById(id);
    room = roomMapper.selectById(roomid);
    int count = userMapper.countUsers(user);
    userMapper.updateById(room, user);
    model.addAttribute("user", user);
    model.addAttribute("room", room);
    model.addAttribute("count", count);
    return "game.html";
  }

  @GetMapping("/no2")
  public String no2() {
    return "game.html";
  }

  @GetMapping("/no3")
  public String no3() {
    return "game.html";
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
    int count = userMapper.countUsers(user);
    Users player = new Users();
    player = userMapper.selectById(userid);
    model.addAttribute("room", room);
    model.addAttribute("user", user);
    model.addAttribute("count", count);
    model.addAttribute("player", player);
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
    int count = userMapper.countUsers(user);
    model.addAttribute("room", room);
    model.addAttribute("user", user);
    model.addAttribute("count", count);
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
