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
 * <p>Java class for Bios complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bios">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}boot_menu" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bios", propOrder = {
    "bootMenu"
})
public class Bios {

    @XmlElement(name = "boot_menu")
    protected BootMenu bootMenu;

    /**
     * Gets the value of the bootMenu property.
     * 
     * @return
     *     possible object is
     *     {@link BootMenu }
     *     
     */
    public BootMenu getBootMenu() {
        return bootMenu;
    }

    /**
     * Sets the value of the bootMenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link BootMenu }
     *     
     */
    public void setBootMenu(BootMenu value) {
        this.bootMenu = value;
    }

    public boolean isSetBootMenu() {
        return (this.bootMenu!= null);
    }

}
