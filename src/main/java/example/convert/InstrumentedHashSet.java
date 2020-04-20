package example.convert;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

public class InstrumentedHashSet<E> implements Set<E> {
    private int addCount = 0;
    private Set<E> set;

    public InstrumentedHashSet(Set<E> set) {
        this.set = set;
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }
    @Override
    public void clear() {
        set.clear();
    }
    @Override
    public boolean equals(Object obj) {
        return set.equals(obj);
    }
    @Override
    public int hashCode() {
        return set.hashCode();
    }
    @Override
    public Spliterator<E> spliterator() {
        return set.spliterator();
    }
    @Override
    public int size() {
        return set.size();
    }
    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }
    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }
}
