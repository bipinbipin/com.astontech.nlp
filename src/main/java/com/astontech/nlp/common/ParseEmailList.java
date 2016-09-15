package com.astontech.nlp.common;

import org.apache.tika.Tika;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bipin on 9/15/2016.
 */
public class ParseEmailList {

    //
    public static void main(String[] args) {
        String filePath =  "C:\\Users\\Aston\\Dropbox\\bipin\\Aston\\Odd Jobs\\emailList.txt";
        addFilesToList(filePath);
    }


    public static void addFilesToList(String filePath)
    {

        try
        {
            HashSet<String> hashSet = new HashSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(line);
                    while (m.find()) {
                        hashSet.add(m.group());
                    }
                }
            }

            // iterate the hashset and output
            for(String str : hashSet) {
                System.out.println(str);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String[] splitStringByNewLine(String s)
    {
        return s.split("\\r?\\n");
    }

}
