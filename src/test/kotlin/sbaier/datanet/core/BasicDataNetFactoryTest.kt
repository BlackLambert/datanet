package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertSame
import kotlin.test.assertTrue

class BasicDataNetFactoryTest
{
    private lateinit var nodes: List<Node>
    private lateinit var factory: DataNetFactory

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        var nodeFactory = DummyNodeFactory()
        nodes = listOf(nodeFactory.create(), nodeFactory.create(), nodeFactory.create())
        factory = BasicDataNetFactory(iDGenerator)
    }

    @Test
    fun create_NetContainsAddedNotes()
    {
        var net = factory.create(nodes)
        for(node in nodes)
        {
            assertSame(net.get(node.iD), node)
        }
    }
}