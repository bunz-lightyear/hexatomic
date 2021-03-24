/*-
 * #%L
 * org.corpus_tools.hexatomic.core
 * %%
 * Copyright (C) 2018 - 2021 Stephan Druskat, Thomas Krause
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

package org.corpus_tools.hexatomic.core.ui;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

public class PreferencesDialog extends Dialog {
  IEclipsePreferences prefs =
      ConfigurationScope.INSTANCE.getNode("org.corpus_tools.hexatomic.core.project");

  /**
   * Create the dialog.
   * 
   * @param parentShell The parent.
   */

  public PreferencesDialog(Shell parentShell) {
    super(parentShell);
  }

  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Enable Startup-Checks");
  }

  /**
   * Create contents of the dialog.
   * 
   * @param parent The parent
   */

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Label label = new Label(area, SWT.BORDER);
    label.setText("When checked Hexatomic will search for p2-Updates at each startup");
    Button button = new Button(area, SWT.CHECK);
    button.setText("Enable automatic update search at startup");


    // register listener for the selection event
    button.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        if (prefs != null) {

          prefs.putBoolean("autoUpdate", button.getSelection());
          System.out.println("Präferenz gesendet.");

          try {
            prefs.flush();
          } catch (BackingStoreException ex) {
            ex.printStackTrace();
          }
        } else {
          System.out.println("null");
        }
      }
    });
    return area;
  }
}
