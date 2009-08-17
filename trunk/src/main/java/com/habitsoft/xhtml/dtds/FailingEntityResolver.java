package com.habitsoft.xhtml.dtds;

import java.io.IOException;

import org.junit.Assert;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FailingEntityResolver implements EntityResolver {

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        Assert.fail("Entity should have been resolved from the cache: "+systemId);
        return null;
    }

}
