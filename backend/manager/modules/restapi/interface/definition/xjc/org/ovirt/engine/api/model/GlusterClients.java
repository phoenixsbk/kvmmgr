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
 * <p>Java class for GlusterClients complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GlusterClients">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}gluster_client" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterClients", propOrder = {
    "glusterClients"
})
public class GlusterClients
    extends BaseResources
{

    @XmlElement(name = "gluster_client")
    protected List<GlusterClient> glusterClients;

    /**
     * Gets the value of the glusterClients property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the glusterClients property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlusterClients().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlusterClient }
     * 
     * 
     */
    public List<GlusterClient> getGlusterClients() {
        if (glusterClients == null) {
            glusterClients = new ArrayList<GlusterClient>();
        }
        return this.glusterClients;
    }

    public boolean isSetGlusterClients() {
        return ((this.glusterClients!= null)&&(!this.glusterClients.isEmpty()));
    }

    public void unsetGlusterClients() {
        this.glusterClients = null;
    }

}
