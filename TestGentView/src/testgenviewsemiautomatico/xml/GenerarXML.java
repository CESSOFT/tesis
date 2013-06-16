/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testgenviewsemiautomatico.xml;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import testgenviewsemiautomatico.DtoXMLCasoPrueba;
import testgenviewsemiautomatico.util.UtilTestGen;


/**
 *
 * @author Eduardo
 */
public class GenerarXML {

    public Document generarCasoXML(DtoXMLCasoPrueba dto){
        Element root=new Element("tests");
        Element clase=new Element("class");
        clase.setAttribute("name",dto.getClaseName());
        Element metodo=new Element("method");
        metodo.setAttribute("name", dto.getMetodo());
        metodo.setAttribute("test-case","1");
        metodo.addContent(getParams(dto));
        metodo.addContent(getGroupAsser(dto));

        clase.addContent(metodo);
        root.addContent(clase);
        Document doc=new Document(root);
        return doc;
    }
 private Element getParams(DtoXMLCasoPrueba dto){
     Element parasM=new Element("params");
      Element para=null;
        Set<String> dtopara=dto.getParameTipo().keySet();
        List<String> dtoparal=new ArrayList<String>(dtopara);
        Collections.sort(dtoparal);
        for(String dtp:dtoparal){

            String valor=new String(dtp);
            System.out.println("Valor_______::::::"+dto.getParameValor().get(valor.trim()));
            para=new Element("param");
            para.setAttribute("name", dtp);
            para.setAttribute("type", dto.getParameTipo().get(dtp));
            para.setText(dto.getParameValor().get(valor.trim()));
            parasM.addContent(para);
        }

     return parasM;
 }
 private Element getGroupAsser(DtoXMLCasoPrueba dto){
     Element asserts=new Element("asserts");
     Element assertsGrop=new Element("assertgroup");
     assertsGrop.setAttribute("name","testResult");
     Element  asser=new Element("assert");
     asser.setAttribute("name", "testResult1");
     asser.setAttribute("type", dto.getTypeassert());
     asser.setAttribute("action", dto.getAccion());
     asser.setText(dto.getValorassert());//Cambiar carlos ces
     assertsGrop.addContent(asser);
     asserts.addContent(assertsGrop);


     return asserts;
 }

    public static void  storeXML(Document doc, String patch) {

        XMLOutputter out = new XMLOutputter();
        try {
            FileOutputStream file = new FileOutputStream(patch+ ".xml");
            out.output(doc, file);
            file.flush();
            file.close();
            out.output(doc, System.out);
        } catch (Exception e) {
            System.out.println(patch + ".xml");
        }
    }
     public static boolean  storeXMLCaso(Document doc, String patch) {

        XMLOutputter out = new XMLOutputter();
        Date d=new Date();
        String runResult;
        try {
            String result=UtilTestGen.parsearResultado();
            if(result.contains("OK")){
                runResult="PASO";
            }else{
                runResult="FALLO";
            }

            FileOutputStream file = new FileOutputStream(patch+d.getTime()+ ".xml");
            out.output(doc, file);
            file.flush();
            file.close();
            out.output(doc, System.out);
        } catch (Exception e) {
            System.out.println(e+patch + ".xml");
            return false;
        }
        return true;
    }
}
