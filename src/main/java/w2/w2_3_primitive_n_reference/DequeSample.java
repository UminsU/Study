package w2.w2_3_primitive_n_reference;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeSample {
    public static void main(String[] args) {
        Deque<Integer> intDeque1 = new ArrayDeque<>(10);
        for (int i=0; i<10; i++) {
            // intDeque1.add(i);
            intDeque1.addLast(i);
        }
        System.out.println("remove first <- " + intDeque1 + " <- add last");

        for (int i=0; i<10; i++) {
            System.out.println(intDeque1.removeFirst());
        }

        Deque<Integer> intDeque2 = new ArrayDeque<>(10);
        for (int i=0; i<10; i++) {
            intDeque2.addFirst(i);
        }
        System.out.println("add first -> " + intDeque2 + " -> remove last");

        for (int i=0; i<10; i++) {
            System.out.println(intDeque2.removeLast());
        }
    }
}