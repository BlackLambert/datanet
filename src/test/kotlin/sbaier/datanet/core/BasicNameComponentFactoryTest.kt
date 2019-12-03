package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BasicNameComponentFactoryTest
{
    private lateinit var _nameComponentFactory: NameComponentFactory
    private lateinit var _iDGenerator: UUIDGenerator
    private lateinit var _constructArgs: NameComponentConstructArgs

    @BeforeTest
    fun setup()
    {
        _nameComponentFactory = BasicNameComponentFactory()
        _iDGenerator = UUIDGenerator()
        _constructArgs = NameComponentConstructArgs(namePropertyName = "NameProperty", defaultName = "Default")
    }

    @Test
    fun create_OutputTypeCorrect()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD, _constructArgs)
        assertEquals(component.type, NodeComponentType.Name)
    }

    @Test
    fun create_OutputIDEqualsInput()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD, _constructArgs)
        assertEquals(component.iD, iD)
    }

    @Test
    fun create_DefaultNameEqualsInput()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD, _constructArgs)
        assertEquals(component.nameValue, _constructArgs.defaultName)
    }

    @Test
    fun create_NamePropertyNameEqualsInput()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD, _constructArgs)
        assertEquals(component.namePropertyName, _constructArgs.namePropertyName)
    }
}