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


public class getAMapBetweenIdAndDesc {
    public static void main(String[] args) throws DocumentException {

        System.out.println(getIdAndDesc());

    }


    public static Map<Attribute, Attribute> getIdAndDesc() throws DocumentException {

        SAXReader reader = new SAXReader();

        //loading xml file, get document structure
        Document document = reader.read("D:/Jetbrain/bene/scenarios/tourismFacilities/tourismFacilities(new).xml");

        //get root element
        Element root = document.getRootElement();

        //put all elements which name is facility into the list
        List<Element> facilities = root.elements("facility");

        //Declare a hash map for id and desc
        Map<Attribute, Attribute> idAndDesc = new HashMap<>();

        //Iterate over the elements and assign into this hash map
        for (Element facility : facilities ){
            Attribute id = facility.attribute("id") ;
            Attribute desc = facility.attribute("desc");

            idAndDesc.put(id, desc);

        }

        return idAndDesc;


    }

}
