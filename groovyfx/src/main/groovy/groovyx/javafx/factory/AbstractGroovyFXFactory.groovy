package groovyx.javafx.factory

import org.codehaus.groovyfx.javafx.binding.ClosureTriggerBinding
import org.codehaus.groovy.runtime.InvokerHelper

/**
 * An abstract base class from which all other GroovyFX factories should inherit.
 *
 * If a factory overrides the onHandleNodeAttributes method then it should return super.onHandleNodeAttributes(...)
 * at the end of the method. This ensures that the remaining attributes are processed by the default handling code
 * in AbstractGroovyFX Factory.
 *
 * The only exception is when the overriding method processes all possible attributes itself and returns false
 * to indicate that no other processing is required.
 * 
 * @author Dean Iverson (relocated code from SceneGraphBuilder)
 */
abstract class AbstractGroovyFXFactory extends AbstractFactory {
    @Override
    boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
        // set the properties
        // noinspection unchecked
        for (Map.Entry entry : (Set<Map.Entry>) attributes.entrySet()) {
            String property = entry.getKey().toString();
            Object value = entry.getValue();
            if(value instanceof ClosureTriggerBinding) {
                def ctb = (ClosureTriggerBinding)value;
                value = ctb.getSourceValue();
            }
            if(!FXHelper.fxAttribute(node, property, value))
                InvokerHelper.setProperty(node, property, value);
        }
    }
}
