//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.13 at 03:17:43 PM CST 
//


package org.ovirt.engine.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PmProxies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PmProxies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}pm_proxy" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PmProxies", propOrder = {
    "pmProxy"
})
public class PmProxies {

    @XmlElement(name = "pm_proxy")
    protected List<PmProxy> pmProxy;

    /**
     * Gets the value of the pmProxy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pmProxy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPmProxy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PmProxy }
     * 
     * 
     */
    public List<PmProxy> getPmProxy() {
        if (pmProxy == null) {
            pmProxy = new ArrayList<PmProxy>();
        }
        return this.pmProxy;
    }

    public boolean isSetPmProxy() {
        return ((this.pmProxy!= null)&&(!this.pmProxy.isEmpty()));
    }

    public void unsetPmProxy() {
        this.pmProxy = null;
    }

}