package sbaier.datanet.core.node

import sbaier.datanet.core.node.NodePreset
import sbaier.datanet.core.node.NodePresetConstructArgs

abstract class NodePresetFactory
{
    fun create(args: NodePresetConstructArgs): NodePreset
    {
        return NodePreset(args.name, args.componentTypes, args.componentArgs)
    }
}