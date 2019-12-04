package sbaier.datanet.core.node

class NodePresetFactoryByDefaultAssembler
{
    fun assemble(): NodePresetFactoryByDefault
    {
        val tagNodePresetFactory= TagNodePresetFactory()
        return NodePresetFactoryByDefault(tagNodePresetFactory)
    }
}