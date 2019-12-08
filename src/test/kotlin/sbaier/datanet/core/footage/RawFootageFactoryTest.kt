package sbaier.datanet.core.footage

import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RawFootageFactoryTest
{
    private val _validPathString = "./README.md";
    private val _notExistingPathString = "./Datanet/Text/blubb.rwq";
    private lateinit var _validPath: Path
    private lateinit var _directoryPath: Path
    private lateinit var _notExistingPath: Path
    private lateinit var _rawFootageFactory: RawFootageFactory


    @BeforeTest
    fun setup()
    {
        _validPath = Paths.get(_validPathString)
        _directoryPath = Paths.get(".")
        _notExistingPath = File(_notExistingPathString).toPath()
        _rawFootageFactory = RawFootageFactory()
    }

    @Test
    fun create_outputEqualsInput()
    {
        val result = _rawFootageFactory.create(_validPath)
        assertEquals(result.path, _validPath)
    }

    @Test
    fun create_failsIfPathIsDirectory()
    {
        assertFailsWith<IllegalArgumentException> { _rawFootageFactory.create(_directoryPath) }
        assertFailsWith<IllegalArgumentException> { _rawFootageFactory.create(_notExistingPath) }
    }
}