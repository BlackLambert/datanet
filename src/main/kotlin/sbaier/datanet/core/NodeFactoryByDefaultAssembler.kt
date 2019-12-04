package sbaier.datanet.core

class NodeFactoryByDefaultAssembler
{
    fun assemble(): NodeFactoryByDefault
    {
        val presetFactory: NodePresetFactoryByDefault = NodePresetFactoryByDefaultAssembler().assemble()
        val nodeFactory: NodeFactoryByPreset = NodeFactoryByPresetAssembler().assemble()
        return  NodeFactoryByDefault(presetFactory, nodeFactory)
    }
}