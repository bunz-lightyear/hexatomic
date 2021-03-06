/*-
 * #%L
 * org.corpus_tools.hexatomic.core
 * %%
 * Copyright (C) 2018 - 2020 Stephan Druskat, Thomas Krause
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

package org.corpus_tools.hexatomic.core.undo.operations;

import org.corpus_tools.hexatomic.core.undo.ReversibleOperation;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SaltProject;

public class AddCorpusGraphOperation implements ReversibleOperation {

  private final SaltProject project;
  private final SCorpusGraph corpusGraph;

  /**
   * Create a undo operation for adding a corpus graph to a Salt project.
   * 
   * @param project The Salt project the corpus graph is added to.
   * @param corpusGraph The corpus graph added to the Salt project.
   */
  public AddCorpusGraphOperation(SaltProject project, SCorpusGraph corpusGraph) {
    super();
    this.project = project;
    this.corpusGraph = corpusGraph;
  }

  @Override
  public void restore() {
    if (project != null && corpusGraph != null) {
      project.removeCorpusGraph(corpusGraph);
    }
  }

  @Override
  public Object getChangedContainer() {
    return project;
  }

  @Override
  public Object getChangedElement() {
    return corpusGraph;
  }

}
