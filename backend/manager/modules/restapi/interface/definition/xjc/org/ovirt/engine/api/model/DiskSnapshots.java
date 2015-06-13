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
 * <p>Java class for DiskSnapshots complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiskSnapshots">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevices">
 *       &lt;sequence>
 *         &lt;element ref="{}disk_snapshot" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiskSnapshots", propOrder = {
    "diskSnapshots"
})
public class DiskSnapshots
    extends BaseDevices
{

    @XmlElement(name = "disk_snapshot")
    protected List<DiskSnapshot> diskSnapshots;

    /**
     * Gets the value of the diskSnapshots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diskSnapshots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiskSnapshots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiskSnapshot }
     * 
     * 
     */
    public List<DiskSnapshot> getDiskSnapshots() {
        if (diskSnapshots == null) {
            diskSnapshots = new ArrayList<DiskSnapshot>();
        }
        return this.diskSnapshots;
    }

    public boolean isSetDiskSnapshots() {
        return ((this.diskSnapshots!= null)&&(!this.diskSnapshots.isEmpty()));
    }

    public void unsetDiskSnapshots() {
        this.diskSnapshots = null;
    }

}
