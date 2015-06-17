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
 * <p>Java class for CloudInit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CloudInit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}authorized_keys" minOccurs="0"/>
 *         &lt;element ref="{}network_configuration" minOccurs="0"/>
 *         &lt;element name="regenerate_ssh_keys" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}users" minOccurs="0"/>
 *         &lt;element ref="{}files" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CloudInit", propOrder = {
    "host",
    "authorizedKeys",
    "networkConfiguration",
    "regenerateSshKeys",
    "timezone",
    "users",
    "files"
})
public class CloudInit {

    protected Host host;
    @XmlElement(name = "authorized_keys")
    protected AuthorizedKeys authorizedKeys;
    @XmlElement(name = "network_configuration")
    protected NetworkConfiguration networkConfiguration;
    @XmlElement(name = "regenerate_ssh_keys", type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "boolean")
    protected Boolean regenerateSshKeys;
    protected String timezone;
    protected Users users;
    protected Files files;

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link Host }
     *     
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link Host }
     *     
     */
    public void setHost(Host value) {
        this.host = value;
    }

    public boolean isSetHost() {
        return (this.host!= null);
    }

    /**
     * Gets the value of the authorizedKeys property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizedKeys }
     *     
     */
    public AuthorizedKeys getAuthorizedKeys() {
        return authorizedKeys;
    }

    /**
     * Sets the value of the authorizedKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizedKeys }
     *     
     */
    public void setAuthorizedKeys(AuthorizedKeys value) {
        this.authorizedKeys = value;
    }

    public boolean isSetAuthorizedKeys() {
        return (this.authorizedKeys!= null);
    }

    /**
     * Gets the value of the networkConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkConfiguration }
     *     
     */
    public NetworkConfiguration getNetworkConfiguration() {
        return networkConfiguration;
    }

    /**
     * Sets the value of the networkConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkConfiguration }
     *     
     */
    public void setNetworkConfiguration(NetworkConfiguration value) {
        this.networkConfiguration = value;
    }

    public boolean isSetNetworkConfiguration() {
        return (this.networkConfiguration!= null);
    }

    /**
     * Gets the value of the regenerateSshKeys property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Boolean isRegenerateSshKeys() {
        return regenerateSshKeys;
    }

    /**
     * Sets the value of the regenerateSshKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegenerateSshKeys(Boolean value) {
        this.regenerateSshKeys = value;
    }

    public boolean isSetRegenerateSshKeys() {
        return (this.regenerateSshKeys!= null);
    }

    /**
     * Gets the value of the timezone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    public boolean isSetTimezone() {
        return (this.timezone!= null);
    }

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link Users }
     *     
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link Users }
     *     
     */
    public void setUsers(Users value) {
        this.users = value;
    }

    public boolean isSetUsers() {
        return (this.users!= null);
    }

    /**
     * Gets the value of the files property.
     * 
     * @return
     *     possible object is
     *     {@link Files }
     *     
     */
    public Files getFiles() {
        return files;
    }

    /**
     * Sets the value of the files property.
     * 
     * @param value
     *     allowed object is
     *     {@link Files }
     *     
     */
    public void setFiles(Files value) {
        this.files = value;
    }

    public boolean isSetFiles() {
        return (this.files!= null);
    }

}