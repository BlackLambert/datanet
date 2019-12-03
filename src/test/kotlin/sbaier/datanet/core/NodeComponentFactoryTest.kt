package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.lang.IllegalArgumentException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NodeComponentFactoryTest
{
    private val _namePropertyName = "Prop"
    private val _nameValue = "Name"
    private lateinit var _nodeComponentFactory: NodeComponentFactory
    private lateinit var _nameConstructArgs: NodeComponentConstructArgs
    private lateinit var _unsetConstructArgs: UnsetComponentConstructArgs

    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        val nameComponentFactory = NameComponentFactory()
        _nodeComponentFactory = NodeComponentFactory(iDGenerator, nameComponentFactory)
        _nameConstructArgs = NameComponentConstructArgs(_namePropertyName, _nameValue)
        _unsetConstructArgs = UnsetComponentConstructArgs()
    }

    @Test
    fun create_OutputEqualsInput()
    {
        val output:NameComponent = _nodeComponentFactory.create(_nameConstructArgs) as NameComponent
        assertEquals(output.type, NodeComponentType.Name)
        assertEquals(output.nameValue, _nameValue)
        assertEquals(output.namePropertyName, _namePropertyName)
    }

    @Test
    fun create_DefaultTypeThrowsException()
    {
        assertFailsWith<IllegalArgumentException>{_nodeComponentFactory.create(_unsetConstructArgs)}
    }
}