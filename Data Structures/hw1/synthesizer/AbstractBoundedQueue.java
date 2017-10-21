package synthesizer;

/**
 * Created by havinleung on 2017-10-20.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    /**
     * Getter function for capacity
     *
     * @return the maximum number of items in the Bounded Queue
     */
    @Override
    public int capacity() {
        return capacity;
    }

    /**
     * Getter function for fillcount
     *
     * @return the number of items in the Bounded Queue
     */
    @Override
    public int fillCount() {
        return fillCount;
    }
}
