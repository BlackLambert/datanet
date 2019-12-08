package sbaier.datanet.core.footage


import java.nio.file.Path
import java.util.*

abstract class Footage(val iD: UUID, val path: Path, val type: FootageType)
{

}