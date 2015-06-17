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
 * <p>Java class for VmPools complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmPools">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}vmpool" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmPools", propOrder = {
    "vmPools"
})
public class VmPools
    extends BaseResources
{

    @XmlElement(name = "vmpool")
    protected List<VmPool> vmPools;

    /**
     * Gets the value of the vmPools property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmPools property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmPools().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmPool }
     * 
     * 
     */
    public List<VmPool> getVmPools() {
        if (vmPools == null) {
            vmPools = new ArrayList<VmPool>();
        }
        return this.vmPools;
    }

    public boolean isSetVmPools() {
        return ((this.vmPools!= null)&&(!this.vmPools.isEmpty()));
    }

    public void unsetVmPools() {
        this.vmPools = null;
    }

}