
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the interplaylibrary.infrastructure package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetConfigurationInformation_QNAME = new QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformation");
    private final static QName _GetConfigurationInformationResponse_QNAME = new QName("http://avid.com/interplay/ws/infrastructure/types", "GetConfigurationInformationResponse");
    private final static QName _GetVersionInformation_QNAME = new QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformation");
    private final static QName _GetVersionInformationResponse_QNAME = new QName("http://avid.com/interplay/ws/infrastructure/types", "GetVersionInformationResponse");
    private final static QName _UserCredentials_QNAME = new QName("http://avid.com/interplay/ws/assets/types", "UserCredentials");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: interplaylibrary.infrastructure
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConfigurationInformationType }
     * 
     */
    public GetConfigurationInformationType createGetConfigurationInformationType() {
        return new GetConfigurationInformationType();
    }

    /**
     * Create an instance of {@link GetConfigurationInformationResponseType }
     * 
     */
    public GetConfigurationInformationResponseType createGetConfigurationInformationResponseType() {
        return new GetConfigurationInformationResponseType();
    }

    /**
     * Create an instance of {@link GetVersionInformationType }
     * 
     */
    public GetVersionInformationType createGetVersionInformationType() {
        return new GetVersionInformationType();
    }

    /**
     * Create an instance of {@link GetVersionInformationResponseType }
     * 
     */
    public GetVersionInformationResponseType createGetVersionInformationResponseType() {
        return new GetVersionInformationResponseType();
    }

    /**
     * Create an instance of {@link InfrastructureFaultType }
     * 
     */
    public InfrastructureFaultType createInfrastructureFaultType() {
        return new InfrastructureFaultType();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link WorkGroupDetailsListType }
     * 
     */
    public WorkGroupDetailsListType createWorkGroupDetailsListType() {
        return new WorkGroupDetailsListType();
    }

    /**
     * Create an instance of {@link WorkGroupDetailsType }
     * 
     */
    public WorkGroupDetailsType createWorkGroupDetailsType() {
        return new WorkGroupDetailsType();
    }

    /**
     * Create an instance of {@link WorkgroupListType }
     * 
     */
    public WorkgroupListType createWorkgroupListType() {
        return new WorkgroupListType();
    }

    /**
     * Create an instance of {@link WorkgroupType }
     * 
     */
    public WorkgroupType createWorkgroupType() {
        return new WorkgroupType();
    }

    /**
     * Create an instance of {@link UserCredentialsType }
     * 
     */
    public UserCredentialsType createUserCredentialsType() {
        return new UserCredentialsType();
    }

    /**
     * Create an instance of {@link FileLocationDetailsListType }
     * 
     */
    public FileLocationDetailsListType createFileLocationDetailsListType() {
        return new FileLocationDetailsListType();
    }

    /**
     * Create an instance of {@link FileLocationDetailsType }
     * 
     */
    public FileLocationDetailsType createFileLocationDetailsType() {
        return new FileLocationDetailsType();
    }

    /**
     * Create an instance of {@link FileLocationListType }
     * 
     */
    public FileLocationListType createFileLocationListType() {
        return new FileLocationListType();
    }

    /**
     * Create an instance of {@link FileLocationType }
     * 
     */
    public FileLocationType createFileLocationType() {
        return new FileLocationType();
    }

    /**
     * Create an instance of {@link AssetDescriptionListType }
     * 
     */
    public AssetDescriptionListType createAssetDescriptionListType() {
        return new AssetDescriptionListType();
    }

    /**
     * Create an instance of {@link AssetDescriptionType }
     * 
     */
    public AssetDescriptionType createAssetDescriptionType() {
        return new AssetDescriptionType();
    }

    /**
     * Create an instance of {@link AttributeType }
     * 
     */
    public AttributeType createAttributeType() {
        return new AttributeType();
    }

    /**
     * Create an instance of {@link AttributeListType }
     * 
     */
    public AttributeListType createAttributeListType() {
        return new AttributeListType();
    }

    /**
     * Create an instance of {@link AttributeConditionType }
     * 
     */
    public AttributeConditionType createAttributeConditionType() {
        return new AttributeConditionType();
    }

    /**
     * Create an instance of {@link CategoryConditionType }
     * 
     */
    public CategoryConditionType createCategoryConditionType() {
        return new CategoryConditionType();
    }

    /**
     * Create an instance of {@link FileInUseConditionType }
     * 
     */
    public FileInUseConditionType createFileInUseConditionType() {
        return new FileInUseConditionType();
    }

    /**
     * Create an instance of {@link ResolutionConditionType }
     * 
     */
    public ResolutionConditionType createResolutionConditionType() {
        return new ResolutionConditionType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link ErrorListType }
     * 
     */
    public ErrorListType createErrorListType() {
        return new ErrorListType();
    }

    /**
     * Create an instance of {@link InterplayURIListType }
     * 
     */
    public InterplayURIListType createInterplayURIListType() {
        return new InterplayURIListType();
    }

    /**
     * Create an instance of {@link SearchGroupType }
     * 
     */
    public SearchGroupType createSearchGroupType() {
        return new SearchGroupType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfigurationInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/interplay/ws/infrastructure/types", name = "GetConfigurationInformation")
    public JAXBElement<GetConfigurationInformationType> createGetConfigurationInformation(GetConfigurationInformationType value) {
        return new JAXBElement<GetConfigurationInformationType>(_GetConfigurationInformation_QNAME, GetConfigurationInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfigurationInformationResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/interplay/ws/infrastructure/types", name = "GetConfigurationInformationResponse")
    public JAXBElement<GetConfigurationInformationResponseType> createGetConfigurationInformationResponse(GetConfigurationInformationResponseType value) {
        return new JAXBElement<GetConfigurationInformationResponseType>(_GetConfigurationInformationResponse_QNAME, GetConfigurationInformationResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/interplay/ws/infrastructure/types", name = "GetVersionInformation")
    public JAXBElement<GetVersionInformationType> createGetVersionInformation(GetVersionInformationType value) {
        return new JAXBElement<GetVersionInformationType>(_GetVersionInformation_QNAME, GetVersionInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionInformationResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/interplay/ws/infrastructure/types", name = "GetVersionInformationResponse")
    public JAXBElement<GetVersionInformationResponseType> createGetVersionInformationResponse(GetVersionInformationResponseType value) {
        return new JAXBElement<GetVersionInformationResponseType>(_GetVersionInformationResponse_QNAME, GetVersionInformationResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserCredentialsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/interplay/ws/assets/types", name = "UserCredentials")
    public JAXBElement<UserCredentialsType> createUserCredentials(UserCredentialsType value) {
        return new JAXBElement<UserCredentialsType>(_UserCredentials_QNAME, UserCredentialsType.class, null, value);
    }

}
