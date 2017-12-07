import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by PC on 21.10.2017.
 */
public class StAXParse {
    XMLInputFactory inputFactory;
    ValCurs valCurs;
    Valut valut;
    ArrayList<Valut> valuts=new ArrayList<Valut>();
    ValutContent valutContent;

    public StAXParse(){
        inputFactory=XMLInputFactory.newInstance();
    }



    public void BuildValCurs(File file){
        FileInputStream inputStream=null;
        XMLStreamReader reader=null;
        String name=null;
        valCurs=new ValCurs();
        try {

            inputStream=new FileInputStream(file);
            reader=inputFactory.createXMLStreamReader(inputStream);
            while(reader.hasNext()){
                int type =reader.next();
                if(type== XMLStreamConstants.START_ELEMENT){
                    name=reader.getLocalName();
                    if(name.equalsIgnoreCase("ValCurs")){
                        valCurs.setName(reader.getAttributeValue(null,"name"));
                        valCurs.setDate(reader.getAttributeValue(null,"Date"));
                    }
                    if(name.equalsIgnoreCase("Valute")){
                        valut=new Valut(); valutContent=new ValutContent();
                        valut.setId(reader.getAttributeValue(null,"ID"));
                    }


                }
                if(type== XMLStreamConstants.CHARACTERS){


                        if (name.equalsIgnoreCase("NumCode") && (valutContent.getNumCode() == null)) {
                            valutContent.setNumCode(reader.getText());


                        }
                        if (name.equalsIgnoreCase("CharCode") && (valutContent.getCharCode() == null)) {
                            valutContent.setCharCode(reader.getText());
                        }
                        if (name.equalsIgnoreCase("Nominal") && (valutContent.getNominal() == null)) {
                            valutContent.setNominal(reader.getText());
                        }
                        if (name.equalsIgnoreCase("Name") && (valutContent.getName() == null)) {
                            valutContent.setName(reader.getText());
                        }
                        if (name.equalsIgnoreCase("Value") && (valutContent.getValue() == null)) {
                            valutContent.setValue(reader.getText());

                        }


                }
                if(type== XMLStreamConstants.END_ELEMENT){
                    name=reader.getLocalName();
                    if(name.equalsIgnoreCase("Valute")){
                        valut.setValutContents(valutContent);
                        valuts.add(valut);
                    }

                }
                if(type== XMLStreamConstants.END_DOCUMENT){
                    valCurs.setValuts(valuts);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        StAXParse stAXParse=new StAXParse();
        File file=new File("D:\\1.xml");
        stAXParse.DownloadFile(file,"http://www.cbr.ru/scripts/XML_daily.asp");
        stAXParse.BuildValCurs(file);
        System.out.println(stAXParse.valCurs);

    }

    public void  DownloadFile(File file, String urlStr)
    {
        try {
            URL url=new URL(urlStr);
            BufferedInputStream bis=new BufferedInputStream(url.openStream());
            FileOutputStream fis=new FileOutputStream(file);
            byte[]buffer=new byte[1024];
            int count;
            while((count = bis.read(buffer,0,1024)) != -1)
            {
                fis.write(buffer,0,count);
            }
            fis.close();
            bis.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
