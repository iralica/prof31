package Lesson26.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XPathTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        // https://www.w3schools.com/xml/xpath_intro.asp

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        // doc - DOM ������ ��������� � ������
        Element root = doc.getDocumentElement(); // CATALOG

        // XPath - �������� �������� �������� � xml-���������
        XPath xPath = XPathFactory.newInstance().newXPath();
        /*
            /CATALOG - �������� ������� � ��������� CATALOG
            //LIGHT - ��� �������� � ��������� LIGHT � ����� ����� ���������
            /CATALOG/PLANT - ��� �������� PLANT ���������� ��������� ���������� ��������� �������� CATALOG
            //MOVIE/ACTOR - ��� �������� ACTOR ���������� ��������� ��� �������� MOVIE �� ������ ����� ���������
            //PLANT[@plantid='456']/PRICE - ������� PRICE, � �������� ������������ ������� PLANT � ��������� ...
         */


        XPathExpression xPathExpression = xPath.compile("//PLANT[@plantid='456']/PRICE");
        Node price = (Element) xPathExpression.evaluate(doc, XPathConstants.NODE);

        System.out.println(price.getFirstChild().getTextContent());
        //System.out.println(price.getTextContent());

        XPathExpression xPathExpression1 = xPath.compile("//PLANT[@plantid='456']/PRICE | //AVAILABILITY");
        NodeList nodes = (NodeList) xPathExpression1.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(
                    "price or availability: " + ((Element) nodes.item(i)).getFirstChild().getTextContent()
            );
        }


    }
}
