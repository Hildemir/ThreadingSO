import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageDownloader extends Thread {
    // [Attributes]
    private int i;
    private String name;
    private Thread t;
    private Buffer buffer;
    private String url;
    // [Attributes]

    // [Constructor]
    public ImageDownloader(String threadName, int i, Buffer buffer, String url) {
        this.name = threadName;
        this.i = i;
        this.t = new Thread(this, name);
        this.buffer = buffer;
        this.url = url;
        t.start();
        System.out.println("New: " + t);
    }
    // [Constructor]

    // [Thread Body]
    public void run(){
        try{
            // [Get Image URL]
            URL url =new URL(this.url);
            // [In Case Type of Image is .png]
            if(url.toString().contains(".png")){
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".png"));
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
            }
            // [In Case Type of Image is .jpg]
             else if(url.toString().contains(".jpg")) {
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".jpg"));
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
                // [In Case Type of Image is .svg]
            } else if(url.toString().contains(".svg")){
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".svg"));
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
                // [In Case Type of Image is .gif]
            } else if(url.toString().contains(".gif")){
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".gif"));
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
                // [In Case Type of Image is .jpeg]
            } else if(url.toString().contains(".jpeg")){
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".jpeg"));
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
                // [In Case Type of Image is .pdf]
            } else if(url.toString().contains(".pdf")){
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".pdf"));
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
                // [In Case Type of Image is .webp]
            } else if(url.toString().contains(".webp")){
                try(InputStream in = url.openStream()){
                    Files.copy(in, Paths.get("Downloaded Images/Foto" + i + ".webp"));         // [Google Image Format]
                } catch (IOException io){
                    System.out.println("Error in photo " + i + ".");
                    return;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Image " + i + " Downloaded.");

    }
    // [Thread Body]

}
