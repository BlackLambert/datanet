package sbaier.datanet.core

class NodePresetFactoryByDefaultAssembler
{
    fun assemble(): NodePresetFactoryByDefault
    {
        val tagNodePresetFactory= TagNodePresetFactory()
        return NodePresetFactoryByDefault(tagNodePresetFactory)
    }
}