package oit.is.team10.kaizi.domino.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.team10.kaizi.domino.model.Room;
import oit.is.team10.kaizi.domino.model.RoomMapper;

@Service
public class AsyncDomino {

  private final Logger logger = LoggerFactory.getLogger(AsyncDomino.class);

  int counter = 0;

  @Autowired
  RoomMapper roomMapper;

  @Async
  public void count(SseEmitter emitter) throws IOException {
    logger.info("AsyncDomino.count");
    Room room[] = new Room[3];
    room[0] = roomMapper.selectById(1);
    room[1] = roomMapper.selectById(2);
    room[2] = roomMapper.selectById(3);
    try {
      while (true) {
        logger.info("send" + counter);
        // CUSTOMERとSELLERでカウンタを分ける
        // この2つ以外のロール場合は常にcounter=0

        // ロールごとのカウンタとロール名を送る
        emitter.send(room);
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
