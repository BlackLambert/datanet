package sbaier.datanet.core

import java.util.*

class DummyDataNetFactory: DataNetFactory()
{
    override fun create(nodes: Collection<Node>): DataNet
    {
        var net = create()
        nodes.forEach {net.add(it)}
        return net
    }

    override fun create(): DataNet
    {
        return DataNet(UUID.randomUUID())
    }
}