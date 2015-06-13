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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for GuestNicConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestNicConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}ip" minOccurs="0"/>
 *         &lt;element name="boot_protocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="on_boot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestNicConfiguration", propOrder = {
    "name",
    "ip",
    "bootProtocol",
    "onBoot"
})
public class GuestNicConfiguration {

    protected String name;
    protected IP ip;
    @XmlElement(name = "boot_protocol")
    protected String bootProtocol;
    @XmlElement(name = "on_boot", type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean onBoot;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the ip property.
     * 
     * @return
     *     possible object is
     *     {@link IP }
     *     
     */
    public IP getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     * 
     * @param value
     *     allowed object is
     *     {@link IP }
     *     
     */
    public void setIp(IP value) {
        this.ip = value;
    }

    public boolean isSetIp() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the bootProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBootProtocol() {
        return bootProtocol;
    }

    /**
     * Sets the value of the bootProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBootProtocol(String value) {
        this.bootProtocol = value;
    }

    public boolean isSetBootProtocol() {
        return (this.bootProtocol!= null);
    }

    /**
     * Gets the value of the onBoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isOnBoot() {
        return onBoot;
    }

    /**
     * Sets the value of the onBoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBoot(Boolean value) {
        this.onBoot = value;
    }

    public boolean isSetOnBoot() {
        return (this.onBoot!= null);
    }

}
