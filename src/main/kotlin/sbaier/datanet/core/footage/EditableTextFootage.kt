package sbaier.datanet.core.footage


import java.nio.file.Path
import java.util.*

class EditableTextFootage(iD: UUID, path: Path) : Footage(iD, path, FootageType.EditableText)
{
}