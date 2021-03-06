/*
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.switchyard.config.model.switchyard.test.validate.java;

import org.switchyard.config.Configuration;
import org.switchyard.config.model.Descriptor;
import org.switchyard.config.model.Model;
import org.switchyard.config.model.switchyard.v1.V1SwitchYardMarshaller;
import org.switchyard.config.model.validate.ValidateModel;

/**
 * JavaMarshaller.
 *
 * @author <a href="mailto:tm.igarashi@gmail.com">Tomohisa Igarashi</a>
 */
public class JavaMarshaller extends V1SwitchYardMarshaller {

    private static final String VALIDATE_JAVA = ValidateModel.VALIDATE + "." + JavaValidateModel.JAVA;

    public JavaMarshaller(Descriptor desc) {
        super(desc);
    }

    @Override
    public Model read(Configuration config) {
        String name = config.getName();
        Descriptor desc = getDescriptor();
        if (name.equals(VALIDATE_JAVA)) {
            return new JavaValidateModel(config, desc);
        }
        return super.read(config);
    }

}
