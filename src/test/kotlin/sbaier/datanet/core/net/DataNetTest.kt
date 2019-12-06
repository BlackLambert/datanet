package sbaier.datanet.core.net

import sbaier.datanet.core.node.Node
import java.io.File
import java.nio.file.Paths
import java.util.*
import kotlin.test.*

class DataNetTest
{
    private lateinit var nodes: List<Node>
    private lateinit var net: DataNet
    private lateinit var additionalNode: Node

    @BeforeTest
    fun setup()
    {
        nodes = listOf(createNote(), createNote(), createNote())
        net = createNet()
        nodes.forEach{net.add(it)}
        additionalNode = createNote()
    }

    @Test
    fun contains_ReturnsTrueForAddedNode()
    {
        assertTrue(net.contains(nodes[0]))
    }

    @Test
    fun contains_ReturnsFalseForNonAddedNode()
    {
        assertFalse(net.contains(additionalNode))
    }

    @Test
    fun add_NetContainsAddedNode()
    {
        net.add(additionalNode)
        assertTrue(net.contains(additionalNode))
        assertTrue(net.nodeCount == 4)
    }

    @Test
    fun add_DoubleAddOfSameNodeThrowsException()
    {
        net.add(additionalNode)
        assertFailsWith<IllegalArgumentException>("Adding the same node twice to a data net is not allowed")
        { net.add(additionalNode) }
    }

    @Test
    fun remove_NetDoesNotContainNodeAnymore()
    {
        net.remove(nodes[0])
        assertFalse(net.contains(nodes[0]))
    }

    @Test
    fun remove_NetStillContainsOtherNodes()
    {
        net.remove(nodes[0])
        assertTrue(net.contains(nodes[1]))
        assertTrue(net.contains(nodes[2]))
        assertTrue(net.nodeCount == 2)
    }

    @Test
    fun remove_RemovingNonAddedNodeThrowsException()
    {
        net.remove(nodes[0])
        assertFailsWith<IllegalArgumentException>("Removing the same node twice from a data net is not " +
                "allowed")
        { net.remove(nodes[0]) }
    }

    @Test
    fun get_ReturnsExpectedNode()
    {
        assertEquals(net.get(nodes[0].iD), nodes[0])
    }

    @Test
    fun get_GettingNonAddedNodeThrowsException()
    {
        assertFailsWith<IllegalArgumentException>("Getting a note that has not been added from a data net " +
                "is not allowed")
        {net.get(additionalNode.iD)}
    }

    private fun createNote(): Node
    {
        return Node(UUID.randomUUID())
    }

    private fun createNet(): DataNet
    {
        return DataNet(Paths.get(""), UUID.randomUUID())
    }
}