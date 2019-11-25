package sbaier.datanet.core

abstract class TagNodeFactory()
{
    abstract fun create(name: String): TagNode
    abstract fun create(): TagNode
}