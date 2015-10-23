
package com.avid.central.obsplugin.inewslibrary.inewssystem.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Indexed"/>
 *     &lt;enumeration value="Fast"/>
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Some"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchTypeType")
@XmlEnum
public enum SearchTypeType {

    @XmlEnumValue("Indexed")
    INDEXED("Indexed"),
    @XmlEnumValue("Fast")
    FAST("Fast"),
    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Some")
    SOME("Some");
    private final String value;

    SearchTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchTypeType fromValue(String v) {
        for (SearchTypeType c: SearchTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
