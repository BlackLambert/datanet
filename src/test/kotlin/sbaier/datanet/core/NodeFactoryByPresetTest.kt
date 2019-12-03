package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.lang.IllegalArgumentException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NodeFactoryByPresetTest
{
    private val _namePropertyName = "PropName"
    private val _nameValue = "Name"
    private val _presetName = "Preset"
    private lateinit var _validPreset: NodePreset
    private lateinit var _missingArgsPreset: NodePreset
    private lateinit var _invalidArgsPreset: NodePreset
    private lateinit var _nodeFactory: NodeFactoryByPreset

    @BeforeTest
    fun setup()
    {
        _validPreset = createValidNodePreset()
        _missingArgsPreset = createMissingArgsNodePreset()
        _invalidArgsPreset = createInvalidArgsNodePreset()
        _nodeFactory = createNodeFactoryByPreset()
    }

    private fun createNodeFactoryByPreset(): NodeFactoryByPreset
    {
        val iDGenerator = UUIDGenerator()
        val nodeFactory = NodeFactory(iDGenerator)
        val nameComponentFactory = NameComponentFactory()
        val nodeComponentFactory = NodeComponentFactory(iDGenerator, nameComponentFactory)
        return NodeFactoryByPreset(nodeFactory, nodeComponentFactory)
    }

    private fun createValidNodePreset(): NodePreset
    {
        val validArgs: NodeComponentConstructArgs = NameComponentConstructArgs(_namePropertyName, _nameValue)
        return NodePreset(_presetName, listOf(NodeComponentType.Name), hashMapOf(NodeComponentType.Name to validArgs))
    }

    private fun createMissingArgsNodePreset(): NodePreset
    {
        return NodePreset(_presetName, listOf(NodeComponentType.Name), hashMapOf())
    }

    private fun createInvalidArgsNodePreset(): NodePreset
    {
        val invalidArgs: NodeComponentConstructArgs = UnsetComponentConstructArgs()
        return NodePreset(_presetName, listOf(NodeComponentType.Name), hashMapOf(NodeComponentType.Name to invalidArgs))
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