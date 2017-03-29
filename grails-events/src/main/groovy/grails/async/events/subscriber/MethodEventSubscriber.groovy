package grails.async.events.subscriber

import grails.async.events.Event
import groovy.transform.CompileStatic

import java.lang.reflect.Method

/**
 * A method subscribers for methods that accept an event argument
 *
 * @author Graeme Rocher
 * @since 3.3
 */
@CompileStatic
class MethodEventSubscriber extends MethodSubscriber implements EventSubscriber {
    MethodEventSubscriber(Object target, Method method) {
        super(target, method)
        if( !(parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(grails.async.events.Event)) ) {
            throw new IllegalArgumentException("Specified method must accept an Event as an argument")
        }
    }
}