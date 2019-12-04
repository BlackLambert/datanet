package sbaier.datanet.core.node

import sbaier.identification.UUIDGenerator

class DataNetFactory(private val _iDGenerator: UUIDGenerator)
{
    fun create(nodes: Collection<Node>): DataNet
    {
        var net = create()
        nodes.forEach {net.add(it)}
        return net
    }

    fun create(): DataNet
    {
        val iD = _iDGenerator.create()
        return DataNet(iD)
    }
}