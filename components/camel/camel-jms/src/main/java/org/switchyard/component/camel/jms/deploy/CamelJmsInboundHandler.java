package org.switchyard.component.camel.jms.deploy;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.ValueBuilder;
import org.apache.camel.impl.ExpressionAdapter;
import org.apache.camel.model.RouteDefinition;
import org.switchyard.ServiceDomain;
import org.switchyard.common.camel.SwitchYardCamelContext;
import org.switchyard.common.type.Classes;
import org.switchyard.component.camel.common.CamelConstants;
import org.switchyard.component.camel.common.handler.InboundHandler;
import org.switchyard.component.camel.common.handler.MessageComposerProcessor;
import org.switchyard.component.camel.common.handler.OperationSelectorProcessor;
import org.switchyard.component.camel.jms.model.CamelJmsBindingModel;
import org.switchyard.runtime.event.ExchangeCompletionEvent;


public class CamelJmsInboundHandler extends InboundHandler<CamelJmsBindingModel> {

    @Resource
    private WebServiceContext _wsContext;
    /**
     * Sole constructor.
     * 
     * @param camelBindingModel The CamelBindingModel.
     * @param camelContext The camel context instance.
     * @param serviceName The target service name.
     * @param domain the service domain.
     */
    public CamelJmsInboundHandler(CamelJmsBindingModel camelBindingModel,
        SwitchYardCamelContext camelContext, QName serviceName, ServiceDomain domain) {
        super(camelBindingModel, camelContext, serviceName, domain);
    }

    @Override
    protected RouteDefinition createRouteDefinition() {
        RouteDefinition route= new RouteDefinition();
        

        route.routeId(getRouteId()).from(getComponentUri().toString());
        addTransactionPolicy(route);
        addNamespacePolicy(route);
        
        route.setProperty(ExchangeCompletionEvent.GATEWAY_NAME).simple(getBindingModel().getName(), String.class)
            .setProperty(CamelConstants.APPLICATION_NAMESPACE).constant(super.getServiceName().getNamespaceURI()).process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					SecureMessage message=SecureMessage.fromRequest(_wsContext, exchange.getIn().getBody());
	            	exchange.getIn().setBody(message);
				}
			})
            .process(new MessageComposerProcessor(getBindingModel()))
            .process(new OperationSelectorProcessor(getServiceName(), getBindingModel()))
            .to(getSwitchyardEndpointUri());

            
        return route;
    }

}