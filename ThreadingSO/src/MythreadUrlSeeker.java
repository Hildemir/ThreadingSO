import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MythreadUrlSeeker implements Runnable {

        private String name;
        private Thread t;
        private String url;
        private int i;
        private Buffer buffer;

        MythreadUrlSeeker(String threadName, String url, int i, Buffer buffer){
            this.name = threadName;
            this.url = url;
            this.t = new Thread(this, name);
            this.i = i;
            this.buffer = buffer;
            System.out.println("New: " + t);
            t.start();

        }

        public void run() {
            try {
                Document document = Jsoup.connect(url).get();
                Elements images = document.getElementsByTag("img");     //("img[src~=(?i)\\.(png|jpe?g|gif)]");

                for (Element e: images) {
                    if(isLink(e.attr("src"))){
                        buffer.set(i,e.attr("src"));
                       // buffer.getList().add((e.attr("src")));     //image url added to the buffer
//                        if(buffer.getList().size()<0){
//                            System.out.println("nao adicionou");
//                        } else{
//                            System.out.println("adicionou");
                            System.out.println(buffer.getList().size());
//                            System.out.println(buffer.getList().getFirst());
//                            System.out.println(buffer.getList().getLast());
//                        }
                    }
                }

                Thread.sleep(1000);

//                if(buffer.getList().isEmpty()){
//                    System.out.println("vazia otaru");
//                } else {
//                    for (String link: buffer.getList()) {
//                        System.out.println(link);
//                    }
//                }

            }catch (InterruptedException | IOException e) {
                System.out.println(name + "Interrupted");
            }
            System.out.println(name + " exiting.");
//            if(i >4){
//                if(buffer.getList().isEmpty()){
//                    System.out.println("vazia otaru");
//                } else {
//                    for (String link: buffer.getList()) {
//                        System.out.println(link);
//                    }
//                }
//            }
        }

        public boolean isLink(String str){
            if(str.startsWith("https://")){
                return true;
            }else {
                return false;
            }
        }


}
