public class Main {
    public static void main(String [] agrs){
        int i =0, j = 0;

        Buffer  sharedBuffer = new Buffer();
        GetHtmls getHtmls = new GetHtmls(sharedBuffer, i, j);
        MyThreadDownloader threadDownloader = new MyThreadDownloader(j, sharedBuffer);

        //[!Start Threads]
        getHtmls.start();
        threadDownloader.start();
        //[!Start Threads]
    }
}
