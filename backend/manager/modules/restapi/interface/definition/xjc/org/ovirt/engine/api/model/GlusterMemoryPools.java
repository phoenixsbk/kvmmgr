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
 * <p>Java class for GlusterMemoryPools complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GlusterMemoryPools">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}memory_pool" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterMemoryPools", propOrder = {
    "glusterMemoryPools"
})
public class GlusterMemoryPools
    extends BaseResources
{

    @XmlElement(name = "memory_pool")
    protected List<GlusterMemoryPool> glusterMemoryPools;

    /**
     * Gets the value of the glusterMemoryPools property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the glusterMemoryPools property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlusterMemoryPools().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlusterMemoryPool }
     * 
     * 
     */
    public List<GlusterMemoryPool> getGlusterMemoryPools() {
        if (glusterMemoryPools == null) {
            glusterMemoryPools = new ArrayList<GlusterMemoryPool>();
        }
        return this.glusterMemoryPools;
    }

    public boolean isSetGlusterMemoryPools() {
        return ((this.glusterMemoryPools!= null)&&(!this.glusterMemoryPools.isEmpty()));
    }

    public void unsetGlusterMemoryPools() {
        this.glusterMemoryPools = null;
    }

}
