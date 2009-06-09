package com.habitsoft.xhtml.dtds;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.Test;


public class TestXhtmlEntityResolver {

    @Test
    public void testResolver() throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        documentBuilder.setEntityResolver(new XhtmlEntityResolver(new FailingEntityResolver()));
        documentBuilder.parse(getClass().getResource("sample.xhtml").toString());
    }
    
    @Test
    public void testResolverStrict() throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        documentBuilder.setEntityResolver(new XhtmlEntityResolver(new FailingEntityResolver()));
        documentBuilder.parse(getClass().getResource("sample-strict.xhtml").toString());
    }

    @Test
    public void testResolverMissingFile() throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        documentBuilder.setEntityResolver(new XhtmlEntityResolver(new FailingEntityResolver()));
        try {
            documentBuilder.parse(getClass().getResource("sample-missing.xhtml").toString());
            Assert.fail("Should have failed to find the DTD!");
        } catch(AssertionError ae) {
            assert ae.getMessage().startsWith("Entity should have been resolved from the cache");            
        }
    }
    
}
