import java.util.LinkedList;

public class Buffer {

//    private String content;
    private boolean available;
    private LinkedList<String> list;

    public Buffer() {
        this.list = new LinkedList<String>();
    }

    public synchronized void set(int producerId, String value) {
        while (available == true) {
            try {
                System.out.println("Producer #" + producerId + " waiting...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        content = value;
        this.list.add(value);                       // add to the buffer
        System.out.println("Producer #" + producerId + " added " + value);
        available = true;
        notifyAll();
    }

    public synchronized String get(int consumerId, String content) {
        while (available == false) {
            try {
                System.out.println("Consumer #" + consumerId
                        + " waiting...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.remove(content);               // remove from the buffer
        System.out.println("Consumer #" + consumerId + " consumed: "
                + content);

        available = false;
        notifyAll();
        return content;
    }

    public LinkedList<String> getList() {
        return this.list;
    }
}