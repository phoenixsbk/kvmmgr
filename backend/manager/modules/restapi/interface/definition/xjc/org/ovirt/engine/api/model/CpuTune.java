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
 * <p>Java class for CpuTune complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CpuTune">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}vcpu_pin" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpuTune", propOrder = {
    "vCpuPin"
})
public class CpuTune {

    @XmlElement(name = "vcpu_pin")
    protected List<VCpuPin> vCpuPin;

    /**
     * Gets the value of the vCpuPin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vCpuPin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVCpuPin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VCpuPin }
     * 
     * 
     */
    public List<VCpuPin> getVCpuPin() {
        if (vCpuPin == null) {
            vCpuPin = new ArrayList<VCpuPin>();
        }
        return this.vCpuPin;
    }

    public boolean isSetVCpuPin() {
        return ((this.vCpuPin!= null)&&(!this.vCpuPin.isEmpty()));
    }

    public void unsetVCpuPin() {
        this.vCpuPin = null;
    }

}
