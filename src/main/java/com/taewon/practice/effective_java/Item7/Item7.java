package com.taewon.practice.effective_java.Item7;

import java.util.Map;
import java.util.WeakHashMap;

/*
 * 객체 생성과 파괴
 * Item7. 다 쓴 객체 참조를 해제하라.
 * */
public class Item7 {

    private Stack stack;

    public Item7() {
        stack = new Stack();
    }

    public static void main(String[] args) {
        Item7 item7 = new Item7();
        // 10번 push
        item7.stack.push(1);
        item7.stack.push(2);
        item7.stack.push(3);
        item7.stack.push(4);
        item7.stack.push(5);
        item7.stack.push(6);
        item7.stack.push(7);
        item7.stack.push(8);
        item7.stack.push(9);

        // 5번 pop
        /*
         * Stack 내부를 보면 pop시 인덱스로 사용되는 size만 줄여주고
         * 실제 배열 크기는 줄이거나 null 처리하지 않는다.
         * */
        item7.stack.pop();
        item7.stack.pop();
        item7.stack.pop();
        item7.stack.pop();

        item7.testWeakHashMap();
    }

    private void testWeakHashMap() {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer key1 = 1000;
        Integer key2 = 2000;
        map.put(key1, "test a");
        map.put(key2, "test b");
        key1 = null;
        System.gc();  //강제 Garbage Collection
        System.out.println("Expected map size: [1], real: [" + map.size() + "]");
    }
}
