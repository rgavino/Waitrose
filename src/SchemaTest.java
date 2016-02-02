//package com.xmlunit.tutorial.comparison;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
 
import org.custommonkey.xmlunit.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 
public class SchemaTest extends junit.framework.TestCase {
 
    String myXmlSchemaFile = "/var/lib/jenkins/workspace/test/src/oata/myXML.xsd";
    String myXmlDocument = "/var/lib/jenkins/workspace/test/src/oata/myXML.xml";

    public void testXMLSchemaDefinition() {
    }
    
    public void testWillAlwaysFail() {
        //fail("An error message - forcing a fail"); 
    }

    public void testXMLagainstSchema() {
 
        try {
          InputSource is = new InputSource(new FileInputStream(myXmlDocument));
          Validator v = new Validator(is);
          v.useXMLSchema(true);
          v.setJAXP12SchemaSource(new File(myXmlSchemaFile));
          assertTrue(v.toString(), v.isValid());
        } catch (Exception e) {
            e.printStackTrace();
        }
                //fail("An error message - forcing a fail"); 
    }

    public void testXMLagainstDTD() {
        //fail("An error message - forcing a fail"); 
    }



}