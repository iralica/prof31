package Lesson26;
// 1. Напишите функцию которая принимает на вход Element и складывает значения атрибутов plantid из его дочерних элементов PLANT (579)
// Найдите себе любой xml документ и поэкспериментируйте с ним из явы - например,

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
        // найдем дочерние элементы PLANT
        NodeList plantNodeList = element.getElementsByTagName("PLANT");
        for (int i = 0; i < plantNodeList.getLength(); i++) {
            // у элементов найдем атрибут plandid
            Element plant = (Element) plantNodeList.item(i);
            // сложим значения plantid
            plantIdSum += Integer.parseInt(plant.getAttribute("plantid"));
        }
        // вернем
        return plantIdSum;
    }

    // 2. Cоберите текстовые значения всех его определенных элементов в строку через StringBuilder.
    // Например, собрать через ; значения всех элементов BOTANICAL - "Sanguinaria canadensis;Aquilegia canadensis"
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
