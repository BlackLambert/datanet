package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*

class DummyNodeFactory(private val _iDGenerator: UUIDGenerator) : NodeFactory()
{
    override fun create(): Node {
        val iD: UUID = _iDGenerator.create()
        return Node(iD)
    }
}