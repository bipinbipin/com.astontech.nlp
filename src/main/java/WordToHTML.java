import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * Created by Bipin on 8/3/2016.
 */
public class WordToHTML {

    public static void main(String[] args) {

        String html = null;
        try {
        //convert .docx to HTML string
        InputStream in= new FileInputStream(new File("C:\\Resume.docx"));
        XWPFDocument document = new XWPFDocument(in);


        XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

        OutputStream out = new ByteArrayOutputStream();


            XHTMLConverter.getInstance().convert(document, out, options);
            html = out.toString();
            //System.out.println(html);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
//        System.out.println(body);

        Elements links = doc.select("span");
        for(Element e : links) {
            String bulletContents = null;
            if(!e.text().contains("•")){

                System.out.println(e.text());
            }
        }

    }

}
