/*-
 * #%L
 * org.corpus_tools.hexatomic.core
 * %%
 * Copyright (C) 2018 - 2020 Stephan Druskat,
 *                                     Thomas Krause
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.corpus_tools.hexatomic.core;

/**
 * Contains constants for topics use by the core bundle.
 * 
 * @author Thomas Krause
 */
public interface Topics {
  
  public static final String PROJECT_LOADED = "PROJECT_LOADED";


  public static final String ANNOTATION_ANY_UPDATE = "ANNOTATION_UPDATE/*";

  public static final String ANNOTATION_ADDED = "ANNOTATION_UPDATE/ADD";
  public static final String ANNOTATION_REMOVED = "ANNOTATION_UPDATE/REMOVED";
  public static final String ANNOTATION_MODIFIED = "ANNOTATION_UPDATE/MODIFIED";

  public static final String DOCUMENT_CLOSED = "DOCUMENT_CLOSED";
  
  public static final String DOCUMENT_LOADED = "DOCUMENT_LOADED";
  
  public static final String STATUS_UPDATE = "STATUS_UPDATE";
  
}
