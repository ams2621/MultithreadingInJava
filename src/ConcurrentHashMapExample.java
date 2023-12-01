import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapFirstWorker implements Runnable
{
private ConcurrentMap<String,Integer> map;

public MapFirstWorker(ConcurrentMap<String,Integer> map)
{
    this.map = map;
}
    @Override
    public void run() {
        try {
            map.put("A",899);
            Thread.sleep(1000);
            map.put("B",891);
            map.put("Z",893);
            map.put("X",895);
            Thread.sleep(1000);
            map.put("D",890);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MapSecondWorker implements Runnable
{
    private ConcurrentMap<String,Integer> map;

    public MapSecondWorker(ConcurrentMap<String,Integer> map)
    {
        this.map = map;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("B"));
            System.out.println(map.get("Z"));
            System.out.println(map.get("D"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String,Integer> map = new ConcurrentHashMap<>(); // synchronization is done automatically
        MapFirstWorker firstWorker = new MapFirstWorker(map);
        MapSecondWorker secondWorker = new MapSecondWorker(map);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
