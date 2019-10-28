import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyThreadDownloader implements Runnable {

    private String name;
    private Thread t;
    private String url;
    private int i;          //number of photo

    MyThreadDownloader(String threadName, String url, int i){
        this.name = threadName;
        this.url = url;
        this.t = new Thread(this, name);
        this.i = i;
        System.out.println("New thread: " + t);
        t.start();

    }

    public void run() {
        try {
//            ImageDownloader imgDownloader = new ImageDownloader(i);
//            imgDownloader.downloadImage(url);

            try{
                URL url =new URL(this.url);

                if(url.toString().contains(".png")){
                    try(InputStream in = url.openStream()){
                        Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".png"));
                    } catch (IOException io){
                        System.out.println("Error in photo " + (i+1) + ".");
                    }
                } else if(url.toString().contains(".jpg")){
                    if(url.toString().contains("https://i.ytimg.com/")){                //youtube page
                        try(InputStream in = url.openStream()){
                            Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".webp"));         //google image format
                        } catch (IOException io){
                            System.out.println("Error in photo " + (i+1) + ".");
                        }
                    } else {
                        try(InputStream in = url.openStream()){
                            Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".jpg"));
                        } catch (IOException io){
                            System.out.println("Error in photo " + (i+1) + ".");
                        }
                    }

                } else if(url.toString().contains(".svg")){
                    try(InputStream in = url.openStream()){
                        Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".svg"));
                    } catch (IOException io){
                        System.out.println("Error in photo " + (i+1) + ".");
                    }
                } else if(url.toString().contains(".gif")){
                    try(InputStream in = url.openStream()){
                        Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".gif"));
                    } catch (IOException io){
                        System.out.println("Error in photo " + (i+1) + ".");
                    }
                } else if(url.toString().contains(".jpeg")){
                    try(InputStream in = url.openStream()){
                        Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".jpeg"));
                    } catch (IOException io){
                        System.out.println("Error in photo " + (i+1) + ".");
                    }
                } else if(url.toString().contains(".pdf")){
                    try(InputStream in = url.openStream()){
                        Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".pdf"));
                    } catch (IOException io){
                        System.out.println("Error in photo " + (i+1) + ".");
                    }
                } else if(url.toString().contains(".webp")){
                    try(InputStream in = url.openStream()){
                        Files.copy(in, Paths.get("/home/hildemir/Desktop/Downloaded Images/Foto" + (i + 1) + ".webp"));         // google image format
                    } catch (IOException io){
                        System.out.println("Error in photo " + (i+1) + ".");
                    }
                }

                this.IncrementI(i);
            }catch(IOException e){
                e.printStackTrace();
            }

            Thread.sleep(1000);

        }catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + " exiting.");
    }

    public void IncrementI(int i) {
        this.i = i + 1;
    }
}
