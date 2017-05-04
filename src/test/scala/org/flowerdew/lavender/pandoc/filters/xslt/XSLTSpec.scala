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

package org.flowerdew.lavender.pandoc.filters.xslt

import org.flowerdew.lavender._
import org.scalatest._
import org.scalatest.Matchers._
import java.io._
import org.json._

class XSLTSpec extends BaseSpec {
  describe("XSLT") {
    it("should have constructor") {
      new XSLT() should not be (null)
    }

    it("should have a XSLT factory") {
      XSLT.factory should not be (null)
    }
  }

  describe("XSLT Transforms") {
    val loremXML = io.Source.fromInputStream(getClass.getResourceAsStream("/xml/lorem.xml")).mkString

    it("should transform sending results to standard out") {
      // set up
      val output = new ByteArrayOutputStream(400)
      System.setOut(new PrintStream(output, true))

      // test
      System.setIn(new ByteArrayInputStream(loremXML.getBytes("UTF-8")))
      new XSLT().transform(getClass.getResourceAsStream("/xsl/lorem.xsl"))

      // check
      output.toString("utf8") should include ("<c>*</c>")
    }
  }
}
