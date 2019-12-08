package sbaier.datanet.core.footage

import sbaier.identification.UUIDGenerator
import java.lang.IllegalArgumentException
import java.nio.file.Path

class FootageFactory(private val _iDGenerator: UUIDGenerator, private val _rawFootageExaminer: RawFootageExaminer)
{
    fun create(raw: RawFootage): Footage
    {
        val footageType = _rawFootageExaminer.determineFootageTypeOf(raw)
        return create(raw.path, footageType)
    }

    private fun create(path: Path, footageType: FootageType): Footage
    {
        when(footageType)
        {
            FootageType.EditableText -> return EditableTextFootage(_iDGenerator.create(), path)
            FootageType.Unset -> throw IllegalArgumentException("Failed to create Footage. " +
                    "It is not possible to create a footage instance of the defaultType '${FootageType.Unset}'")
            else -> throw NotImplementedError("Failed to create Footage. " +
                    "Creation of the provided footage type $footageType has not been implemented yet.")
        }

    }
}