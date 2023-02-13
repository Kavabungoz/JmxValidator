package Utility;

import Constants.Constants;
import Exceptions.XmlParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlParser {

    public static void jmxParser(final String path, final String tagName) {
        final List<String> listOfAttributes = new ArrayList<>(Arrays.asList(Constants.ARRAY_OF_ATTRIBUTES));
        NodeList nodeList = getNodeList(path, tagName);

        int counter = 0;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            if (element.hasAttributes()) {
                counter += listOfAttributes.stream().filter(atr -> element.getAttribute("enabled").equals("true") && element.getAttribute("testname").equals(atr)).count();
            }
        }

        if (counter > 0)
            System.out.println("\n В jmx файле есть невыключенные листенеры " + tagName + ", в количестве " + counter + " элементов");

    }

    /* получаем список всех элементов по имени тэга. Н-р: <ResultCollector/> */
    private static NodeList getNodeList(final String path, final String tagName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();
            return document.getElementsByTagName(tagName);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XmlParseException(e.getMessage());
        }
    }
}