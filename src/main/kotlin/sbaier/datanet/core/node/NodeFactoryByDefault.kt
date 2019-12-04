package sbaier.datanet.core.node

class NodeFactoryByDefault(private val _presetFactory: NodePresetFactoryByDefault,
                           private val _nodeFactory: NodeFactoryByPreset)
{
    fun create(type: DefaultNodeType): Node
    {
        val preset = _presetFactory.create(type)
        return _nodeFactory.create(preset)
    }
}