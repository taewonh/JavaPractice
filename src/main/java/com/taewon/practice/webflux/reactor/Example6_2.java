package com.taewon.practice.webflux.reactor;

import reactor.core.publisher.Mono;

public class Example6_2 {

    public static void main(String[] args) {

        Mono.empty()
                .subscribe(
                        none -> System.out.println("# emitted onNext signal"),
                        error -> {},
                        () -> System.out.println("# emitted onComplete signal")
                );
        /*
        * 아무 신호도 주지 않기 때문에 onComplete signal 메시지만 출력한다.
        *
        * 이처럼 데이터를 한 건도 emit 하지 않는 empty() Operator는 주로
        * 어떤 특정 작업을 통해 데이터를 전달받을 필요는 없지만
        * 작업이 끝났음을 알리고 이에 따른 후처리를 하고 싶을 때 사용한다.
        * */
    }
}
