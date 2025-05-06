package com.taewon.practice.webflux.backpressure;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class Example8_2 {

    // Backpressure ERROR 전략
    public static void main(String[] args) throws InterruptedException {

        /*
        * Publisher 가 데이터를 emit 하는 속도 (1L) 보다
        * Subscriber 가 데이터를 처리하는 속도 (5L) 가 느려서
        * Backpressure 오류가 발생
        * */
        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureError()  // Backpressure Error 전략 적용
                .doOnNext(data -> log.info("# doOnNext: {}", data))
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
