import java.util.LinkedList;

public class Buffer {
    // [Attributes]
    private boolean available;
    private LinkedList<String> list;
    private int capacity;
    private String removed;
    private MySemaphore semaphore;
    // [Attributes]

    // [Constructor]
    public Buffer() {
        this.list = new LinkedList<String>();
        this.capacity = 2;
        this.semaphore = new MySemaphore();
    }
    // [Constructor]

    //[Producer]
    public void produce(String imgLink, int imgNum) throws InterruptedException
    {
        //while (true) {
            synchronized (this)
            {

                // [Producer Thread Waits While List
                // is Full]
                while (list.size() == capacity){
                    System.out.println("Producer Waiting...");
                    wait();
                }
                System.out.println("Producer Ready!");

                // [Insert Links in The List]
                list.add(imgLink);

                //System.out.println("valor de j="+imgNum);
                System.out.println("Image " + imgNum + " added.");

                // [Notifies The Consumer Thread That
                // Now it Can Start Consuming]
                notify();

                // [Makes The Working of Program Easier
                // to  Understand]
                Thread.sleep(1000);
            }
        //}
    }
    //[Producer]

    // [Consumer]
      public void consume(int i) throws InterruptedException
    {
        while (true) {
            synchronized (this)
            {
                // [Consumer Thread Waits While List
                // is Empty]
                while (list.size() == 0){
                    System.out.println("Consumer Waiting...");
                    wait();
                    i++;
                }
                System.out.println("Consumer Ready!");

                // [Retrieve the First Link in The List]
                this.removed = list.removeFirst();
                new ImageDownloader("Download Image " + i, i, this, removed);
                i++;
                System.out.println(removed);

                // [Wake Up Producer Thread]
                notify();

                // [Sleep]
                Thread.sleep(1000);
            }

        }
    }
    // [Consumer]


    public LinkedList<String> getList() {
        return this.list;
    }

    public String getRemoved() {
        return removed;
    }
}