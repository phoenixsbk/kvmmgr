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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Disks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Disks">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevices">
 *       &lt;sequence>
 *         &lt;element ref="{}disk" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clone" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="detach_only" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Disks", propOrder = {
    "disks",
    "clone",
    "detachOnly"
})
public class Disks
    extends BaseDevices
{

    @XmlElement(name = "disk")
    protected List<Disk> disks;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean clone;
    @XmlElement(name = "detach_only", type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean detachOnly;

    /**
     * Gets the value of the disks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Disk }
     * 
     * 
     */
    public List<Disk> getDisks() {
        if (disks == null) {
            disks = new ArrayList<Disk>();
        }
        return this.disks;
    }

    public boolean isSetDisks() {
        return ((this.disks!= null)&&(!this.disks.isEmpty()));
    }

    public void unsetDisks() {
        this.disks = null;
    }

    /**
     * Gets the value of the clone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isClone() {
        return clone;
    }

    /**
     * Sets the value of the clone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClone(Boolean value) {
        this.clone = value;
    }

    public boolean isSetClone() {
        return (this.clone!= null);
    }

    /**
     * Gets the value of the detachOnly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isDetachOnly() {
        return detachOnly;
    }

    /**
     * Sets the value of the detachOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetachOnly(Boolean value) {
        this.detachOnly = value;
    }

    public boolean isSetDetachOnly() {
        return (this.detachOnly!= null);
    }

}