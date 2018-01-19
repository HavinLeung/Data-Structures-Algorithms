import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by havinleung on 2018-01-08.
 */
public class Test {
    public static void main(String[] args) {
        MyBST<Integer> T = new MyBST<>();
        Set<Integer> S = new TreeSet<>();
        T.add(10);
        S.add(10);
        T.remove(50);
        S.remove(50);
        Random random = new Random();
        int s = 0;
        for (int i = 0; i < 100 ; i++){
            for (int j = 0; j < 2; j++){
                s = random.nextInt(20);
                T.add(s);
                S.add(s);
            }
            s = random.nextInt(20);
            S.remove(s);
            T.remove(s);
            for (int j = 0; j < 5; j++){
                s = random.nextInt(20);
                if (T.contains(s) != S.contains(s)) {
                    throw new RuntimeException("Doesn't match");
                }
            }
        }
    }
}
