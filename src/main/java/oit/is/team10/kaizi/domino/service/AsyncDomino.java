package oit.is.team10.kaizi.domino.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class AsyncDomino {

  private final Logger logger = LoggerFactory.getLogger(AsyncDomino.class);

  int counter = 0;
  @Async
  public void count(SseEmitter emitter) throws IOException {
    logger.info("AsyncDomino.count");
    try {
      while (true) {
        logger.info("send" + counter);
        // CUSTOMERとSELLERでカウンタを分ける
        // この2つ以外のロール場合は常にcounter=0
        counter++;
        // ロールごとのカウンタとロール名を送る
        emitter.send(counter);
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
