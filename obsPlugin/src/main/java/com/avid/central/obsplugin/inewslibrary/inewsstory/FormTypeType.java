
package com.avid.central.obsplugin.inewslibrary.inewsstory;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FormTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FormTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Queue"/>
 *     &lt;enumeration value="Story"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FormTypeType")
@XmlEnum
public enum FormTypeType {

    @XmlEnumValue("Queue")
    QUEUE("Queue"),
    @XmlEnumValue("Story")
    STORY("Story");
    private final String value;

    FormTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FormTypeType fromValue(String v) {
        for (FormTypeType c: FormTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
