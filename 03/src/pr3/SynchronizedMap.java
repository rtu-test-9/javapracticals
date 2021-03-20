package pr3;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SynchronizedMap <K, V> implements Map <K, V>{
    
    private HashMap<K, V> data = new HashMap<K, V>();
    private static final Semaphore semaphore = new Semaphore(1);
    @Override
    public void clear() {
        try{
            semaphore.acquire();
            data.clear();
            semaphore.release();
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public boolean containsKey(Object arg0) {
        try{
            semaphore.acquire();
            boolean temp = data.containsKey(arg0);
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean containsValue(Object arg0) {
        boolean temp;
        try{
            semaphore.acquire();
            temp = data.containsValue(arg0);
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry <K, V>> temp;
        try{
            semaphore.acquire();
            temp = data.entrySet();
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return null;
        }    }

    @Override
    public V get(Object arg0) {
        V temp;
        try{
            semaphore.acquire();
            temp = data.get(arg0);
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean temp;
        try{
            semaphore.acquire();
            temp = data.isEmpty();
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> temp;
        try{
            semaphore.acquire();
            temp = data.keySet();
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public V put(K arg0, V arg1) {
        V temp;
        try{
            semaphore.acquire();
            temp = data.put(arg0, arg1);
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        try{
            semaphore.acquire();
            data.containsValue(arg0);
            semaphore.release();
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
        }
        
    }

    @Override
    public V remove(Object arg0) {
        V temp;
        try{
            semaphore.acquire();
            temp = data.remove(arg0);
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return null;
        }        
    }

    @Override
    public int size() {
        int temp;
        try{
            semaphore.acquire();
            temp = data.size();
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return 0;
        }
    }

    @Override
    public Collection<V> values() {
        Collection<V> temp;
        try{
            semaphore.acquire();
            temp = data.values();
            semaphore.release();
            return temp;
        }
        catch (InterruptedException exception){
            exception.printStackTrace();
            return null;
        }
    }

    
}
