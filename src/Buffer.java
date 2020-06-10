import java.util.LinkedList;

public class Buffer {
    // [Attributes]
    private LinkedList<String> list;
    private int downloaderIndex = 1;
    private String removed;
    private MySemaphore pSemaphore, cSemaphore;
    // [Attributes]

    // [Constructor]
    public Buffer() {
        this.list = new LinkedList<String>();
        this.pSemaphore = new MySemaphore(1);
        this.cSemaphore = new MySemaphore(0);
    }
    // [Constructor]

    //[Producer]
    public void produce(String imgLink, int imgNum) throws InterruptedException
    {
                System.out.println("Producer Ready!");

                // [Insert Links in The List]
                list.add(imgLink);

                //System.out.println("valor de j="+imgNum);
                System.out.println("Image " + imgNum + " added.");

                // [Makes The Working of Program Easier
                // to  Understand]
                Thread.sleep(1000);
                System.out.println("Producer Waiting...");
    }
    //[Producer]

    // [Consumer]
    public void consume() throws InterruptedException
    {
                System.out.println("Consumer Ready!");

                // [Retrieve the First Link in The List]
                this.removed = list.removeFirst();

                // [Creates Downloader Thread]
                new ImageDownloader("Download Image " + downloaderIndex, downloaderIndex, removed);

                // [Update Download Index]
                setDownloaderIndex(downloaderIndex+1);

                // [Show downloaded URL Image]
                System.out.println(removed);

                // [Sleep]
                Thread.sleep(1000);
                System.out.println("Consumer Waiting...");

    }
    // [Consumer]


    public MySemaphore getpSemaphore() {
        return pSemaphore;
    }

    public MySemaphore getcSemaphore() {
        return cSemaphore;
    }

    public void setDownloaderIndex(int downloaderIndex) {
        this.downloaderIndex = downloaderIndex;
    }
}