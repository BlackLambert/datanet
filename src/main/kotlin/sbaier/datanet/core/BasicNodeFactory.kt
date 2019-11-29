package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*

class BasicNodeFactory(private val iDGenerator: UUIDGenerator) : NodeFactory()
{
    override fun create(): Node
    {
        val iD: UUID = iDGenerator.create()
        return Node(iD)
    }
}