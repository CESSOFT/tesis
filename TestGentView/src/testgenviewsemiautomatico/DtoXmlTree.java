package testgenviewsemiautomatico;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Eduardo
 */
public class DtoXmlTree {
    private String className="";
    private HashSet<String> metodoNameParam=new HashSet<String>();
    private HashMap<String, HashMap<String, String>> parameTipo;
    private HashMap<String, HashMap<String, String>> parameValor;
    private HashMap<String,String> parameRetorno;
    private HashMap<String,String> parameRetornoValor;
    private String patch;
 
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public HashSet<String> getMetodoNameParam() {
		return metodoNameParam;
	}
	public void setMetodoNameParam(HashSet<String> metodoNameParam) {
		this.metodoNameParam = metodoNameParam;
	}


    /**
     * @return the parameTipo
     */
    public HashMap<String, HashMap<String, String>> getParameTipo() {
        return parameTipo;
    }

    /**
     * @param parameTipo the parameTipo to set
     */
    public void setParameTipo(HashMap<String, HashMap<String, String>> parameTipo) {
        this.parameTipo = parameTipo;
    }

    /**
     * @return the parameRetorno
     */
    public HashMap<String, String> getParameRetorno() {
        return parameRetorno;
    }

    /**
     * @param parameRetorno the parameRetorno to set
     */
    public void setParameRetorno(HashMap<String, String> parameRetorno) {
        this.parameRetorno = parameRetorno;
    }

    /**
     * @return the patch
     */
    public String getPatch() {
        return patch;
    }

    /**
     * @param patch the patch to set
     */
    public void setPatch(String patch) {
        this.patch = patch;
    }

    /**
     * @return the parameValor
     */
    public HashMap<String, HashMap<String, String>> getParameValor() {
        return parameValor;
    }

    /**
     * @param parameValor the parameValor to set
     */
    public void setParameValor(HashMap<String, HashMap<String, String>> parameValor) {
        this.parameValor = parameValor;
    }

    /**
     * @return the parameRetornoValor
     */
    public HashMap<String, String> getParameRetornoValor() {
        return parameRetornoValor;
    }

    /**
     * @param parameRetornoValor the parameRetornoValor to set
     */
    public void setParameRetornoValor(HashMap<String, String> parameRetornoValor) {
        this.parameRetornoValor = parameRetornoValor;
    }
    @Override
    public String toString(){
        return getClassName();
    }

}
