package org.test.rest;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.rest.annotations.MethodMapping;
import org.wicketstuff.rest.annotations.ResourcePath;
import org.wicketstuff.rest.contenthandling.json.webserialdeserial.GsonWebSerialDeserial;
import org.wicketstuff.rest.contenthandling.mimetypes.RestMimeTypes;
import org.wicketstuff.rest.resource.AbstractRestResource;

@ResourcePath("/mountedpath")
public class RestTest extends AbstractRestResource<GsonWebSerialDeserial> {
    
    @SpringBean
    private String injectedValue;
    
    public RestTest() {
        super(new GsonWebSerialDeserial());
    }
    
    @MethodMapping(value = "/value", produces = RestMimeTypes.TEXT_PLAIN)
    public String getAllPersons() {
        return injectedValue;
    }
}
