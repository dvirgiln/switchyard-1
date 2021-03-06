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
package org.switchyard.common.version;

import java.net.URL;

/**
 * Project.
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; (C) 2012 Red Hat Inc.
 */
public interface Project extends Comparable<Project> {

    /**
     * Gets the groupId.
     * @return the groupId
     */
    public String getGroupId();

    /**
     * Gets the artifactId.
     * @return the artifactId
     */
    public String getArtifactId();

    /**
     * Gets the packaging.
     * @return the packaging
     */
    public String getPackaging();

    /**
     * Gets the name.
     * @return the name
     */
    public String getName();

    /**
     * Gets the description.
     * @return the description
     */
    public String getDescription();

    /**
     * Gets the URL.
     * @return the URL
     */
    public URL getURL();

    /**
     * Gets the version.
     * @return the version
     */
    public String getVersion();

}
