
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Incomplete"/>
 *     &lt;enumeration value="Done"/>
 *     &lt;enumeration value="Aborted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchStatusType")
@XmlEnum
public enum SearchStatusType {

    @XmlEnumValue("Incomplete")
    INCOMPLETE("Incomplete"),
    @XmlEnumValue("Done")
    DONE("Done"),
    @XmlEnumValue("Aborted")
    ABORTED("Aborted");
    private final String value;

    SearchStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchStatusType fromValue(String v) {
        for (SearchStatusType c: SearchStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
