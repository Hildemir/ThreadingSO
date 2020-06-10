import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MythreadUrlSeeker implements Runnable {

    // [Attributes]
        private String name;
        private Thread t;
        private String url;
        private int i;
        private int j;
        private Buffer buffer;
    // [Attributes]

    // [Constructor]
        MythreadUrlSeeker(String threadName, String url, int i, int j, Buffer buffer){
            this.name = threadName;
            this.url = url;
            this.t = new Thread(this, name);
            this.i = i;
            this.j = j;
            this.buffer = buffer;
            System.out.println("New: " + t);
            t.start();
        }
    // [Constructor]

    // [Thread Body]
        public void run() {
            // [Connect With URL]
            try {
                Document document = Jsoup.connect(url).get();
                System.out.println("Fetching " + url + " ...");
                // [Returns All Images]
                Elements images = document.getElementsByTag("img");     //("img[src~=(?i)\\.(png|jpe?g|gif)]");
                System.out.println("Media: (" + images.size() + ")");
                for (Element e: images) {
                    if(isLink(e.attr("src"))){
                        // [ Create Thread that Add Each Image in The List]
                        new MyThreadImageProducer("Adding Image " + i + "." + j , e.attr("src"), j, buffer);
                        j++;
                    }
                }
                Thread.sleep(1000);
            }catch (InterruptedException | IOException e) {
                System.out.println(name + " Interrupted.");
            }
            System.out.println(name + " Finished.");
        }
    // [Thread Body]

    // [Validate URL]
        public boolean isLink(String str) {
            return str.startsWith("https://");      // [If Starts With "https://" Return True, Otherwise, Return False]
        }
    // [Validate URL]

}
