package sbaier.datanet.core.node

import sbaier.datanet.core.node.Node
import sbaier.datanet.core.node.NodeData

class NodeDataExtractor (private val node: Node)
{
    public fun extract(): NodeData
    {
        return NodeData(node.iD)
    }
}