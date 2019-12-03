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

    @BeforeTest
    fun setup()
    {
        _nameComponentFactory = BasicNameComponentFactory()
        _iDGenerator = UUIDGenerator()
    }

    @Test
    fun create_OutputTypeCorrect()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD)
        assertEquals(component.type, NodeComponentType.Name)
    }

    @Test
    fun create_OutputIDEqualsInput()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD)
        assertEquals(component.iD, iD)
    }

    @Test
    fun create_DefaultNameContainsID()
    {
        val iD = _iDGenerator.create()
        val component = _nameComponentFactory.create(iD)
        assertTrue(component.value.contains(iD.toString()))
    }
}