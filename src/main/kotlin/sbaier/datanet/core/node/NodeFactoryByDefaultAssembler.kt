package sbaier.datanet.core.node

class NodeFactoryByDefaultAssembler
{
    fun assemble(): NodeFactoryByDefault
    {
        val presetFactory: NodePresetFactoryByDefault = NodePresetFactoryByDefaultAssembler().assemble()
        val nodeFactory: NodeFactoryByPreset = NodeFactoryByPresetAssembler().assemble()
        return NodeFactoryByDefault(presetFactory, nodeFactory)
    }
}