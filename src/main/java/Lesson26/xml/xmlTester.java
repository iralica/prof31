package Lesson26.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // parse - ���������� ������� �������� ����������

        // SAX - ��������� ����������, ������� �� ������ ������
        // ���� �������, ������� ����������� ��� ���������� ��������, �������� � �.�.
        // ��������� ������ ������ � ��� �������

        // DOM - Document Object Model - ������ ������ ������ ��������� � ������
        // �������� ��������� �� ��������� � ����� � ��� �������� ����������
        // ��������� ������ �� �������� � ���������� ������

        // XML
        //   xml schema - �������� ��������� xml ��������� �� ������������
        //   DOM SAX - �������
        //   XPath - ������ � ����������� ���������, ��������, ����� ������ ������� � ������������ ������,
        //           � �������� ������������ �������� �������� � �������� ���������� ��������
        //   XSLT - ������������� xml-��������� � ����� ������, � ��� ����� � � xml
        //   JAXB - ���������, ����� ������������� � ��������������� ������ � xml � �������

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        // doc - DOM ������ ��������� � ������
        Element root = doc.getDocumentElement();  // CATALOG

        NodeList priceNodeList = root.getElementsByTagName("PRICE"); // ������ ��������� � ������ PRICE
        for (int i = 0; i < priceNodeList.getLength(); i++) {
            Node priceNode = priceNodeList.item(i);  // ���������� ������� � ������ PRICE
            System.out.println(
                    priceNode.getFirstChild()
                            .getTextContent()
            );
        }

        printNode("", root);

        System.out.println("----------");

        printAttributes("", root);
    } // end main
    private static void printNode(String prefix, Element element) {
        System.out.println(
                prefix +
                        " element name " + element.getNodeName() +
                        " type " + element.getNodeType() +
                        printTextValue(element)
        );
        printAttributes(prefix + "\t", element);
        NodeList children = element.getChildNodes();  // ��� �������� �������� ��������
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);  // Node - ����� ���� �������, ������� � ��������� ��������
            if (node instanceof Element) {
                printNode(prefix + "\t", (Element) node);
            }
        }
    }

    public static String printTextValue(Element element) {
        //                      ��������� �������     ��������
        return " value " + element.getFirstChild().getTextContent();
    }

    // ������������� �������� ���������
    public static void printAttributes(String prefix, Element element) {
        NamedNodeMap namedNodeMap = element.getAttributes();  // ��� �������� ��������
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            Node attributeNode = namedNodeMap.item(i);
            System.out.println(
                    prefix +
                            " attr name " + attributeNode.getNodeName() +
                            " value " + attributeNode.getNodeValue()
            );
        }
    }
}
