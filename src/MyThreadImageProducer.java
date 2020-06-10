public class MyThreadImageProducer implements Runnable {

    // [Attributes]
    private Thread t;
    private String imgLink;
    private int j;
    private Buffer buffer;
    // [Attributes]

    // [Constructor]
    public MyThreadImageProducer(String threadName, String imgLink, int j, Buffer buffer) {
        this.imgLink = imgLink;
        this.t = new Thread(this, threadName);
        this.j = j;
        this.buffer = buffer;
        System.out.println("New: " + t);
        t.start();
    }
    // [Constructor]

    // [Thread Body]
    public void run() {
        try {

            buffer.getpSemaphore().acquire();   // [Try to Get Producer's Lock]

            buffer.produce(imgLink, j);         // [Calls the Producer to Add Link to the Buffer]

            buffer.getcSemaphore().release();   // [Release Consumer's Lock]


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // [Thread Body]
}
