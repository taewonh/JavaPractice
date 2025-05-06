package com.taewon.practice.webflux.backpressure;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class Example8_4 {

    // LATEST 전략
    public static void main(String[] args) throws InterruptedException {

        /*
        * 버퍼의 데이터가 가득 차고
        * 버퍼 밖에 데이터가 어느정도 채워졌을 때
        * 특정 시점 버퍼밖의 데이터보다 먼저 대기중인
        * 데이터들을 모두 삭제하고
        * 해당 데이터를 포함한 뒤늦게 들어온 데이터들을
        * 버퍼 안으로 밀어넣는 전략
        * */

        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureLatest()
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                    try {
                        Thread.sleep(5L);
                    } catch (InterruptedException e) { }
                    log.info("# onNext: {}", data);
                }, error -> log.error("# onError", error));
        Thread.sleep(2000L);
    }
}
