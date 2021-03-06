//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.13 at 03:17:43 PM CST 
//


package org.ovirt.engine.api.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Version complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Version">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;attribute name="major" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="minor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="build" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="revision" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" />
 *       &lt;attribute name="full_version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version")
@XmlSeeAlso({
    VersionCaps.class
})
public class Version
    extends BaseResource
{

    @XmlAttribute(name = "major")
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "unsignedShort")
    protected Integer major;
    @XmlAttribute(name = "minor")
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "unsignedShort")
    protected Integer minor;
    @XmlAttribute(name = "build")
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "unsignedShort")
    protected Integer build;
    @XmlAttribute(name = "revision")
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "unsignedShort")
    protected Integer revision;
    @XmlAttribute(name = "full_version")
    protected String fullVersion;

    /**
     * Gets the value of the major property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMajor() {
        return major;
    }

    /**
     * Sets the value of the major property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajor(Integer value) {
        this.major = value;
    }

    /**
     * Gets the value of the minor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMinor() {
        return minor;
    }

    /**
     * Sets the value of the minor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinor(Integer value) {
        this.minor = value;
    }

    /**
     * Gets the value of the build property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuild(Integer value) {
        this.build = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(Integer value) {
        this.revision = value;
    }

    /**
     * Gets the value of the fullVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullVersion() {
        return fullVersion;
    }

    /**
     * Sets the value of the fullVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullVersion(String value) {
        this.fullVersion = value;
    }

}
