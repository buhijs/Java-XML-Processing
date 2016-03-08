import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("./src/main/resources/pom.xml");

        printGavOfPlugins(document);
        addDependency(document);
        rewriteFile(document);
    }

    private static void rewriteFile(Document document) throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("./src/main/resources/pom.xml"));
        transformer.transform(source, result);
    }

    private static void addDependency(Document document) {
/*
        <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.18</version>
        </dependency>
*/
        Node dependencies = document.getElementsByTagName("dependencies").item(0);
        Node dependencySlf4j = document.createElement("dependency");
        Node groupId = document.createElement("groupId");
        groupId.setTextContent("org.slf4j");
        Node artifactId = document.createElement("artifactId");
        artifactId.setTextContent("slf4j-api");
        Node version = document.createElement("version");
        version.setTextContent("1.7.18");

        dependencySlf4j.appendChild(groupId);
        dependencySlf4j.appendChild(artifactId);
        dependencySlf4j.appendChild(version);
        dependencies.appendChild(dependencySlf4j);
    }

    private static void printGavOfPlugins(Document document) {
        Element buildElement = (Element) document.getElementsByTagName("build").item(0);
        NodeList plugins = buildElement.getElementsByTagName("plugin");
        for (int i = 0; i < plugins.getLength(); i++) {

            if(plugins.item(i).getParentNode().getParentNode().getNodeName().equals("pluginManagement")) {
                continue;
            }

            Node plugin = plugins.item(i);
            NodeList gav = plugin.getChildNodes();
            for (int j = 0; j < gav.getLength(); j++) {
                if(gav.item(j).getNodeName().equals("groupId")
                        || gav.item(j).getNodeName().equals("artifactId")
                        || gav.item(j).getNodeName().equals("version")) {
                    System.out.println((gav.item(j).getNodeName() + ": " + gav.item(j).getTextContent()));
                }
            }

        }
    }
}
