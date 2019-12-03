package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*

class DummyNodeFactory() : NodeFactory()
{
    private val _iDGenerator: UUIDGenerator = UUIDGenerator()

    override fun create(): Node {
        val iD: UUID = _iDGenerator.create()
        return Node(iD)
    }
}