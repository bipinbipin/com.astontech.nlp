import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseText
{


    public static void main(String[] args)
    {
        final File folder = new File("C:/Resumes/");
        listFilesForFolder(folder);

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
                System.out.println(fileEntry.getName());
            }
        }
    }



}
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("C:\\Document.txt"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                // process the line.
//                if(!line.equals("") && !line.equals(null)) {
//                    if (line.charAt(0) == '�')
//                        System.out.println(line);
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//
//
//
//      {
//            Files.walk(Paths.get("C:/Resumes/")).forEach(filePath -> {
//                if (Files.isRegularFile(filePath))
//                {
//                    System.out.println(filePath);
//                }
//            });
