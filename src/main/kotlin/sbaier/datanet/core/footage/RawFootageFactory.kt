package sbaier.datanet.core.footage

import java.lang.IllegalArgumentException
import java.nio.file.Path

class RawFootageFactory
{
    fun create(path: Path): RawFootage
    {
        if(!path.toFile().exists())
            throw IllegalArgumentException("Failed to create Raw Footage. " +
                    "The provided path '$path' is invalid.")
        if(path.toFile().isDirectory)
            throw IllegalArgumentException("Failed to create Raw Footage. " +
                    "The provided path '$path' is leading to a directory. A file path is required.")
        return RawFootage(path)
    }
}