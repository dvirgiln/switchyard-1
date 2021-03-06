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

package org.switchyard.validate.config.model;

import org.switchyard.config.model.validate.ValidateModel;

/**
 * A "transform.java" configuration model.
 *
 * @author <a href="mailto:tm.igarashi@gmail.com">Tomohisa Igarashi</a>
 */
public interface JavaValidateModel extends ValidateModel {

    /** The "java" name. */
    public static final String JAVA = "java";

    /** The "class" name. */
    public static final String CLASS = "class";

    /** The "bean" name. */
    public static final String BEAN = "bean";

    /**
     * Gets the class attribute.
     * @return the class attribute
     */
    public String getClazz();

    /**
     * Sets the class attribute.
     * @param clazz the class attribute
     * @return this JavaValidateModel (useful for chaining)
     */
    public JavaValidateModel setClazz(String clazz);

    /**
     * Gets the bean attribute.
     * @return the bean attribute
     */
    public String getBean();
    
    /**
     * Sets the bean attribute.
     * @param bean the bean attribute
     * @return this JavaValidateModel (useful for chaining)
     */
    public JavaValidateModel setBean(String bean);
}
