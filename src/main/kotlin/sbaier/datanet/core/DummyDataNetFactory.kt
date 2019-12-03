package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class DummyDataNetFactory(): DataNetFactory()
{
    private val _iDGenerator: UUIDGenerator = UUIDGenerator()

    override fun create(nodes: Collection<Node>): DataNet
    {
        var net = create()
        nodes.forEach {net.add(it)}
        return net
    }

    override fun create(): DataNet
    {
        return DataNet(_iDGenerator.create())
    }
}