/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testgenviewsemiautomatico;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


/**
 *
 * @author Eduardo
 */
public class LeerXML {

    public HashSet<DtoXmlTree> LeerXML(File fclass) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder(false);
        HashSet<DtoXmlTree> dtoList = new HashSet<DtoXmlTree>();

        //usar el parser Xerces y no queremos
        //que valide el documento
        Document doc = builder.build(fclass.getAbsolutePath());
        Element raiz = doc.getRootElement();
        //todos los hijos que tengan como nombre class
        List class1 = raiz.getChildren("class");
        System.out.println("Formada por:" + class1.size() + " class");
        Iterator i = class1.iterator();
        while (i.hasNext()) {
            DtoXmlTree xmlTree = new DtoXmlTree();
            xmlTree.setPatch(fclass.getAbsolutePath());
            String metodo = "";
            HashSet<String> listaMetodo = new HashSet<String>();
            Element e = (Element) i.next();
            //Cargo el Dto el nombre de la clase
            xmlTree.setClassName(e.getAttributeValue("name"));

            List metodos = e.getChildren("method");
            // System.out.println("cantidad de Metodos:"+plantilla.size());
            Iterator m = metodos.iterator();

            //retorno
            HashMap<String, String> retorno = new HashMap<String, String>();
            //Listar los parametros
            HashMap<String, HashMap<String, String>> metodoParatipo = new HashMap<String, HashMap<String, String>>();
            

            //Cargo los metodos correspondiente a la Clase
            while (m.hasNext()) {
                Element em = (Element) m.next();
                metodo = em.getAttributeValue("name");
            //parametro
            HashMap<String, String> paramTipo = new HashMap<String, String>();

                List paraList = em.getChildren("params");
                Iterator itpa = paraList.iterator();
                if (itpa.hasNext()) {
                    Element params = (Element) itpa.next();
                    List param = params.getChildren("param");
                    Iterator itparas = param.iterator();
                    while (itparas.hasNext()) {
                        Element p = (Element) itparas.next();
                        paramTipo.put(p.getAttributeValue("name"), p.getAttributeValue("type"));
                    }
                }

                //Listar los Assert
                Element asserts = em.getChild("asserts");
                Element assertGrop = asserts.getChild("assertgroup");
                Element assert_ = assertGrop.getChild("assert");
               

                if (listaMetodo.add(metodo)) {
                    metodoParatipo.put(metodo, paramTipo);
                     retorno.put(metodo, assert_.getAttributeValue("type"));
                    
                }
                //System.out.println("Metodo"+numerom+++" nombre: "+em.getAttributeValue("name"));

            }
            xmlTree.setParameTipo(metodoParatipo);
            xmlTree.setParameRetorno(retorno);
            xmlTree.setMetodoNameParam(listaMetodo);
            dtoList.add(xmlTree);
        }
        return dtoList;
        // Dejamos de mano del lector el sacar el nombre
        //de los arbitros, animate!!
    }
    public DtoXmlTree LeerXMLCaso(File fclass) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder(false);
        DtoXmlTree xmlTree = new DtoXmlTree();
        //usar el parser Xerces y no queremos
        //que valide el documento
        Document doc = builder.build(fclass.getAbsolutePath());
        Element raiz = doc.getRootElement();
        //todos los hijos que tengan como nombre class
        List class1 = raiz.getChildren("class");
        System.out.println("Formada por:" + class1.size() + " class");
        Iterator i = class1.iterator();
        while (i.hasNext()) {

            xmlTree.setPatch(fclass.getAbsolutePath());
            String metodo = "";
            HashSet<String> listaMetodo = new HashSet<String>();
            Element e = (Element) i.next();
            //Cargo el Dto el nombre de la clase
            xmlTree.setClassName(e.getAttributeValue("name"));

            List metodos = e.getChildren("method");
            // System.out.println("cantidad de Metodos:"+plantilla.size());
            Iterator m = metodos.iterator();

            //retorno
            HashMap<String, String> retorno = new HashMap<String, String>();
            HashMap<String, String> retornovalor = new HashMap<String, String>();
            //Listar los parametros
            HashMap<String, HashMap<String, String>> metodoParatipo = new HashMap<String, HashMap<String, String>>();
            HashMap<String, HashMap<String, String>> metodoParavalor = new HashMap<String, HashMap<String, String>>();

            //Cargo los metodos correspondiente a la Clase
            while (m.hasNext()) {
                Element em = (Element) m.next();
                metodo = em.getAttributeValue("name");
            //parametro
            HashMap<String, String> paramTipo = new HashMap<String, String>();
            HashMap<String, String> paramValor = new HashMap<String, String>();

                List paraList = em.getChildren("params");
                Iterator itpa = paraList.iterator();
                if (itpa.hasNext()) {
                    Element params = (Element) itpa.next();
                    List param = params.getChildren("param");
                    Iterator itparas = param.iterator();
                    while (itparas.hasNext()) {
                        Element p = (Element) itparas.next();
                        paramTipo.put(p.getAttributeValue("name"), p.getAttributeValue("type"));
                        paramValor.put(p.getAttributeValue("name"),p.getText());
                    }
                }

                //Listar los Assert
                Element asserts = em.getChild("asserts");
                Element assertGrop = asserts.getChild("assertgroup");
                Element assert_ = assertGrop.getChild("assert");


                if (listaMetodo.add(metodo)) {
                    metodoParatipo.put(metodo, paramTipo);
                    metodoParavalor.put(metodo, paramValor);
                     retorno.put(metodo, assert_.getAttributeValue("type"));
                     retornovalor.put(metodo,assert_.getText());
                }
                //System.out.println("Metodo"+numerom+++" nombre: "+em.getAttributeValue("name"));

            }
            xmlTree.setParameTipo(metodoParatipo);
            xmlTree.setParameValor(metodoParavalor);
            xmlTree.setParameRetorno(retorno);
            xmlTree.setParameRetornoValor(retornovalor);
            xmlTree.setMetodoNameParam(listaMetodo);
        }
        return xmlTree;
        // Dejamos de mano del lector el sacar el nombre
        //de los arbitros, animate!!
    }
}
