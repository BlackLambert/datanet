package sbaier.datanet.core.footage

import sbaier.identification.UUIDGenerator
import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Path
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FootageFactoryTest
{
    private val _pathString = "./Text.txt"
    private val _invalidPathString = "./Text.dasd"
    private val _dictionaryPathString = "./Text/"
    private lateinit var _path: Path
    private lateinit var _footageFactory: FootageFactory
    private lateinit var _rawFootage: RawFootage


    @BeforeTest
    fun setup()
    {
        val iDGenerator = UUIDGenerator()
        val examiner = RawFootageExaminer()
        _footageFactory = FootageFactory(iDGenerator, examiner)
        _path = File(_pathString).toPath()
        _rawFootage = RawFootage(_path)
    }

    @Test
    fun create_IsOutputExpected()
    {
        val result = _footageFactory.create(_rawFootage)
        assertEquals(result.path, _path)
        assertEquals(result.type, FootageType.EditableText)
    }

    @Test
    fun create_failsOnUnknownType()
    {
        val rawUnknown = RawFootage(File(_invalidPathString).toPath())
        assertFailsWith<NotImplementedError> { _footageFactory.create(rawUnknown) }
        val rawDictionary = RawFootage(File(_dictionaryPathString).toPath())
        assertFailsWith<IllegalArgumentException> { _footageFactory.create(rawDictionary) }
    }
}