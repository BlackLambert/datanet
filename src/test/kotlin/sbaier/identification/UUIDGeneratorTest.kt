package sbaier.identification

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class UUIDGeneratorTest
{
    private val stringID: String = "123e4567-e89b-42d3-a456-556642440000"
    private lateinit var generator: UUIDGenerator

    @BeforeTest
    fun setup()
    {
        generator = UUIDGenerator()
    }

    @Test
    fun create_TwoCreationsNotEqual()
    {
        val first = generator.create()
        val second = generator.create()
        assertNotEquals(first, second)
    }

    @Test
    fun create_string_ToStringAndInputSame()
    {
        val iD = generator.create(stringID)
        assertEquals(stringID, iD.toString())
    }
}