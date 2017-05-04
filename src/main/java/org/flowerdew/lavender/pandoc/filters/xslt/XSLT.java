/*
 * Copyright 2017 Lavender Flowerdew
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowerdew.lavender.pandoc.filters.xslt;

import net.sf.saxon.jaxp.TransformerImpl;
import net.sf.saxon.tree.util.Orphan;
import net.sf.saxon.type.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLFilterImpl;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URL;
import java.util.Properties;

public class XSLT {
  protected static TransformerFactory factory;

  static {
    System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
    factory = TransformerFactory.newInstance();
  }

  public XSLT() {

  }

  public void transform(InputStream xsl) {
    try {
      Transformer transformer = factory.newTransformer(new StreamSource(xsl, "stylesheet"));
      transformer.transform(new StreamSource(System.in, "input"), new StreamResult(System.out));
    } catch(Exception error) {
      System.err.println("There was an error during transformation.");
      error.printStackTrace();
    }
  }

}
