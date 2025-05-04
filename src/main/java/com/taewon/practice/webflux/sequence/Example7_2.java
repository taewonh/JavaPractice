package com.taewon.practice.webflux.sequence;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Example7_2 {

    /*
    * Hot Sequence 예제
    * - subscriber 시 처음부터 데이터를 emit 하는 것이 아니라
    *   데이터를 구독하고 있는 subscriber 에게 동일하게 데이터를 emit 한다.
    * */
    public static void main(String[] args) throws InterruptedException {

        String[] singers = {
                "Singer A", "Singer B", "Singer C", "Singer D", "Singer E"
        };

        log.info("# Begin concert:");

        Flux<String> concertFlux = Flux.fromArray(singers)
                .delayElements(Duration.ofSeconds(1))   // 데이터의 emit 을 1초씩 지연시킨다.
                .share();   // Cold Sequence 를 Hot Sequence 로 동작하게 해준다.
        /*
        * Reactor API 공식 문서에서 설명하는 share
        *
        * 이 Flux는 여러 구독자에게 데이터를 공유합니다.
        * 최소한 하나의 구독자가 있을 때만 동작하며,
        * 구독자가 모두 떠나면 데이터 발생도 멈춥니다.
        *
        * 즉 첫 번째 구독자 이후 데이터가 emit 중인 상황에서
        * 다른 구독자들이 연결되면 첫 번째 구독자가 받고 있는 데이터를
        * 동일하게 받는다.
        * */

        /*
        * 비슷하게 cache 라는 것이 있음
        *
        * 최근 방출된 데이터를 미리 메모리에 저장해두고
        * 이후 연결된 구독자들에게 캐싱된 데이터를 처음부터 내려준다.
        * 메모리를 많이 사용할 수 있으므로 사용에 주의해야 한다.
        * */

        concertFlux.subscribe(singer -> {
            log.info("# Subscriber1 is watching {}'s song", singer);
        });
        Thread.sleep(2500);
        concertFlux.subscribe(singer -> {
            log.info("# Subscriber2 is watching {}'s song", singer);
        });
        Thread.sleep(3000);
    }
}
