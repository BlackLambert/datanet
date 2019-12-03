package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotSame

class BasicNodeFactoryTest
{
    private lateinit var factory: NodeFactory

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        factory = BasicNodeFactory(iDGenerator)
    }

    @Test
    fun create_DifferentNodesWithDifferentID()
    {
        var firstNode = factory.create()
        var secondNode = factory.create()
        assertNotSame(firstNode.iD, secondNode.iD)
    }
}