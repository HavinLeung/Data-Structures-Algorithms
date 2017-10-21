import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

public class TestArrayDeque1B {
    @Test
    public void test() {
        ArrayDequeSolution<Integer> d1 = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> d2 = new StudentArrayDeque<>();
        Random rand = new Random();
        OperationSequence f = new OperationSequence();
        while (true) {
            for (int i = 0; i < 100; i++) {
                int a = rand.nextInt();
                int b = rand.nextInt();
                f.addOperation(new DequeOperation("isEmpty"));
                assertEquals(f.toString(), d1.isEmpty(), d2.isEmpty());
                f.addOperation(new DequeOperation("addLast", a));
                d1.addLast(a);
                d2.addLast(a);
                f.addOperation(new DequeOperation("addLast", b));
                d1.addFirst(b);
                d2.addFirst(b);
            }
            for (int i = 0; i < 20; i++) {
                f.addOperation(new DequeOperation("removeFirst"));
                assertEquals(f.toString(), d1.removeFirst(), d2.removeFirst());
                f.addOperation(new DequeOperation("removeLast"));
                assertEquals(f.toString(), d1.removeLast(), d2.removeLast());
                f.addOperation(new DequeOperation("size"));
                assertEquals(f.toString(), d1.size(), d2.size());
                f.addOperation(new DequeOperation("isEmpty"));
                assertEquals(f.toString(), d1.isEmpty(), d2.isEmpty());
            }
            for (int i = 0; i < 20; i++) {
                f.addOperation(new DequeOperation("removeFirst"));
                assertEquals(f.toString(), d1.removeFirst(), d2.removeFirst());
                int c = rand.nextInt(d1.size());
                f.addOperation(new DequeOperation("get", c));
                assertEquals(f.toString(), d1.get(c), d2.get(c));
                f.addOperation(new DequeOperation("size"));
                assertEquals(f.toString(), d1.size(), d2.size());
                f.addOperation(new DequeOperation("isEmpty"));
                assertEquals(f.toString(), d1.isEmpty(), d2.isEmpty());
            }
            for (int i = 0; i < 20; i++) {
                f.addOperation(new DequeOperation("removeLast"));
                assertEquals(f.toString(), d1.removeLast(), d2.removeLast());
                int c = rand.nextInt(d1.size());
                f.addOperation(new DequeOperation("get", c));
                assertEquals(f.toString(), d1.get(c), d2.get(c));
                f.addOperation(new DequeOperation("size"));
                assertEquals(f.toString(), d1.size(), d2.size());
                f.addOperation(new DequeOperation("isEmpty"));
                assertEquals(f.toString(), d1.isEmpty(), d2.isEmpty());
            }

        }
    }
}
