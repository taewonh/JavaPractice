package com.taewon.practice.webflux.backpressure;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class Example8_3 {

    // Backpressure DROP 전략
    public static void main(String[] args) throws InterruptedException {

        /*
        * 데이터를 방출하는 속도보다
        * 데이터를 처리하는 속도가 느려
        * 버퍼가 수용할 수 있는 데이터 수를 초과해버리면
        * 버퍼에 들어가지 못한 데이터를 DROP 한다.
        * */
        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureDrop(dropped -> log.info("# dropped: {}", dropped))
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
