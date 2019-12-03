package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.lang.IllegalArgumentException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BasicNodeComponentFactoryTest
{
    private lateinit var _nodeComponentFactory: NodeComponentFactory

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        val nameComponentFactory = DummyNameComponentFactory()
        _nodeComponentFactory = BasicNodeComponentFactory(iDGenerator, nameComponentFactory)
    }

    @Test
    fun create_OutputTypeEqualsInputType()
    {
        val output = _nodeComponentFactory.create(NodeComponentType.Name)
        assertEquals(output.type, NodeComponentType.Name)
    }

    @Test
    fun create_DefaultTypeThrowsException()
    {
        assertFailsWith<IllegalArgumentException>{_nodeComponentFactory.create(NodeComponentType.Unset)}
    }
}