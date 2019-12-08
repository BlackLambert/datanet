package sbaier.datanet.core.footage

import java.lang.IllegalArgumentException

class RawFootageExaminer()
{
    fun determineFootageTypeOf(raw: RawFootage): FootageType
    {
        val footageFileExtension: String = raw.path.toFile().extension
        if(footageFileExtension.isEmpty())
            throw IllegalArgumentException("Failed to determine FootageType." +
                    "The provided RawFootage has a invalid path '${raw.path}'")
        return getFootageTypeByExtension(footageFileExtension)
    }

    private fun getFootageTypeByExtension(fileExtension: String): FootageType
    {
        when(fileExtension)
        {
            "txt" -> return FootageType.EditableText
            else -> throw NotImplementedError("Failed to determine FootageType. " +
                    "Files with Extension $fileExtension are not supported yet")
        }
    }
}