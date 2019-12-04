package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class NodeFactoryAssembler
{
    fun assemble(): NodeFactory
    {
        val iDGenerator= UUIDGenerator()
        return NodeFactory(iDGenerator)
    }
}