package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

abstract class NodeComponentFactory()
{
    abstract fun create(type: NodeComponentType): NodeComponent
}