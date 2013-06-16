/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testgenviewsemiautomatico.util;

import java.io.File;
import java.util.HashSet;

import testgenviewsemiautomatico.DtoXMLCasoPrueba;
import testgenviewsemiautomatico.dto.DtoXmlTree;
import testgenviewsemiautomatico.xml.LeerXML;


/**
 *
 * @author Eduardo
 */
public class ListarCasos {

    public DtoXMLCasoPrueba[] getcasos(String clase, String patch) {
        String[] lista=null;
        String[] casos=null;
        DtoXMLCasoPrueba[] dtoXML=null;
         System.out.println("Patch: "+patch);
        try {
            File file = new File(patch);

            lista = file.list();
            int i = 0;
            casos=new String[lista.length];
            dtoXML=new DtoXMLCasoPrueba[lista.length];
            System.out.println("Cantidad de... files:"+lista.length);
            for (String in : lista) {
                 System.out.println("(o):" + in);
                if(in.indexOf(clase)>=0 && in.indexOf(".xml")>=0){
                    System.out.println(i + "):" + in);
                    File filexml=new File(patch+in.toString());
                    LeerXML leerxml=new LeerXML();
                    DtoXmlTree dto=leerxml.LeerXMLCaso(filexml);
                    //leer el xml y pasarlo al DTO
                    dtoXML[i]=UtilTestGen.SetDtoCaso(dto);
                    casos[i]=in.toString();
                    i++;

                }
            }

        } catch (Exception e) {
            System.out.println("Error al intentar abrir+" + e);
        }

        return dtoXML;
    }
}
