//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.13 at 03:17:43 PM CST 
//


package org.ovirt.engine.api.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NfsProfileDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NfsProfileDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{}EntityProfileDetail">
 *       &lt;sequence>
 *         &lt;element name="nfs_server_ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NfsProfileDetail", propOrder = {
    "nfsServerIp"
})
public class NfsProfileDetail
    extends EntityProfileDetail
{

    @XmlElement(name = "nfs_server_ip")
    protected String nfsServerIp;

    /**
     * Gets the value of the nfsServerIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNfsServerIp() {
        return nfsServerIp;
    }

    /**
     * Sets the value of the nfsServerIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNfsServerIp(String value) {
        this.nfsServerIp = value;
    }

    public boolean isSetNfsServerIp() {
        return (this.nfsServerIp!= null);
    }

}
