package sbaier.datanet.core

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
        _nodeComponentFactory = NodeComponentFactoryAssembler().assemble()
        _nameConstructArgs = LabelComponentConstructArgs(_namePropertyName, _nameValue)
        _unsetConstructArgs = UnsetComponentConstructArgs()
    }

    @Test
    fun create_OutputEqualsInput()
    {
        val output:LabelComponent = _nodeComponentFactory.create(_nameConstructArgs) as LabelComponent
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