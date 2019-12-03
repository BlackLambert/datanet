package sbaier.datanet.core

abstract class NodeComponentFactory()
{
    abstract fun create(constructArgs: NodeComponentConstructArgs): NodeComponent
}