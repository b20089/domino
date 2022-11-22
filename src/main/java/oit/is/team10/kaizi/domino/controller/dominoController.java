package oit.is.team10.kaizi.domino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

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
    int count = userMapper.countusers(user);
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
  public String dominoSet() {
    return "game.html";
  }

  @GetMapping("/dominoKnock")
  public String dominoKnock() {
    return "game.html";
  }

}
