package org.switchyard.component.camel.jms.deploy;

import javax.xml.namespace.QName;

import org.switchyard.common.camel.SwitchYardCamelContext;
import org.switchyard.component.camel.common.composer.CamelComposition;
import org.switchyard.component.camel.common.deploy.BaseBindingActivator;
import org.switchyard.component.camel.common.handler.InboundHandler;
import org.switchyard.component.camel.common.handler.OutboundHandler;
import org.switchyard.component.camel.common.model.CamelBindingModel;
import org.switchyard.component.camel.jms.model.CamelJmsBindingModel;


public class CamelJmsActivator extends BaseBindingActivator {

    /**
     * Creates new activator instance.
     * 
     * @param context Camel context.
     * @param types Activation types.
     */
    public CamelJmsActivator(SwitchYardCamelContext context, String[] types) {
        super(context, types);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected InboundHandler<CamelJmsBindingModel> createInboundHandler(QName serviceName, CamelBindingModel binding) {
        return new CamelJmsInboundHandler((CamelJmsBindingModel)binding, getCamelContext(), serviceName, getServiceDomain());
    }

}