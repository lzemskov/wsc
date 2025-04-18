/*
 * Copyright (c) 2017, salesforce.com, inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *    following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 *    the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *    Neither the name of salesforce.com, inc. nor the names of its contributors may be used to endorse or
 *    promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.sforce.ws.codegen;

import junit.framework.TestCase;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupDir;

import com.sforce.ws.codegen.metadata.ClassMetadata;
import com.sforce.ws.tools.wsdlc;

public class AggregateCodeGeneratorTest extends TestCase {

    public void testGenerateSObjectSource() throws Exception {
        String expectedSource = CodeGeneratorTestUtil.fileToString("AggregateResult.java");

        ST template = CodeGeneratorTestUtil.getTemplateDefinitions(Generator.AGGREGATE_RESULT);
        template.add("gen", new ClassMetadata("com.sforce.soap.enterprise.sobject", null, null, false));

        assertEquals(expectedSource, CodeGeneratorTestUtil.getRenderedStringWithReplacements(template));
    }

    public void testGenerateSObjectSourceWithDeprecations() throws Exception {
        String expectedSource = CodeGeneratorTestUtil.fileToString("AggregateResultDep.java");

        ST template = CodeGeneratorTestUtil.getTemplateDefinitions(Generator.AGGREGATE_RESULT);
        template.add("gen", new ClassMetadata("com.sforce.soap.enterprise.sobject", null, null, true));

        assertEquals(expectedSource, CodeGeneratorTestUtil.getRenderedStringWithReplacements(template));
    }
    
    public void testGenerateExtendedSource() throws Exception {
        String expectedSource = CodeGeneratorTestUtil.fileToString("ExtendedErrorDetails.java");

        ST template = CodeGeneratorTestUtil.getTemplateDefinitions(Generator.EXTENDED_ERROR_DETAILS);
        template.add("gen", new ClassMetadata("com.sforce.soap.enterprise", null, null, false));

        assertEquals(expectedSource, CodeGeneratorTestUtil.getRenderedStringWithReplacements(template));
    }

    public void testGenerateExtendedSourceWithDeprecations() throws Exception {
        String expectedSource = CodeGeneratorTestUtil.fileToString("ExtendedErrorDetailsDep.java");

        ST template = CodeGeneratorTestUtil.getTemplateDefinitions(Generator.EXTENDED_ERROR_DETAILS);
        template.add("gen", new ClassMetadata("com.sforce.soap.enterprise", null, null, true));

        assertEquals(expectedSource, CodeGeneratorTestUtil.getRenderedStringWithReplacements(template));
    }
}
