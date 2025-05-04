package com.taewon.practice.webflux.backpressure;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class Example8_1 {

    public static void main(String[] args) {

        Flux.range(1, 5)
                .doOnRequest(data -> {
                    // subscriber 가 request 를 통해 데이터를 요청한 개수를 로깅함 (무조건 1)
                    log.info("# doOnRequest: {}", data);
                }).subscribe(new BaseSubscriber<Integer>() {

                    @SneakyThrows
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @SneakyThrows
                    @Override
                    protected void hookOnNext(Integer value) {
                        Thread.sleep(2000L);
                        log.info("# hookOnNext: {}", value);
                        request(1);
                    }
                });
    }
}
