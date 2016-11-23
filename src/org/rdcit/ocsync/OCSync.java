package org.rdcit.ocsync;

import java.io.File;
import java.io.IOException;
//import java.io.StringReader;

//import javax.swing.text.Document;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
























import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.rdcit.ocsync.models.odmnodes.ODMNode;

//import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OCSync {




	
	public static void main(String[] args) {
		
		  DocumentBuilderFactory domFactory = 
				  DocumentBuilderFactory.newInstance();
				  domFactory.setNamespaceAware(true); 
				  DocumentBuilder builder = null;
				try {
					builder = domFactory.newDocumentBuilder();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  Document doc=null;;
				try {
					doc = builder.parse("C:\\Download\\mothership_empty.xml");
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  XPath xpath = XPathFactory.newInstance().newXPath();
		

        
        
				  NodeList study=null;
        try {
			study = (NodeList) xpath.evaluate("//Study", doc, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        


		
	}

}
