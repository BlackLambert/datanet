package sbaier.datanet.core.node

import java.lang.IllegalArgumentException

class NodePresetFactoryByDefault(private val _tagNodePresetFactory: TagNodePresetFactory)
{
    fun create(type: DefaultNodeType): NodePreset
    {
        when(type)
        {
            DefaultNodeType.Tag -> return _tagNodePresetFactory.create()
            DefaultNodeType.Unset -> throw IllegalArgumentException("Failed to create default NodePreset of " +
                    "type $type. Creating the default type is not allowed.")
            else -> throw NotImplementedError("Failed to create default NodePreset of " +
                    "type $type. This type has not been implemented yet.")
        }
    }
}