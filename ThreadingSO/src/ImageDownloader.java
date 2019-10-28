
public class ImageDownloader extends Thread {
    private int j;
    private Buffer buffer;

    public ImageDownloader(int j, Buffer buffer) {
        this.j = j;
        this.buffer = buffer;
    }

    public void run(){
        try{
            Thread.sleep(5000);
            String imgLink;
            while (!buffer.getList().isEmpty()) {
                imgLink = buffer.getList().element();              //always get the first one
                new MyThreadDownloader("Photo " + (j + 1), imgLink, (j + 1));
                buffer.get(j + 1, imgLink);
                j++;
            }
        } catch (Throwable t){

        }

    }


}
