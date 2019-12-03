package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*
import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertSame
import kotlin.test.assertTrue

class DataNetFactoryTest
{
    private lateinit var nodes: List<Node>
    private lateinit var factory: DataNetFactory

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        nodes = listOf(createNode(), createNode(), createNode())
        factory = DataNetFactory(iDGenerator)
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

    private fun createNode(): Node
    {
        return Node(UUID.randomUUID())
    }
}