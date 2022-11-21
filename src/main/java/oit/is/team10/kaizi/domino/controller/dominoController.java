package oit.is.team10.kaizi.domino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import oit.is.team10.kaizi.domino.model.RoomMapper;
import oit.is.team10.kaizi.domino.model.UserMapper;

@Controller
public class dominoController {

  @Autowired
  RoomMapper roomMapper;

  @Autowired
  UserMapper userMapper;

  @GetMapping("/domino")
  public String sample21() {
    return "domino.html";
  }

  @GetMapping("/no1")
  public String no1() {
    
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
