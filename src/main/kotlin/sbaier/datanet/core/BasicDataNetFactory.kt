package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class BasicDataNetFactory(private val _iDGenerator: UUIDGenerator) : DataNetFactory()
{
    override fun create(nodes: Collection<Node>): DataNet
    {
        var net = create()
        nodes.forEach {net.add(it)}
        return net
    }

    override fun create(): DataNet
    {
        val iD = _iDGenerator.create()
        return DataNet(iD)
    }
}