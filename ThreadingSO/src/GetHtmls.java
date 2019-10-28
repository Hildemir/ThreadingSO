
import java.io.*;
import java.util.*;
public class GetHtmls extends Thread{           //Producer

    //private List <String> urlList;

   // private int producerId;
    private Buffer buffer;
    private int i;

    public GetHtmls(Buffer buffer, int i){
       // urlList = new LinkedList<String>();             //list with all the images urls
        //this.producerId = producerId;
        this.buffer = buffer;
        this.i = i;
    }

    public void run() {

        try {
            FileInputStream inputStream = new FileInputStream("/home/hildemir/Desktop/links");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;

            try{
                line = reader.readLine();
                while((line  != null)){
                    new MythreadUrlSeeker("Seek link " + (i + 1), line, (i + 1), buffer);
                    i++;
                    line = reader.readLine();

                }

//                for (String url: urlList) {             //print all links in the list
//                    System.out.println(url);
//                }

            } catch (FileNotFoundException nf){
                System.out.println("File not found.");
            } catch (IOException e){
                System.out.println("File can't be read.");
            }

        } catch (IOException e) {
            System.err.printf("File can't be open %s.\n",
                    e.getMessage());
        }

        //System.out.println("Produtor #" + producerId + " concluido!");
    }



//        public boolean isLink(String str){
//            if(str.startsWith("https://")){
//                return true;
//            }else {
//                return false;
//            }
//        }
//        public  void readFile(){
//            try {
//                FileInputStream inputStream = new FileInputStream("/home/hildemir/Desktop/links");
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader reader = new BufferedReader(inputStreamReader);
//                String line;
//                Document document;
//
//                try{
//                    line = reader.readLine();
//                    while((line  != null)){
//
//                        document = Jsoup.connect(line).get();
//                        Elements images = document.getElementsByTag("img");     //("img[src~=(?i)\\.(png|jpe?g|gif)]");
//
//                        for (Element e: images) {
//                            if(isLink(e.attr("src"))){
//                                urlList.add(e.attr("src"));
//                            }
//                        }
//                        line = reader.readLine();
//
//                    }
//
//                    for (String url: urlList) {             //print all links in the list
//                        System.out.println(url);
//                    }
//
//                } catch (FileNotFoundException nf){
//                    System.out.println("File not found.");
//                } catch (IOException e){
//                    System.out.println("File can't be read.");
//                }
//
//            } catch (IOException e) {
//                System.err.printf("File couldn't be open: %s.\n",
//                        e.getMessage());
//            }
//        }
//
//    public List<String> getUrlList() {
//        return urlList;
//    }
}
