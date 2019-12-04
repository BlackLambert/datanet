package sbaier.datanet.core.node

import sbaier.datanet.core.node.LabelComponent
import sbaier.datanet.core.node.LabelComponentConstructArgs
import java.util.*

class LabelComponentFactory
{
    fun create(iD: UUID, constructArgs: LabelComponentConstructArgs): LabelComponent
    {
        return LabelComponent(iD, constructArgs.defaultName, constructArgs.namePropertyName)
    }
}