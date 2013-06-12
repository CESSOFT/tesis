/**
 * JTestGen.java
 * TestGen4J is licensed under Open Software License 2.1
 * For details, please refer to:
 * http://www.opensource.org/licenses/osl-2.1.php   
 */
package testgenviewsemiautomatico.testgent4j;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

//import com.sun.corba.se.spi.orbutil.fsm.InputImpl;

import java.io.File;

import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



public class RulesEngine {
    /**
     * Factory variable.
     */
    private static Document doc = null;

    /**
     * The function uses DocumentBuilderFactory parser to
     * parse the rules file and get boundary conditions of
     * the data type.
     *
     * @param type
     *            The data type in String form.
     * @return
     *            Returns boundary conditions of the data
     *            type as String, with each condition as
     *            a token separated by a comma.
     */
    public final String getConditions(final String type) {
        String conditions = null;

        try {
            if (doc == null) {
                DocumentBuilderFactory docBuilderFactory
                = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder
                = docBuilderFactory.newDocumentBuilder();
                Properties p = new Properties(System.getProperties());
                System.out.println("~...~~~~~~~~~~~******************~~~~~-~~~~~~");
                File is = new File("src" + p.getProperty("file.separator") +
                        "testgenviewsemiautomatico" + p.getProperty("file.separator") +
                        "src", "rules.xml");

                

               
                System.out.println("getConditions " + is);
                /*System.out.println("\n\n busco en " + "src"
                        + p.getProperty("file.separator")
                        + "com" + p.getProperty("file.separator")
                        + "spikesource" + p.getProperty("file.separator")
                        + "spiketestgen" + p.getProperty("file.separator")
                        + "rules.xml \n\n");*/
                doc = docBuilder.parse(is);

                // normalize text representation
                doc.getDocumentElement().normalize();
            }

            NodeList t = doc.getElementsByTagName("DataType");

            for (int j = 0; j < t.getLength(); j++) {
                if (t.item(j).getAttributes().getNamedItem("name")
                    .getNodeValue().equals(type)) {
                    Element d = (Element) t.item(j);
                    NodeList n = d.getElementsByTagName("Case");

                    for (int k = 0; k < n.getLength(); k++) {
                        Element r = (Element) n.item(k);

                        if (k == 0) {
                            conditions = r.getAttribute("value");
                        } else if (k > 0) {
                            conditions = conditions + ','
                            + r.getAttribute("value");
                        }
                    }
                }
            }
        } catch (SAXParseException err) {
            System.out.println("** Parsing error" + ", line "
                + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            if (x == null) {
                e.printStackTrace();
            } else {
                x.printStackTrace();            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return conditions;
    }
}
