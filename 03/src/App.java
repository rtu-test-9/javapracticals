import pr3.SynchronizedList;
import pr3.SynchronizedMap;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;

/*
    variant #9
*/

public class App {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedList <Integer> list = new SynchronizedList<Integer>();
        ArrayList<Integer> not_synchronized_list = new ArrayList<Integer>();
        SynchronizedMap <Integer, String> map = new SynchronizedMap<Integer, String>();

        Runnable list_task0 = () -> {
            for (int i = 0; i < 10; i++)
            {
                list.add(i);
                not_synchronized_list.add(i);
            }
        };
        Runnable list_task1 = () -> {
            for (int i = 0; i < 10; i++)
            {
                list.add(i + 10);
                not_synchronized_list.add(i+10);
            }
        };

        Runnable map_task0 = () -> {
            for (int i = 0; i < 10; i++){
                map.put(i, Integer.toString(i));
            }
        };
        Runnable map_task1 = () -> {
            for (int i = 0; i < 10; i++){
                map.put(i + 10, Integer.toString(i + 10));
            }
        };
        
        Thread list_thread0 = new Thread(list_task0);
        Thread list_thread1 = new Thread(list_task1);

        Thread map_thread0 = new Thread(map_task0);
        Thread map_thread1 = new Thread(map_task1);

        list_thread0.start();
        list_thread1.start();

        map_thread0.start();
        map_thread1.start();

        Thread.sleep(2000);
        Iterator <Integer> synch_iterator = list.iterator();
        Iterator <Integer> iterator = not_synchronized_list.iterator();
        
        while (synch_iterator.hasNext()){
            System.out.println(synch_iterator.next());
        }
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}