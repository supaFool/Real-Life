package main.xml_data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Class used to load defs from xml files
 */
public class Def {

    private NodeList list = null;

    private String rootLocation = "src\\main\\xml_data\\";

    /**
     * @return all the child nodes of requested node from the requested .xml doc
     */
    public NodeList getNodeList(String filename, String node) throws NullPointerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(rootLocation + filename);
            list = doc.getElementsByTagName(node);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Element getElement(String filename, String node) {
        Element element;
//        list = def.getNodeList("player_defs.xml", "player_id");
        list = getNodeList(filename, node);
        for (int temp = 0; temp < list.getLength(); temp++) {

            Node nNode = list.item(temp);

            System.out.println("\n=======================================================================" +
                    "\n\nCurrent Element : " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode != null) {
                System.out.println("Loading elements");

                element = (Element) nNode;

                System.out.println(element.getAttribute("name"));

                System.out.println("Player ID : " + element.getElementsByTagName("neck").item(0).getLocalName());
//                System.out.println("Player Age : " + eElement.getElementsByTagName("player_age").item(0).getTextContent());
//                System.out.println("Player Level : " + eElement.getElementsByTagName("player_level").item(0).getTextContent());
//                System.out.println("Player Gender : " + eElement.getElementsByTagName("player_gender").item(0).getTextContent());
//                    System.out.println("Item : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("\n=======================================================================" +
                        "\n\n");
                return element;

            }
            break;
        }

        return null;
    }
}
