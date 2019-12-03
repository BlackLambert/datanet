package sbaier.datanet.core

abstract class NodePresetFactory
{
    fun create(args: NodePresetConstructArgs): NodePreset {
        return NodePreset(args.name, args.componentTypes, args.componentArgs)
    }
}