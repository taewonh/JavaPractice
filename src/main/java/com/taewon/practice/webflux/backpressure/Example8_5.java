package com.taewon.practice.webflux.backpressure;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class Example8_5 {

    // DROP_LATEST 전략
    public static void main(String[] args) throws InterruptedException {

        /*
        * 지정한 버퍼 사이즈를 초과한 경우
        * BUFFER_OVERFLOW 를 일으킨 아이템을 DROP 시킴
        * (즉 가장 나중에 들어온 아이템)
        *
        * DROP_OLDEST 라고 해서 가장 먼저 들어온 녀석부터
        * 제거하는 기법도 있으니 참고할 것
        * */
        Flux.interval(Duration.ofMillis(300L))
                .doOnNext(data -> {
                    log.info("# emitted by original Flux: {}", data);
                }).onBackpressureBuffer(2,
                        dropped -> log.info("** Overflow & Dropped: {} **", dropped),
                        BufferOverflowStrategy.DROP_LATEST)
                .doOnNext(data -> log.info("[ # emitted by Buffer: {} ]", data))
                .publishOn(Schedulers.parallel(), false, 1)
                .subscribe(data -> {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {}
                    log.info("# onNext: {}", data);
                }, error -> log.error("# onError", error));

        Thread.sleep(3000L);
    }
}
