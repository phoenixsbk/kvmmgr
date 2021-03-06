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
 * <p>Java class for AffinityGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AffinityGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}cluster"/>
 *         &lt;element name="positive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enforcing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AffinityGroup", propOrder = {
    "cluster",
    "positive",
    "enforcing"
})
public class AffinityGroup
    extends BaseResource
{

    @XmlElement(required = true)
    protected Cluster cluster;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean positive;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean enforcing;

    /**
     * Gets the value of the cluster property.
     * 
     * @return
     *     possible object is
     *     {@link Cluster }
     *     
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cluster }
     *     
     */
    public void setCluster(Cluster value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

    /**
     * Gets the value of the positive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isPositive() {
        return positive;
    }

    /**
     * Sets the value of the positive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositive(Boolean value) {
        this.positive = value;
    }

    public boolean isSetPositive() {
        return (this.positive!= null);
    }

    /**
     * Gets the value of the enforcing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isEnforcing() {
        return enforcing;
    }

    /**
     * Sets the value of the enforcing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnforcing(Boolean value) {
        this.enforcing = value;
    }

    public boolean isSetEnforcing() {
        return (this.enforcing!= null);
    }

}
