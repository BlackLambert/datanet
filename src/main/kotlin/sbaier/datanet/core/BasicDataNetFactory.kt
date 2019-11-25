package sbaier.datanet.core

import java.util.*

class BasicDataNetFactory : DataNetFactory()
{
    //Todo UUID Generierung kapseln
    //Todo add create function with stringified iD Input
    override fun create(nodes: Collection<Node>): DataNet
    {
        var net = create()
        nodes.forEach {net.add(it)}
        return net
    }

    override fun create(): DataNet {
        return DataNet(UUID.randomUUID())
    }
}