import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by PC on 14.10.2017.
 */

public class DOMParse {
    ValCurs valCurs;
    Valut valut;
    ArrayList<Valut> valuts=new ArrayList<Valut>();
    ValutContent valutContent;
    DocumentBuilder docBuilder;
    DOMParse(){
        valCurs=new ValCurs();

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        try {
            docBuilder =factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void buildValCurs(){
        Document doc=null;
        try {
            doc=docBuilder.parse("http://www.cbr.ru/scripts/XML_daily.asp");
            Element root=doc.getDocumentElement();
            valCurs.setDate(root.getAttribute("Date"));
            valCurs.setName(root.getAttribute("name"));
            NodeList list=root.getElementsByTagName("Valute");
            int i=0;
            while( i<list.getLength()){
                Element element;
                element=(Element)list.item(i);
                valut=new Valut();
                valutContent=new ValutContent();
                if(list.item(i).hasAttributes()){
                NamedNodeMap attrs= list.item(i).getAttributes();
                valut.setId(element.getAttribute("ID"));
                }

                valutContent.setNumCode(((Element)list.item(i)).getElementsByTagName("NumCode").item(0).getTextContent());
                valutContent.setCharCode(((Element)list.item(i)).getElementsByTagName("CharCode").item(0).getTextContent());
                valutContent.setNominal(((Element)list.item(i)).getElementsByTagName("Nominal").item(0).getTextContent());
                valutContent.setName(((Element)list.item(i)).getElementsByTagName("Name").item(0).getTextContent());
                valutContent.setValue(((Element)list.item(i)).getElementsByTagName("Value").item(0).getTextContent());
                valut.setValutContents(valutContent);
                valuts.add(valut);
                i++;
            }
            valCurs.setValuts(valuts);





        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
public static void main(String[] args){
    DOMParse domParse=new DOMParse();
    domParse.buildValCurs();
    System.out.println(domParse.valCurs);
}

}
