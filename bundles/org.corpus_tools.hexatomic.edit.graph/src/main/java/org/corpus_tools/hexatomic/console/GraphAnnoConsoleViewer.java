/*-
 * #%L
 * org.corpus_tools.hexatomic.graph
 * %%
 * Copyright (C) 2018 - 2019 Stephan Druskat, Thomas Krause
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
package org.corpus_tools.hexatomic.console;

import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

public class GraphAnnoConsoleViewer extends SourceViewer {
  
  private GraphAnnoConsole console;

  public GraphAnnoConsoleViewer(Composite parent, GraphAnnoConsole console) {
    super(parent, null, SWT.V_SCROLL | SWT.H_SCROLL);
    this.console = console;
    
    StyledText styledText = getTextWidget();
    styledText.setDoubleClickEnabled(true);
    styledText.setEditable(true);
    
    
  }

}
