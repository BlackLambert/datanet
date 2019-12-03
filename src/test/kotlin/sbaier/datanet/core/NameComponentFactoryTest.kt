package sbaier.datanet.core

import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class NameComponentFactoryTest
{
    private val _namePropertyName = "Prop"
    private val _nameValue = "Name"
    private lateinit var _nameComponentFactory: NameComponentFactory
    private lateinit var _constructArgs: NameComponentConstructArgs

    @BeforeTest
    fun setup()
    {
        _nameComponentFactory = NameComponentFactory()
        _constructArgs = NameComponentConstructArgs(_namePropertyName, _nameValue)
    }

    @Test
    fun create_OutputEqualsInput()
    {
        val iD = UUID.randomUUID()
        val component = _nameComponentFactory.create(iD, _constructArgs)
        assertEquals(component.type, NodeComponentType.Name)
        assertEquals(component.iD, iD)
        assertEquals(component.nameValue, _constructArgs.defaultName)
        assertEquals(component.namePropertyName, _constructArgs.namePropertyName)
    }
}