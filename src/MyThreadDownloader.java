public class MyThreadDownloader extends Thread {

    // [Attributes]
    private Thread t;
    private Buffer buffer;
    // [Attributes]

    // [Constructor]
    MyThreadDownloader(Buffer buffer){
        this.t = new Thread(this);
        this.buffer = buffer;
        t.start();
    }
    // [Constructor]

    // [Thread Body]
    public void run() {
        try {
            while(true) {
                buffer.getcSemaphore().acquire();       // [Try to Get Consumer's Lock]

                buffer.consume();                       // [Calls the Consumer That will Delete Link From Buffer]

                buffer.getpSemaphore().release();       // [Release Producer's Lock]
            }
        }catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
    }
    // [Thread Body]
}
