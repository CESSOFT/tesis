/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testgenviewsemiautomatico;

import java.awt.Component;
import java.util.HashMap;

/**
 *
 * @author Eduardo
 */
public class DtoXMLCasoPrueba extends Component {
    	private static final long serialVersionUID = 1L;

	private String claseName="";
	private String metodo="";
	private HashMap<String, String> parameTipo;
	private HashMap<String, String> parameValor;
        private String typeassert;
        private String valorassert;
        private String patch;
        private String accion;
	public String getClaseName() {
		return claseName;
	}
	public void setClaseName(String claseName) {
		this.claseName = claseName;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public HashMap<String, String> getParameTipo() {
		return parameTipo;
	}
	public void setParameTipo(HashMap<String, String> parameTipo) {
		this.parameTipo = parameTipo;
	}
        @Override
	public String toString(){
		return getClaseName()+getMetodo()+getParameTipo().toString();

	}
	public HashMap<String, String> getParameValor() {
		return parameValor;
	}
	public void setParameValor(HashMap<String, String> parameValor) {
		this.parameValor = parameValor;
	}
    /**
     * @return the typeassert
     */
    public String getTypeassert() {
        return typeassert;
    }

    /**
     * @param typeassert the typeassert to set
     */
    public void setTypeassert(String typeassert) {
        this.typeassert = typeassert;
    }

    /**
     * @return the valorassert
     */
    public String getValorassert() {
        return valorassert;
    }

    /**
     * @param valorassert the valorassert to set
     */
    public void setValorassert(String valorassert) {
        this.valorassert = valorassert;
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
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }


}
