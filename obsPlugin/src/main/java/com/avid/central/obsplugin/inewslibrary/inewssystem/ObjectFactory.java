
package com.avid.central.obsplugin.inewslibrary.inewssystem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the inewssystem package. 
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

    private final static QName _GetChangedQueues_QNAME = new QName("http://avid.com/inewssystem/types", "GetChangedQueues");
    private final static QName _SendMessage_QNAME = new QName("http://avid.com/inewssystem/types", "SendMessage");
    private final static QName _SendMessageResponse_QNAME = new QName("http://avid.com/inewssystem/types", "SendMessageResponse");
    private final static QName _Disconnect_QNAME = new QName("http://avid.com/inewssystem/types", "Disconnect");
    private final static QName _DisconnectResponse_QNAME = new QName("http://avid.com/inewssystem/types", "DisconnectResponse");
    private final static QName _GetMessageResponse_QNAME = new QName("http://avid.com/inewssystem/types", "GetMessageResponse");
    private final static QName _RetrieveSearchResults_QNAME = new QName("http://avid.com/inewssystem/types", "RetrieveSearchResults");
    private final static QName _PerformSimpleSearch_QNAME = new QName("http://avid.com/inewssystem/types", "PerformSimpleSearch");
    private final static QName _RegisterNotificationService_QNAME = new QName("http://avid.com/inewssystem/types", "RegisterNotificationService");
    private final static QName _HasNewMessageResponse_QNAME = new QName("http://avid.com/inewssystem/types", "HasNewMessageResponse");
    private final static QName _RemoveWatchForQueueChanges_QNAME = new QName("http://avid.com/inewssystem/types", "RemoveWatchForQueueChanges");
    private final static QName _GetQueuesForm_QNAME = new QName("http://avid.com/inewssystem/types", "GetQueuesForm");
    private final static QName _GetChangedQueuesResponse_QNAME = new QName("http://avid.com/inewssystem/types", "GetChangedQueuesResponse");
    private final static QName _RemoveWatchForQueueChangesResponse_QNAME = new QName("http://avid.com/inewssystem/types", "RemoveWatchForQueueChangesResponse");
    private final static QName _ConnectResponse_QNAME = new QName("http://avid.com/inewssystem/types", "ConnectResponse");
    private final static QName _GetQueuesFormResponse_QNAME = new QName("http://avid.com/inewssystem/types", "GetQueuesFormResponse");
    private final static QName _GetMessage_QNAME = new QName("http://avid.com/inewssystem/types", "GetMessage");
    private final static QName _RetrieveSearchResultsResponse_QNAME = new QName("http://avid.com/inewssystem/types", "RetrieveSearchResultsResponse");
    private final static QName _IsConnected_QNAME = new QName("http://avid.com/inewssystem/types", "IsConnected");
    private final static QName _WatchQueueForChanges_QNAME = new QName("http://avid.com/inewssystem/types", "WatchQueueForChanges");
    private final static QName _PerformSimpleSearchResponse_QNAME = new QName("http://avid.com/inewssystem/types", "PerformSimpleSearchResponse");
    private final static QName _IsConnectedResponse_QNAME = new QName("http://avid.com/inewssystem/types", "IsConnectedResponse");
    private final static QName _HasNewMessage_QNAME = new QName("http://avid.com/inewssystem/types", "HasNewMessage");
    private final static QName _GetFolderChildren_QNAME = new QName("http://avid.com/inewssystem/types", "GetFolderChildren");
    private final static QName _RegisterNotificationServiceResponse_QNAME = new QName("http://avid.com/inewssystem/types", "RegisterNotificationServiceResponse");
    private final static QName _WatchQueueForChangesResponse_QNAME = new QName("http://avid.com/inewssystem/types", "WatchQueueForChangesResponse");
    private final static QName _CancelSearchResponse_QNAME = new QName("http://avid.com/inewssystem/types", "CancelSearchResponse");
    private final static QName _CancelSearch_QNAME = new QName("http://avid.com/inewssystem/types", "CancelSearch");
    private final static QName _GetFolderChildrenResponse_QNAME = new QName("http://avid.com/inewssystem/types", "GetFolderChildrenResponse");
    private final static QName _Connect_QNAME = new QName("http://avid.com/inewssystem/types", "Connect");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: inewssystem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveSearchResultsFaultType }
     * 
     */
    public RetrieveSearchResultsFaultType createRetrieveSearchResultsFaultType() {
        return new RetrieveSearchResultsFaultType();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link RemoveWatchForQueueChangesResponseType }
     * 
     */
    public RemoveWatchForQueueChangesResponseType createRemoveWatchForQueueChangesResponseType() {
        return new RemoveWatchForQueueChangesResponseType();
    }

    /**
     * Create an instance of {@link ConnectResponseType }
     * 
     */
    public ConnectResponseType createConnectResponseType() {
        return new ConnectResponseType();
    }

    /**
     * Create an instance of {@link GetQueuesFormResponseType }
     * 
     */
    public GetQueuesFormResponseType createGetQueuesFormResponseType() {
        return new GetQueuesFormResponseType();
    }

    /**
     * Create an instance of {@link RegisterNotificationServiceFaultType }
     * 
     */
    public RegisterNotificationServiceFaultType createRegisterNotificationServiceFaultType() {
        return new RegisterNotificationServiceFaultType();
    }

    /**
     * Create an instance of {@link GetQueuesFormType }
     * 
     */
    public GetQueuesFormType createGetQueuesFormType() {
        return new GetQueuesFormType();
    }

    /**
     * Create an instance of {@link GetChangedQueuesResponseType }
     * 
     */
    public GetChangedQueuesResponseType createGetChangedQueuesResponseType() {
        return new GetChangedQueuesResponseType();
    }

    /**
     * Create an instance of {@link SendMessageResponseType }
     * 
     */
    public SendMessageResponseType createSendMessageResponseType() {
        return new SendMessageResponseType();
    }

    /**
     * Create an instance of {@link DisconnectType }
     * 
     */
    public DisconnectType createDisconnectType() {
        return new DisconnectType();
    }

    /**
     * Create an instance of {@link DisconnectResponseType }
     * 
     */
    public DisconnectResponseType createDisconnectResponseType() {
        return new DisconnectResponseType();
    }

    /**
     * Create an instance of {@link GetMessageResponseType }
     * 
     */
    public GetMessageResponseType createGetMessageResponseType() {
        return new GetMessageResponseType();
    }

    /**
     * Create an instance of {@link RetrieveSearchResultsType }
     * 
     */
    public RetrieveSearchResultsType createRetrieveSearchResultsType() {
        return new RetrieveSearchResultsType();
    }

    /**
     * Create an instance of {@link PerformSimpleSearchType }
     * 
     */
    public PerformSimpleSearchType createPerformSimpleSearchType() {
        return new PerformSimpleSearchType();
    }

    /**
     * Create an instance of {@link RegisterNotificationServiceType }
     * 
     */
    public RegisterNotificationServiceType createRegisterNotificationServiceType() {
        return new RegisterNotificationServiceType();
    }

    /**
     * Create an instance of {@link HasNewMessageResponseType }
     * 
     */
    public HasNewMessageResponseType createHasNewMessageResponseType() {
        return new HasNewMessageResponseType();
    }

    /**
     * Create an instance of {@link RemoveWatchForQueueChangesType }
     * 
     */
    public RemoveWatchForQueueChangesType createRemoveWatchForQueueChangesType() {
        return new RemoveWatchForQueueChangesType();
    }

    /**
     * Create an instance of {@link GetChangedQueuesType }
     * 
     */
    public GetChangedQueuesType createGetChangedQueuesType() {
        return new GetChangedQueuesType();
    }

    /**
     * Create an instance of {@link SendMessageType }
     * 
     */
    public SendMessageType createSendMessageType() {
        return new SendMessageType();
    }

    /**
     * Create an instance of {@link CancelSearchType }
     * 
     */
    public CancelSearchType createCancelSearchType() {
        return new CancelSearchType();
    }

    /**
     * Create an instance of {@link GetFolderChildrenResponseType }
     * 
     */
    public GetFolderChildrenResponseType createGetFolderChildrenResponseType() {
        return new GetFolderChildrenResponseType();
    }

    /**
     * Create an instance of {@link ConnectType }
     * 
     */
    public ConnectType createConnectType() {
        return new ConnectType();
    }

    /**
     * Create an instance of {@link GetFolderChildrenType }
     * 
     */
    public GetFolderChildrenType createGetFolderChildrenType() {
        return new GetFolderChildrenType();
    }

    /**
     * Create an instance of {@link GetQueuesFormFaultType }
     * 
     */
    public GetQueuesFormFaultType createGetQueuesFormFaultType() {
        return new GetQueuesFormFaultType();
    }

    /**
     * Create an instance of {@link GetFolderChildrenFaultType }
     * 
     */
    public GetFolderChildrenFaultType createGetFolderChildrenFaultType() {
        return new GetFolderChildrenFaultType();
    }

    /**
     * Create an instance of {@link RegisterNotificationServiceResponseType }
     * 
     */
    public RegisterNotificationServiceResponseType createRegisterNotificationServiceResponseType() {
        return new RegisterNotificationServiceResponseType();
    }

    /**
     * Create an instance of {@link WatchQueueForChangesResponseType }
     * 
     */
    public WatchQueueForChangesResponseType createWatchQueueForChangesResponseType() {
        return new WatchQueueForChangesResponseType();
    }

    /**
     * Create an instance of {@link CancelSearchResponseType }
     * 
     */
    public CancelSearchResponseType createCancelSearchResponseType() {
        return new CancelSearchResponseType();
    }

    /**
     * Create an instance of {@link SendMessageFaultType }
     * 
     */
    public SendMessageFaultType createSendMessageFaultType() {
        return new SendMessageFaultType();
    }

    /**
     * Create an instance of {@link WatchQueueForChangesType }
     * 
     */
    public WatchQueueForChangesType createWatchQueueForChangesType() {
        return new WatchQueueForChangesType();
    }

    /**
     * Create an instance of {@link PerformSimpleSearchResponseType }
     * 
     */
    public PerformSimpleSearchResponseType createPerformSimpleSearchResponseType() {
        return new PerformSimpleSearchResponseType();
    }

    /**
     * Create an instance of {@link IsConnectedResponseType }
     * 
     */
    public IsConnectedResponseType createIsConnectedResponseType() {
        return new IsConnectedResponseType();
    }

    /**
     * Create an instance of {@link HasNewMessageType }
     * 
     */
    public HasNewMessageType createHasNewMessageType() {
        return new HasNewMessageType();
    }

    /**
     * Create an instance of {@link PerformSimpleSearchFaultType }
     * 
     */
    public PerformSimpleSearchFaultType createPerformSimpleSearchFaultType() {
        return new PerformSimpleSearchFaultType();
    }

    /**
     * Create an instance of {@link WatchQueueForChangesFaultType }
     * 
     */
    public WatchQueueForChangesFaultType createWatchQueueForChangesFaultType() {
        return new WatchQueueForChangesFaultType();
    }

    /**
     * Create an instance of {@link ConnectionFaultType }
     * 
     */
    public ConnectionFaultType createConnectionFaultType() {
        return new ConnectionFaultType();
    }

    /**
     * Create an instance of {@link GetMessageType }
     * 
     */
    public GetMessageType createGetMessageType() {
        return new GetMessageType();
    }

    /**
     * Create an instance of {@link RetrieveSearchResultsResponseType }
     * 
     */
    public RetrieveSearchResultsResponseType createRetrieveSearchResultsResponseType() {
        return new RetrieveSearchResultsResponseType();
    }

    /**
     * Create an instance of {@link IsConnectedType }
     * 
     */
    public IsConnectedType createIsConnectedType() {
        return new IsConnectedType();
    }

    /**
     * Create an instance of {@link DirectoryType }
     * 
     */
    public DirectoryType createDirectoryType() {
        return new DirectoryType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChangedQueuesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetChangedQueues")
    public JAXBElement<GetChangedQueuesType> createGetChangedQueues(GetChangedQueuesType value) {
        return new JAXBElement<GetChangedQueuesType>(_GetChangedQueues_QNAME, GetChangedQueuesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "SendMessage")
    public JAXBElement<SendMessageType> createSendMessage(SendMessageType value) {
        return new JAXBElement<SendMessageType>(_SendMessage_QNAME, SendMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "SendMessageResponse")
    public JAXBElement<SendMessageResponseType> createSendMessageResponse(SendMessageResponseType value) {
        return new JAXBElement<SendMessageResponseType>(_SendMessageResponse_QNAME, SendMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "Disconnect")
    public JAXBElement<DisconnectType> createDisconnect(DisconnectType value) {
        return new JAXBElement<DisconnectType>(_Disconnect_QNAME, DisconnectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "DisconnectResponse")
    public JAXBElement<DisconnectResponseType> createDisconnectResponse(DisconnectResponseType value) {
        return new JAXBElement<DisconnectResponseType>(_DisconnectResponse_QNAME, DisconnectResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetMessageResponse")
    public JAXBElement<GetMessageResponseType> createGetMessageResponse(GetMessageResponseType value) {
        return new JAXBElement<GetMessageResponseType>(_GetMessageResponse_QNAME, GetMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveSearchResultsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "RetrieveSearchResults")
    public JAXBElement<RetrieveSearchResultsType> createRetrieveSearchResults(RetrieveSearchResultsType value) {
        return new JAXBElement<RetrieveSearchResultsType>(_RetrieveSearchResults_QNAME, RetrieveSearchResultsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PerformSimpleSearchType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "PerformSimpleSearch")
    public JAXBElement<PerformSimpleSearchType> createPerformSimpleSearch(PerformSimpleSearchType value) {
        return new JAXBElement<PerformSimpleSearchType>(_PerformSimpleSearch_QNAME, PerformSimpleSearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterNotificationServiceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "RegisterNotificationService")
    public JAXBElement<RegisterNotificationServiceType> createRegisterNotificationService(RegisterNotificationServiceType value) {
        return new JAXBElement<RegisterNotificationServiceType>(_RegisterNotificationService_QNAME, RegisterNotificationServiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasNewMessageResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "HasNewMessageResponse")
    public JAXBElement<HasNewMessageResponseType> createHasNewMessageResponse(HasNewMessageResponseType value) {
        return new JAXBElement<HasNewMessageResponseType>(_HasNewMessageResponse_QNAME, HasNewMessageResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveWatchForQueueChangesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "RemoveWatchForQueueChanges")
    public JAXBElement<RemoveWatchForQueueChangesType> createRemoveWatchForQueueChanges(RemoveWatchForQueueChangesType value) {
        return new JAXBElement<RemoveWatchForQueueChangesType>(_RemoveWatchForQueueChanges_QNAME, RemoveWatchForQueueChangesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQueuesFormType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetQueuesForm")
    public JAXBElement<GetQueuesFormType> createGetQueuesForm(GetQueuesFormType value) {
        return new JAXBElement<GetQueuesFormType>(_GetQueuesForm_QNAME, GetQueuesFormType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChangedQueuesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetChangedQueuesResponse")
    public JAXBElement<GetChangedQueuesResponseType> createGetChangedQueuesResponse(GetChangedQueuesResponseType value) {
        return new JAXBElement<GetChangedQueuesResponseType>(_GetChangedQueuesResponse_QNAME, GetChangedQueuesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveWatchForQueueChangesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "RemoveWatchForQueueChangesResponse")
    public JAXBElement<RemoveWatchForQueueChangesResponseType> createRemoveWatchForQueueChangesResponse(RemoveWatchForQueueChangesResponseType value) {
        return new JAXBElement<RemoveWatchForQueueChangesResponseType>(_RemoveWatchForQueueChangesResponse_QNAME, RemoveWatchForQueueChangesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "ConnectResponse")
    public JAXBElement<ConnectResponseType> createConnectResponse(ConnectResponseType value) {
        return new JAXBElement<ConnectResponseType>(_ConnectResponse_QNAME, ConnectResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQueuesFormResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetQueuesFormResponse")
    public JAXBElement<GetQueuesFormResponseType> createGetQueuesFormResponse(GetQueuesFormResponseType value) {
        return new JAXBElement<GetQueuesFormResponseType>(_GetQueuesFormResponse_QNAME, GetQueuesFormResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetMessage")
    public JAXBElement<GetMessageType> createGetMessage(GetMessageType value) {
        return new JAXBElement<GetMessageType>(_GetMessage_QNAME, GetMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveSearchResultsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "RetrieveSearchResultsResponse")
    public JAXBElement<RetrieveSearchResultsResponseType> createRetrieveSearchResultsResponse(RetrieveSearchResultsResponseType value) {
        return new JAXBElement<RetrieveSearchResultsResponseType>(_RetrieveSearchResultsResponse_QNAME, RetrieveSearchResultsResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsConnectedType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "IsConnected")
    public JAXBElement<IsConnectedType> createIsConnected(IsConnectedType value) {
        return new JAXBElement<IsConnectedType>(_IsConnected_QNAME, IsConnectedType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchQueueForChangesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "WatchQueueForChanges")
    public JAXBElement<WatchQueueForChangesType> createWatchQueueForChanges(WatchQueueForChangesType value) {
        return new JAXBElement<WatchQueueForChangesType>(_WatchQueueForChanges_QNAME, WatchQueueForChangesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PerformSimpleSearchResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "PerformSimpleSearchResponse")
    public JAXBElement<PerformSimpleSearchResponseType> createPerformSimpleSearchResponse(PerformSimpleSearchResponseType value) {
        return new JAXBElement<PerformSimpleSearchResponseType>(_PerformSimpleSearchResponse_QNAME, PerformSimpleSearchResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsConnectedResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "IsConnectedResponse")
    public JAXBElement<IsConnectedResponseType> createIsConnectedResponse(IsConnectedResponseType value) {
        return new JAXBElement<IsConnectedResponseType>(_IsConnectedResponse_QNAME, IsConnectedResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasNewMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "HasNewMessage")
    public JAXBElement<HasNewMessageType> createHasNewMessage(HasNewMessageType value) {
        return new JAXBElement<HasNewMessageType>(_HasNewMessage_QNAME, HasNewMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFolderChildrenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetFolderChildren")
    public JAXBElement<GetFolderChildrenType> createGetFolderChildren(GetFolderChildrenType value) {
        return new JAXBElement<GetFolderChildrenType>(_GetFolderChildren_QNAME, GetFolderChildrenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterNotificationServiceResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "RegisterNotificationServiceResponse")
    public JAXBElement<RegisterNotificationServiceResponseType> createRegisterNotificationServiceResponse(RegisterNotificationServiceResponseType value) {
        return new JAXBElement<RegisterNotificationServiceResponseType>(_RegisterNotificationServiceResponse_QNAME, RegisterNotificationServiceResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchQueueForChangesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "WatchQueueForChangesResponse")
    public JAXBElement<WatchQueueForChangesResponseType> createWatchQueueForChangesResponse(WatchQueueForChangesResponseType value) {
        return new JAXBElement<WatchQueueForChangesResponseType>(_WatchQueueForChangesResponse_QNAME, WatchQueueForChangesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelSearchResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "CancelSearchResponse")
    public JAXBElement<CancelSearchResponseType> createCancelSearchResponse(CancelSearchResponseType value) {
        return new JAXBElement<CancelSearchResponseType>(_CancelSearchResponse_QNAME, CancelSearchResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelSearchType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "CancelSearch")
    public JAXBElement<CancelSearchType> createCancelSearch(CancelSearchType value) {
        return new JAXBElement<CancelSearchType>(_CancelSearch_QNAME, CancelSearchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFolderChildrenResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "GetFolderChildrenResponse")
    public JAXBElement<GetFolderChildrenResponseType> createGetFolderChildrenResponse(GetFolderChildrenResponseType value) {
        return new JAXBElement<GetFolderChildrenResponseType>(_GetFolderChildrenResponse_QNAME, GetFolderChildrenResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewssystem/types", name = "Connect")
    public JAXBElement<ConnectType> createConnect(ConnectType value) {
        return new JAXBElement<ConnectType>(_Connect_QNAME, ConnectType.class, null, value);
    }

}
