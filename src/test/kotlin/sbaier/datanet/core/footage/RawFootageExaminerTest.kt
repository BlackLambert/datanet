package sbaier.datanet.core.footage

import java.io.File
import java.nio.file.Path
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RawFootageExaminerTest
{
    private val _expectedType = FootageType.EditableText
    private val _correctPathString: String = "./Datanet/Text.txt"
    private val _invalidPathString: String = "./Datanet/Text.txt22"
    private lateinit var _correctRawFootage: RawFootage
    private lateinit var _invalidRawFootage: RawFootage
    private lateinit var _examiner: RawFootageExaminer

    @BeforeTest
    fun setup()
    {
        _examiner = RawFootageExaminer()
        _correctRawFootage = RawFootage( File(_correctPathString).toPath())
        _invalidRawFootage = RawFootage(File(_invalidPathString).toPath())
    }

    @Test
    fun determineFootageTypeOf_throwsExceptionIfExtensionUnknown()
    {
        assertFailsWith<NotImplementedError> { _examiner.determineFootageTypeOf(_invalidRawFootage) }
    }

    @Test
    fun determineFootageTypeOf_determinesCorrectType()
    {
        val type=  _examiner.determineFootageTypeOf(_correctRawFootage)
        assertEquals(type, _expectedType)
    }
}