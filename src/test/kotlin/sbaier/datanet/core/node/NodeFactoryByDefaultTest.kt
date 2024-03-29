package sbaier.datanet.core.node

import sbaier.datanet.core.node.DefaultNodeType
import sbaier.datanet.core.node.NodeFactoryByDefault
import sbaier.datanet.core.node.NodeFactoryByDefaultAssembler
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class NodeFactoryByDefaultTest
{
    private lateinit var _factory: NodeFactoryByDefault

    @BeforeTest
    fun setup()
    {
        _factory = NodeFactoryByDefaultAssembler().assemble()
    }

    @Test
    fun create_CorrectNodeCreated()
    {
        val node = _factory.create(DefaultNodeType.Tag)
        assertEquals(node.type, "Tag")
    }
}