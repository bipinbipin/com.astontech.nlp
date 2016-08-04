import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.tika.Tika;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WordToTxt
{
        public static List<String> linesToWrite = new ArrayList<>();

    public static void main(String[] args)
    {
        final File folder = new File("C:/Resumes/");
        listFilesForFolder(folder);

    }

    public static String[] splitStringByNewLine(String s)
    {
        return s.split("\\r?\\n");
    }


    public static void listFilesForFolder(final File folder)
    {
        for (final File fileEntry : folder.listFiles())
        {
            if (fileEntry.isDirectory())
            {
                listFilesForFolder(fileEntry);
            }
            else
            {
                //System.out.println(fileEntry.getName());
                addFilesToList(fileEntry.getName());

            }
        }
    }

    public static void addFilesToList(String _newFile)
    {

        try
        {

            String filePath = "C:\\Resumes\\"+_newFile;
            //System.out.println(filePath);
            File file = new File(filePath);

            InputStream fis = new FileInputStream(file);

            //USE TIKA TO TAKE WORD AND MAKE IT TXT
            Tika tika = new Tika();
            String tikaText = tika.parseToString(fis);



            for (String line : splitStringByNewLine(tikaText))
            {
                if (!line.equals("") && !line.equals(null))
                {
                    if (line.charAt(0) == '·')
                    {
                        //linesToWrite.add(line);
                        //System.out.println(line);
                        if(line.contains("Java") | line.contains("Spring") | line.contains("Maven"))
                        {
                            System.out.println("OOP: " + line);
                        }
                        else if(line.contains("Database") || line.contains("database") || line.contains("SQL"))
                        {
                            System.out.println("DB: " + line);
                        }
                        else if(line.contains("REST") | line.contains("RESTful"))
                        {
                            System.out.println("WS: " + line);
                        }
                        else if(line.contains("Bootstrap") | line.contains("Javascript"))
                        {
                            System.out.println("FE: " + line);
                        }
                        else
                        {
                            System.out.println("NC: " + line);
                        }
                    }
                }
            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void writeToFile(List<String> linesToWrite)
    {
            try
            {
                //Whatever the file path is.
                File fileToWrite = new File("C:\\Bullets.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(fileToWrite);
                OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter w = new BufferedWriter(streamWriter);
                for (String s : linesToWrite)
                {
                    System.out.println(s);
                    w.write(s);
                    w.newLine();
                }
                w.close();
            }
            catch (IOException e)
            {
                System.err.println("Problem writing to the file Bullets.txt");
            }
            finally
            {
                System.out.println("File done processing.");
            }

    }



    //    using POI
    public static void convertUsingPOI(String filePath)
    {
//        String filePath = "C:\\Resume.docx";

        try
        {
            File file = new File(filePath);
            InputStream fis = new FileInputStream(file);

            POITextExtractor extractor;
            // if docx
            if (file.getName().toLowerCase().endsWith(".docx"))
            {
                XWPFDocument doc = new XWPFDocument(fis);
                extractor = new XWPFWordExtractor(doc);
            }
            else
            {
                // if doc
                POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
                extractor = ExtractorFactory.createExtractor(fileSystem);
            }
            String extractedText = extractor.getText();
            System.out.println(extractedText);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
