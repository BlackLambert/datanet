package sbaier.datanet.core.net

import sbaier.datanet.core.node.Node
import sbaier.identification.UUIDGenerator
import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Path

class DataNetFactory(private val _iDGenerator: UUIDGenerator)
{

    fun create(directory: Path, nodes: Collection<Node>): DataNet
    {
        var net = create(directory)
        nodes.forEach {net.add(it)}
        return net
    }

    fun create(path: Path): DataNet
    {
        val iD = _iDGenerator.create()
        val validationResult = validate(path)
        if(validationResult.successful)
            return DataNet(path, iD)
        else
            throw IllegalArgumentException("Failed to create data net. The provided path '$path' is not valid. " +
                    "${validationResult.message}")
    }

    private fun validate(path: Path): ValidationResult
    {
        val file: File = path.toFile()
        return if(!file.isDirectory)
            ValidationResult(false, "The path should lead to a directory.")
        else
            ValidationResult(true, "Successful")
    }

    inner class ValidationResult(val successful: Boolean,
                                 val message: String)
}