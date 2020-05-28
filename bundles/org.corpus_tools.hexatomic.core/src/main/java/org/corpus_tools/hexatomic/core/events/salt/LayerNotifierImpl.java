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

package org.corpus_tools.hexatomic.core.events.salt;

import org.corpus_tools.hexatomic.core.Topics;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.LayerImpl;
import org.eclipse.e4.core.services.events.IEventBroker;

/**
 * Implements a Salt {@link Layer} which use the {@link IEventBroker} to send events when the layer
 * was updated.
 * 
 * <p>
 * The event will have the ID of the layer as argument.
 * </p>
 * 
 * @author Thomas Krause {@literal <krauseto@hu-berlin.de>}
 *
 */
public class LayerNotifierImpl<N extends Node, R extends Relation<N, N>> extends LayerImpl<N, R>
    implements Layer<N, R>, NotifyingElement<Layer<?, ?>> {


  private static final long serialVersionUID = -4708308546018698463L;

  private final NotificationHelper notificationHelper;
  private Layer<?, ?> owner;

  public LayerNotifierImpl(NotificationHelper notificationHelper) {
    this.notificationHelper = notificationHelper;
  }

  @Override
  public Layer<?, ?> getOwner() {
    return owner;
  }

  @Override
  public void setOwner(Layer<?, ?> owner) {
    this.owner = owner;
  }

  @Override
  public void addLabel(Label label) {
    super.addLabel(label);
    notificationHelper.sendEvent(Topics.ANNOTATION_ADDED, label);
  }

  @Override
  public void removeLabel(String qname) {
    if (qname != null) {
      Label label = getLabel(qname);
      notificationHelper.sendEvent(Topics.ANNOTATION_REMOVED, label);
      super.removeLabel(qname);
    }
  }

  @Override
  public void removeAll() {
    notificationHelper.sendEvent(Topics.ANNOTATION_BEFORE_MODIFICATION, this);
    super.removeAll();
    notificationHelper.sendEvent(Topics.ANNOTATION_AFTER_MODIFICATION, this);
  }

  @Override
  public void addNode(N node) {
    super.addNode(node);
    notificationHelper.sendEvent(Topics.ANNOTATION_ADDED, node);
  }

  @Override
  public void removeNode(N node) {
    notificationHelper.sendEvent(Topics.ANNOTATION_REMOVED, node);
    super.removeNode(node);
  }

  @Override
  public void addRelation(Relation<? extends N, ? extends N> relation) {
    super.addRelation(relation);
    notificationHelper.sendEvent(Topics.ANNOTATION_ADDED, relation);
  }

  @Override
  public void removeRelation(Relation<? extends N, ? extends N> rel) {
    notificationHelper.sendEvent(Topics.ANNOTATION_REMOVED, rel);
    super.removeRelation(rel);
  }
}
