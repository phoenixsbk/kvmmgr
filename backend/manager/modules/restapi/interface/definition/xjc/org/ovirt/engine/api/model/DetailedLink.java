//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.13 at 03:17:43 PM CST 
//


package org.ovirt.engine.api.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DetailedLink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetailedLink">
 *   &lt;complexContent>
 *     &lt;extension base="{}Link">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}request" minOccurs="0"/>
 *         &lt;element ref="{}response" minOccurs="0"/>
 *         &lt;element ref="{}linkCapabilities" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetailedLink", propOrder = {
    "description",
    "request",
    "response",
    "linkCapabilities"
})
@XmlSeeAlso({
    GeneralMetadata.class
})
public class DetailedLink
    extends Link
{

    protected String description;
    protected Request request;
    protected Response response;
    protected LinkCapabilities linkCapabilities;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link Request }
     *     
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link Request }
     *     
     */
    public void setRequest(Request value) {
        this.request = value;
    }

    public boolean isSetRequest() {
        return (this.request!= null);
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link Response }
     *     
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link Response }
     *     
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    public boolean isSetResponse() {
        return (this.response!= null);
    }

    /**
     * Gets the value of the linkCapabilities property.
     * 
     * @return
     *     possible object is
     *     {@link LinkCapabilities }
     *     
     */
    public LinkCapabilities getLinkCapabilities() {
        return linkCapabilities;
    }

    /**
     * Sets the value of the linkCapabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkCapabilities }
     *     
     */
    public void setLinkCapabilities(LinkCapabilities value) {
        this.linkCapabilities = value;
    }

    public boolean isSetLinkCapabilities() {
        return (this.linkCapabilities!= null);
    }

}
