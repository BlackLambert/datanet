package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class BasicDataNetFactory(private val iDGenerator: UUIDGenerator) : DataNetFactory()
{
    override fun create(nodes: Collection<Node>): DataNet
    {
        var net = create()
        nodes.forEach {net.add(it)}
        return net
    }

    override fun create(): DataNet
    {
        val iD = iDGenerator.create()
        return DataNet(iD)
    }
}