package sbaier.datanet.core

class NodeFactoryByPresetAssembler
{
    fun assemble(): NodeFactoryByPreset
    {
        val nodeFactory = NodeFactoryAssembler().assemble()
        val nodeComponentFactory = NodeComponentFactoryAssembler().assemble()
        return NodeFactoryByPreset(nodeFactory, nodeComponentFactory)
    }
}