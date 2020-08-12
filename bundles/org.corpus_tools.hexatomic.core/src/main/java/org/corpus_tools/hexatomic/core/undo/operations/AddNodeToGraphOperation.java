package org.corpus_tools.hexatomic.core.undo.operations;

import org.corpus_tools.hexatomic.core.SaltHelper;
import org.corpus_tools.hexatomic.core.undo.ReversibleOperation;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;

public class AddNodeToGraphOperation<N extends Node> implements ReversibleOperation {

  private final N node;
  private final Graph<N, ?, ?> graph;

  /**
   * Create a undo operation for a node that was added to a graph.
   * 
   * @param node The node that was added.
   */
  @SuppressWarnings("unchecked")
  public AddNodeToGraphOperation(N node) {
    super();
    this.node = node;
    this.graph = node.getGraph();
  }



  @Override
  public void restore() {
    if (graph != null) {
      graph.removeNode(node);
    }
  }

  @Override
  public Object getChangedContainer() {
    return SaltHelper.resolveDelegation(graph);
  }

  @Override
  public Object getChangedElement() {
    return SaltHelper.resolveDelegation(node);
  }

}
