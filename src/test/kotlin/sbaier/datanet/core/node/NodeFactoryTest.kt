package sbaier.datanet.core.node

import sbaier.datanet.core.node.NodeFactory
import sbaier.datanet.core.node.NodeFactoryAssembler
import kotlin.test.*

class NodeFactoryTest
{
    private val type = "Type"
    private lateinit var factory: NodeFactory

    @BeforeTest
    fun setup()
    {
        factory = NodeFactoryAssembler().assemble()
    }

    @Test
    fun create_DifferentNodesWithDifferentID()
    {
        val firstNode = factory.create()
        val secondNode = factory.create()
        assertNotSame(firstNode.iD, secondNode.iD)
    }

    @Test
    fun create_TypeCorrect()
    {
        val node = factory.create()
        assertEquals(node.type, "Custom")
    }

    @Test
    fun create_ComponentsEmpty()
    {
        val node = factory.create()
        assertTrue(node.componentsCount == 0)
    }

    @Test
    fun create_TypeArg_TypeCorrect()
    {
        val node = factory.create(type)
        assertEquals(node.type, type)
    }

}