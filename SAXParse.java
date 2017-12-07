import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by PC on 08.10.2017.
 */

class ValCurs{
    String date;
    String name;
    ArrayList<Valut> valuts;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ValCurs{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", valuts=" + valuts +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Valut> getValuts() {
        return valuts;
    }

    public void setValuts(ArrayList<Valut> valuts) {
        this.valuts = valuts;
    }


}

class Valut{
    String id;
    ValutContent valutContents;


    @Override
    public String toString() {
        return "Valut{" +
                "id='" + id + '\'' +
                ", valutContents=" + valutContents +
                '}';
    }

    public ValutContent getValutContents() {
        return valutContents;
    }

    public void setValutContents(ValutContent valutContents) {
        this.valutContents = valutContents;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
class ValutContent{

    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;
    @Override
    public String toString() {
        return "ValutContent{" +
                "numCode=" + numCode +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }




    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}





class ValutHandler extends DefaultHandler {
    Valut valut = null;
    ValCurs valCurs = null;
    ValutContent valutContent=null;
    String current="";
    ArrayList<Valut> valuts=null;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        System.out.println("Start");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        current=qName;
        if (qName.equals("ValCurs")) {
            valCurs=new ValCurs();
            if(valuts==null){
            valuts=new ArrayList<Valut>();}
            valCurs.setDate(attributes.getValue("Date"));
            valCurs.setName(attributes.getValue("name"));

        }
        if (qName.equals("Valute")) {
            valut=new Valut();
            valutContent=new ValutContent();
            valut.setId(attributes.getValue("ID"));




    }}



    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);


        if (qName.equals("Valute")) {

            valut.setValutContents(valutContent);
            valuts.add(valut);

        }
        if (qName.equals("ValCurs")) {
            valCurs.setValuts(valuts);


        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (current.equalsIgnoreCase("NumCode")&&(valutContent.getNumCode()==null)) {
            valutContent.setNumCode(new String(ch,start,length));

        }
        if (current.equalsIgnoreCase("CharCode")&&(valutContent.getCharCode()==null)) {
            valutContent.setCharCode(new String(ch,start,length));

        }
        if (current.equalsIgnoreCase("Nominal")&&(valutContent.getNominal()==null)) {
            valutContent.setNominal(new String(ch,start,length));
        }
        if (current.equalsIgnoreCase("Name")&&(valutContent.getName()==null)) {
            valutContent.setName(new String(ch,start,length));
        }
        if (current.equalsIgnoreCase("Value")&&(valutContent.getValue()==null)) {
            valutContent.setValue(new String(ch,start,length));
        }



    }
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        System.out.println(valCurs);
    }
}
public class SAXParse {
    public static void main(String[] args){
         SAXParserFactory f= SAXParserFactory.newInstance();
        try {
            XMLReader reader= XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ValutHandler());
            reader.parse("http://www.cbr.ru/scripts/XML_daily.asp");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
