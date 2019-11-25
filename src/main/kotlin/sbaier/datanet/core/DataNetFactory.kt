package sbaier.datanet.core

abstract class DataNetFactory
{
    abstract fun create(nodes: Collection<Node>): DataNet
    abstract fun create(): DataNet
}