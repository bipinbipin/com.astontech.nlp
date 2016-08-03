import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.tika.Tika;

import java.io.*;

/**
 * Created by Bipin on 8/3/2016.
 */
public class WordToTxt {

    public static void main(String[] args) {

        //recurse thru a folder
        String filePath = "C:\\Resume2.docx";

        try {
            File file = new File(filePath);
            InputStream fis = new FileInputStream(file);

            Tika tika = new Tika();
            String tikaText = tika.parseToString(file);

//            System.out.println(tikaText);

            //iterate thru line by line
            for(String line : splitStringByNewLine(tikaText)) {
                if(!line.equals("") && !line.equals(null)) {
                    if (line.charAt(0) == '·')
                        System.out.println(line);
                }
            }


       } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] splitStringByNewLine(String s) {
        return s.split("\\r?\\n");
    }



    //    using POI
    public static void convertUsingPOI(String filePath) {
//        String filePath = "C:\\Resume.docx";

        try {
            File file = new File(filePath);
            InputStream fis = new FileInputStream(file);

            POITextExtractor extractor;
            // if docx
            if (file.getName().toLowerCase().endsWith(".docx")) {
                XWPFDocument doc = new XWPFDocument(fis);
                extractor = new XWPFWordExtractor(doc);
            } else {
                // if doc
                POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
                extractor = ExtractorFactory.createExtractor(fileSystem);
            }
            String extractedText = extractor.getText();
            System.out.println(extractedText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
