package com.habitsoft.xhtml.dtds;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;


public class TestXhtmlEntityResolver {

    @Test
    public void testResolver() throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        documentBuilder.setEntityResolver(new XhtmlEntityResolver(new FailingEntityResolver()));
        documentBuilder.parse(getClass().getResource("sample.xhtml").toString());
    }
}
