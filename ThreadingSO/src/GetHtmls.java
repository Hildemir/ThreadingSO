
import java.io.*;
import java.util.*;
public class GetHtmls extends Thread{
    // [Attributes]
    private Buffer buffer;
    private int i;
    private int j;
    // [Attributes]

    // [Constructor]
    public GetHtmls(Buffer buffer, int i, int j){
        this.buffer = buffer;
        this.i = i;                 // [Index of Search Link Thread]
        this.j = j;                 // [Index of Add Photo Thread]
    }
    // [Constructor]

    // [Thread Body]
    public void run() {
        try {
            // [Read the File]
            FileInputStream inputStream = new FileInputStream("src/Links");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            try{
                line = reader.readLine();           // [Read The First Line And Then The Next Ones]
                while((line  != null)){
                    new MythreadUrlSeeker("Search Link " + (i + 1), line,(i + 1), (j + 1), buffer);
                    i++;
                    line = reader.readLine();
                }
            } catch (FileNotFoundException nf){
                System.out.println("File not found.");
            } catch (IOException e){
                System.out.println("File can't be read.");
            }

        } catch (IOException e) {
            System.err.printf("File can't be open %s.\n",
                    e.getMessage());
        }
    }
    // [Thread Body]
}
