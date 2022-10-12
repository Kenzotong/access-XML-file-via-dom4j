
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Set;

import org.dom4j.Text;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class removeBlank {
    public static void main(String[] args) throws DocumentException, IOException {

        SAXReader reader = new SAXReader();

        //loading xml file, get document structure
        Document document = reader.read("D:/Jetbrain/bene/scenarios/tourismFacilities/tourismFacilities(new).xml");

        //get root element
        Element root = document.getRootElement();

        //put all elements which name is facility into the list
        List<Element> facilities = root.elements("facility");


        //Iterate over the elements
        for (Element facility : facilities ){

            //get text from attribute id
            Attribute id = facility.attribute("id") ;
            String idText = id.getText();

            //create new attribute idNew and add to the XML file
            String newId = idText.replace(" ", "");

            facility.addAttribute("idNew", newId);
            Attribute idNew = facility.attribute("idNew");

            //remove old attribute id
            facility.remove(id);


        }

        //output new file

        XMLWriter writer = new XMLWriter(new FileWriter("new"));

        writer.write(document);

        writer.close();

    }

}
