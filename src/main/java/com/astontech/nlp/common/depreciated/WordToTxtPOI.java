package com.astontech.nlp.common.depreciated;

import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Bipin on 8/4/2016.
 */
public class WordToTxtPOI {
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
