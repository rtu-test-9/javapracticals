package pr3;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SynchronizedList <Type> implements List<Type>{
    private ArrayList<Type> data = new ArrayList<Type>();
    private static final Lock lock = new ReentrantLock();

    @Override
    public boolean add(Type arg0) {
        lock.lock();
        boolean temp = data.add(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public void add(int arg0, Type arg1) {
        lock.lock();
        data.add(arg0, arg1);
        lock.unlock();
    }

    @Override
    public boolean addAll(Collection<? extends Type> arg0) {
        lock.lock();
        boolean temp =  data.addAll(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends Type> arg1) {
        lock.lock();
        boolean temp = data.addAll(arg0, arg1);
        lock.unlock();
        return temp;
    }

    @Override
    public void clear() {
        lock.lock();
        data.clear();
        lock.unlock();
    }

    @Override
    public boolean contains(Object arg0) {
        lock.unlock();
        boolean temp = data.contains(arg0);
        lock.lock();
        return temp;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        lock.lock();
        boolean temp = data.containsAll(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public Type get(int arg0) {
        lock.lock();
        Type temp = data.get(arg0);
        lock.unlock();
        return temp;
    }
    
    @Override
    public int indexOf(Object arg0) {
        lock.lock();
        int temp = data.indexOf(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean temp = data.isEmpty();
        lock.unlock();
        return temp;
    }

    @Override
    public Iterator<Type> iterator() {
        lock.lock();
        Iterator <Type> temp = data.iterator();
        lock.unlock();
        return temp;
    }

    @Override
    public int lastIndexOf(Object arg0) {
        lock.lock();
        int temp = data.lastIndexOf(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public ListIterator<Type> listIterator() {
        lock.lock();
        ListIterator<Type> temp = data.listIterator();
        lock.unlock();
        return temp;
    }

    @Override
    public ListIterator<Type> listIterator(int arg0) {
        lock.lock();
        ListIterator<Type> temp = data.listIterator(arg0);;
        lock.unlock();
        return temp;
    }

    @Override
    public boolean remove(Object arg0) {
        lock.lock();
        boolean temp = data.remove(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public Type remove(int arg0) {
        lock.lock();
        Type temp = data.remove(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        lock.lock();
        boolean temp = data.removeAll(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        lock.lock();
        boolean temp = data.retainAll(arg0);
        lock.unlock();
        return temp;
    }

    @Override
    public Type set(int arg0, Type arg1) {
        lock.lock();
        Type temp = data.set(arg0, arg1);
        lock.unlock();
        return temp;
    }

    @Override
    public int size() {
        lock.lock();
        int temp = data.size();
        lock.unlock();
        return temp;
    }

    @Override
    public List<Type> subList(int arg0, int arg1) {
        lock.lock();
        List <Type> temp =  data.subList(arg0, arg1);
        lock.unlock();
        return temp;
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        Object[] temp = data.toArray();
        lock.unlock();
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        lock.lock();
        T[] temp =  data.toArray(arg0);
        lock.unlock();
        return temp;
    }
}