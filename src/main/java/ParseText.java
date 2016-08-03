import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Bipin on 8/3/2016.
 */
public class ParseText{


    public static void main(String[] args) {


        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Document.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                if(!line.equals("") && !line.equals(null)) {
                    if (line.charAt(0) == '�')
                        System.out.println(line);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
