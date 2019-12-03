package sbaier.datanet.core

abstract class NodeFactoryByPreset
{
    abstract fun create(preset: NodePreset): Node
}