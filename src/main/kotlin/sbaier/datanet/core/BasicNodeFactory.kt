package sbaier.datanet.core

import java.util.*

class BasicNodeFactory() : NodeFactory() {
    override fun create(): Node {
        val iD: UUID = UUID.randomUUID()
        return Node(iD)
    }
}