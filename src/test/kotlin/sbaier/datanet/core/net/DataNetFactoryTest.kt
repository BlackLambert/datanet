package sbaier.datanet.core.net

import sbaier.datanet.core.node.Node
import sbaier.identification.UUIDGenerator
import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import kotlin.test.Test
import kotlin.test.assertSame
import kotlin.test.BeforeTest
import kotlin.test.assertFailsWith

class DataNetFactoryTest
{
    private lateinit var _nodes: List<Node>
    private lateinit var _factory: DataNetFactory

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        _nodes = listOf(createNode(), createNode(), createNode())
        _factory = DataNetFactory(iDGenerator)
    }

    @Test
    fun create_NetContainsAddedNotes()
    {
        val net = _factory.create(_nodes)
        for(node in _nodes)
        {
            assertSame(net.get(node.iD), node)
        }
    }

    private fun createNode(): Node
    {
        return Node(UUID.randomUUID())
    }
}