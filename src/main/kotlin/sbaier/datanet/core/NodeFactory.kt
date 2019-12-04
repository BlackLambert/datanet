package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*

class NodeFactory(private val iDGenerator: UUIDGenerator)
{
    fun create(): Node
    {
        val iD: UUID = iDGenerator.create()
        return Node(iD)
    }

    fun create(type: String): Node
    {
        val iD: UUID = iDGenerator.create()
        return Node(iD, type)
    }
}