package Lesson26;
// 1. �������� ������� ������� ��������� �� ���� Element � ���������� �������� ��������� plantid �� ��� �������� ��������� PLANT (579)
// ������� ���� ����� xml �������� � ������������������� � ��� �� ��� - ��������,

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class HomeWork26 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        Element root = doc.getDocumentElement();

        System.out.println(sumPlantId(root));
        System.out.println(
                sumString(
                        root.getElementsByTagName("BOTANICAL")
                ));
    }

    public static int sumPlantId(Element element) {
        int plantIdSum = 0;
        // ������ �������� �������� PLANT
        NodeList plantNodeList = element.getElementsByTagName("PLANT");
        for (int i = 0; i < plantNodeList.getLength(); i++) {
            // � ��������� ������ ������� plandid
            Element plant = (Element) plantNodeList.item(i);
            // ������ �������� plantid
            plantIdSum += Integer.parseInt(plant.getAttribute("plantid"));
        }
        // ������
        return plantIdSum;
    }

    // 2. C������� ��������� �������� ���� ��� ������������ ��������� � ������ ����� StringBuilder.
    // ��������, ������� ����� ; �������� ���� ��������� BOTANICAL - "Sanguinaria canadensis;Aquilegia canadensis"
    public static String sumString(NodeList nodeList){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            // Node - Element, Attribute, NameSpace, Comment, TextNode, Processing Instruction
            if (i != 0)
                builder.append("; ");
            builder.append(element.getFirstChild().getTextContent());
        }
        return builder.toString();
    }
}
