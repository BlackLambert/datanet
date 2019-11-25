package sbaier.datanet.core

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotSame

class BasicNodeFactoryTest
{
    private lateinit var factory: NodeFactory

    @BeforeTest
    fun setup()
    {
        factory = BasicNodeFactory()
    }

    @Test
    fun create_DifferentNodesWithDifferentID()
    {
        var firstNode = factory.create()
        var secondNode = factory.create()
        assertNotSame(firstNode.iD, secondNode.iD)
    }
}