package sbaier.datanet.core

import java.util.*

class LabelComponentFactory
{
    fun create(iD: UUID, constructArgs: LabelComponentConstructArgs): LabelComponent
    {
        return LabelComponent(iD, constructArgs.defaultName, constructArgs.namePropertyName)
    }
}