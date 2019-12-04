package sbaier.datanet.core.node

import sbaier.datanet.core.node.NodeFactory
import sbaier.identification.UUIDGenerator

class NodeFactoryAssembler
{
    fun assemble(): NodeFactory
    {
        val iDGenerator= UUIDGenerator()
        return NodeFactory(iDGenerator)
    }
}