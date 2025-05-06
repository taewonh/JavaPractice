package com.taewon.practice.webflux.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;

import java.util.stream.IntStream;

@Slf4j
public class Example9_2 {

    /*
    * Sinks 를 사용하는 이유
    *
    * 기본적으로 Reactive Streams 에서 Subscriber 가 존재하지 않으면
    * subscribe 할 수 있는 객체가 없으므로 아무 일도 일어나지 않는다.
    *
    * Sinks를 사용하면 Subscriber의 요구가 없더라도
    * Publisher에서 데이터를 emit하고 signal을 프로그래밍적으로 보낼 수 있다.
    * */
    public static void main(String[] args) throws InterruptedException {

        int tasks = 6;

        Sinks.Many<String> unicastSink = Sinks.many().unicast().onBackpressureBuffer();
        Flux<String> fluxView = unicastSink.asFlux();
        IntStream.range(1, tasks)
                .forEach(n -> {
                    try {
                        new Thread(() -> {
                            unicastSink.emitNext(doTask(n), Sinks.EmitFailureHandler.FAIL_FAST);
                            log.info("# emitted: {}", n);
                        }).start();
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                });

        fluxView.publishOn(Schedulers.parallel())
                .map(result -> result + " success!")
                .doOnNext(n -> log.info("# map(): {}", n))
                .publishOn(Schedulers.parallel())
                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(200L);
    }

    private static String doTask(int taskNumber) {

        return "task " + taskNumber + " result";
    }
}
