import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyThreadDownloader extends Thread {

    // [Attributes]
    private String name;
    private Thread t;
    private String url;
    private Buffer buffer;
    private int i;          // [Number of Photo]
    // [Attributes]

    // [Constructor]
    MyThreadDownloader(int i, Buffer buffer){
        //this.name = threadName;
        this.t = new Thread(this);
        this.buffer = buffer;
        this.i = i;
        t.start();
        //System.out.println("New thread: " + t);

    }
    // [Constructor]

    // [Thread Body]
    public void run() {
        try {
            buffer.consume(i);      // [Calls the Consumer That Should Delete Link From Buffer]
        }catch (InterruptedException e) {
            System.out.println(name + "Interrupted.");
        }
    }
    // [Thread Body]
}
