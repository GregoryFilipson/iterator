import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private Random random;
    private int minValue;
    private final int maxValue;

    public Randoms(int minValue, int maxValue) {
        random = new Random();
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NumberIterator(this);
    }

    protected static class NumberIterator implements Iterator<Integer> {

        protected Randoms rd;

        public NumberIterator(Randoms rd) {
            this.rd = rd;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return rd.random.nextInt((rd.maxValue - rd.minValue) + 1) + rd.minValue;
        }
    }

}