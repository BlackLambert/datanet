package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class NodeComponentFactoryAssembler
{
    fun assemble(): NodeComponentFactory
    {
        val iDGenerator = UUIDGenerator()
        val nameComponentFactory = NameComponentFactory()
        return NodeComponentFactory(iDGenerator, nameComponentFactory)
    }
}