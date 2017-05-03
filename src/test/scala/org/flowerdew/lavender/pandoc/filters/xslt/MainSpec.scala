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

class MainSpec extends BaseSpec {
  describe("Main") {
    it("should print 'hi'") {
      // set up
      val output = new ByteArrayOutputStream(400)
      System.setOut(new PrintStream(output, true))

      // test
      Main.main(Array.empty[String])

      // check
      output.toString("utf8") should equal ("Hi")
    }
  }

  describe("JSON Library") {
    it("should produce XML from JSON string") {
      // set up
      val input = """{"blocks":[{"t":"Para","c":[{"t":"Str","c":"Hello"}]}],"pandoc-api-version":[1,17,0,5],"meta":{}}"""
      val json = new JSONObject(input)
      val expected = """<rootdoc><pandoc-api-version>1</pandoc-api-version><pandoc-api-version>17</pandoc-api-version><pandoc-api-version>0</pandoc-api-version><pandoc-api-version>5</pandoc-api-version><blocks><c><c>Hello</c><t>Str</t></c><t>Para</t></blocks><meta></meta></rootdoc>"""

      // test
      val actual = XML.toString(json,"rootdoc")

      // check
      actual shouldBe expected
    }
  }
}
