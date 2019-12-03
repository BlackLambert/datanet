package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import kotlin.test.*

class DataNetTest
{
    private lateinit var nodes: List<Node>
    private lateinit var net: DataNet
    private lateinit var additionalNode: Node

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        val nodeFactory = DummyNodeFactory(iDGenerator)
        nodes = listOf(nodeFactory.create(), nodeFactory.create(), nodeFactory.create())
        val netFactory = DummyDataNetFactory(iDGenerator)
        net = netFactory.create(nodes)
        additionalNode = nodeFactory.create()
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
}