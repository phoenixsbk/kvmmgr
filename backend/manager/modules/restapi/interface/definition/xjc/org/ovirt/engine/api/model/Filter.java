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
 * <p>Java class for Filter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Filter">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}scheduling_policy_unit" minOccurs="0"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filter", propOrder = {
    "schedulingPolicyUnit",
    "position"
})
public class Filter
    extends BaseResource
{

    @XmlElement(name = "scheduling_policy_unit")
    protected SchedulingPolicyUnit schedulingPolicyUnit;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "int")
    protected Integer position;

    /**
     * Gets the value of the schedulingPolicyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link SchedulingPolicyUnit }
     *     
     */
    public SchedulingPolicyUnit getSchedulingPolicyUnit() {
        return schedulingPolicyUnit;
    }

    /**
     * Sets the value of the schedulingPolicyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicyUnit }
     *     
     */
    public void setSchedulingPolicyUnit(SchedulingPolicyUnit value) {
        this.schedulingPolicyUnit = value;
    }

    public boolean isSetSchedulingPolicyUnit() {
        return (this.schedulingPolicyUnit!= null);
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(Integer value) {
        this.position = value;
    }

    public boolean isSetPosition() {
        return (this.position!= null);
    }

}
