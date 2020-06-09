public class MyThreadImageProducer implements Runnable {

    // [Attributes]
    private String threadName;
    private Thread t;
    private String imgLink;
    private int i;
    private int j;
    private Buffer buffer;
    // [Attributes]

    // [Constructor]
    public MyThreadImageProducer(String threadName, String imgLink, int i, int j, Buffer buffer) {
        this.threadName = threadName;
        this.imgLink = imgLink;
        this.t = new Thread(this, threadName);
        this.i = i;
        this.j = j;
        this.buffer = buffer;
        System.out.println("New: " + t);
        t.start();
    }
    // [Constructor]

    // [Thread Body]
    public void run() {
        try {
            buffer.produce(imgLink, j);     // [Calls the Producer to Add Link to the Buffer]
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // [Thread Body]
}
