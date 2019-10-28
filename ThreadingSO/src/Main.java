public class Main {
    public static void main(String [] agrs){
        int i =0, j = 0;
        Buffer  sharedBuffer = new Buffer();
        GetHtmls getHtmls = new GetHtmls(sharedBuffer, i);
        ImageDownloader imgDownloader = new ImageDownloader(j, sharedBuffer);

        getHtmls.start();
        imgDownloader.start();
//        while (true) {
//            System.out.println(sharedBuffer.getList().size());
//        }


       // int i = 0;

        //getHtmls.readFile();

//        while(i <= (getHtmls.getUrlList().size() - 1)){
//            new MyThreadDownloader("Photo " + (i + 1), getHtmls.getUrlList().get(i), i);
//            i++;
//        }
    }
}
