
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectoryTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DirectoryTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Queue"/>
 *     &lt;enumeration value="Folder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DirectoryTypeType")
@XmlEnum
public enum DirectoryTypeType {

    @XmlEnumValue("Queue")
    QUEUE("Queue"),
    @XmlEnumValue("Folder")
    FOLDER("Folder");
    private final String value;

    DirectoryTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DirectoryTypeType fromValue(String v) {
        for (DirectoryTypeType c: DirectoryTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
