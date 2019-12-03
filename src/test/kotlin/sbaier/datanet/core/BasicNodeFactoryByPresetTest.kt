package sbaier.datanet.core

import java.lang.IllegalArgumentException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BasicNodeFactoryByPresetTest
{
    private val _namePropertyName = "PropName"
    private val _nameValue = "Name"
    private lateinit var _validPreset: NodePreset
    private lateinit var _missingArgsPreset: NodePreset
    private lateinit var _invalidArgsPreset: NodePreset
    private lateinit var _nodeFactory: NodeFactoryByPreset

    @BeforeTest
    fun setup()
    {
        val validArgs: NodeComponentConstructArgs = NameComponentConstructArgs(_namePropertyName, _nameValue)
        _validPreset = NodePreset(listOf(NodeComponentType.Name), hashMapOf(NodeComponentType.Name to validArgs))
        _missingArgsPreset = NodePreset(listOf(NodeComponentType.Name), hashMapOf())
        val invalidArgs: NodeComponentConstructArgs = UnsetComponentConstructArgs()
        _invalidArgsPreset = NodePreset(listOf(NodeComponentType.Name), hashMapOf(NodeComponentType.Name to invalidArgs))
        val nodeFactory = DummyNodeFactory()
        val nodeComponentFactory = DummyNodeComponentFactory()
        _nodeFactory = BasicNodeFactoryByPreset(nodeFactory, nodeComponentFactory)
    }

    @Test
    fun create_outputEqualsInput()
    {
        val node = _nodeFactory.create(_validPreset)
        val component:NameComponent = node.get(NodeComponentType.Name).first() as NameComponent
        assertEquals(component.type, NodeComponentType.Name)
        assertEquals(component.namePropertyName, _namePropertyName)
        assertEquals(component.nameValue, _nameValue)
    }

    @Test
    fun create_missingArgsThrowsException()
    {
        assertFailsWith<IllegalArgumentException> {  _nodeFactory.create(_missingArgsPreset) }
    }

    @Test
    fun create_wrongArgsThrowsException() {
        assertFailsWith<IllegalArgumentException> {  _nodeFactory.create(_invalidArgsPreset) }
    }
}