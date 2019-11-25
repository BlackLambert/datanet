package sbaier.datanet.core

import java.util.*

class BasicNodeFactory() : NodeFactory() {
    //Todo UUID Generierung kapseln
    //Todo add create function with stringified iD Input
    override fun create(): Node {
        val iD: UUID = UUID.randomUUID()
        return Node(iD)
    }
}