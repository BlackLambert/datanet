package sbaier.datanet.core

class NodeDataExtractor (private val node: Node)
{
    public fun extract(): NodeData
    {
        return NodeData(node.iD)
    }
}