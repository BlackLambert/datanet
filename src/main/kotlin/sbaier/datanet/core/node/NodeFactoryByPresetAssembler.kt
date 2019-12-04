package sbaier.datanet.core.node

import sbaier.datanet.core.node.NodeComponentFactoryAssembler
import sbaier.datanet.core.node.NodeFactoryAssembler
import sbaier.datanet.core.node.NodeFactoryByPreset

class NodeFactoryByPresetAssembler
{
    fun assemble(): NodeFactoryByPreset
    {
        val nodeFactory = NodeFactoryAssembler().assemble()
        val nodeComponentFactory = NodeComponentFactoryAssembler().assemble()
        return NodeFactoryByPreset(nodeFactory, nodeComponentFactory)
    }
}