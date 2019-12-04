package sbaier.datanet.core.node

import sbaier.datanet.core.node.LabelComponentFactory
import sbaier.datanet.core.node.NodeComponentFactory
import sbaier.identification.UUIDGenerator

class NodeComponentFactoryAssembler
{
    fun assemble(): NodeComponentFactory
    {
        val iDGenerator = UUIDGenerator()
        val nameComponentFactory = LabelComponentFactory()
        return NodeComponentFactory(iDGenerator, nameComponentFactory)
    }
}