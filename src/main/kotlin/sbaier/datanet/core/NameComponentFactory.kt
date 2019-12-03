package sbaier.datanet.core

import java.util.*

class NameComponentFactory
{
    fun create(iD: UUID, constructArgs: NameComponentConstructArgs): NameComponent
    {
        return NameComponent(iD, constructArgs.defaultName, constructArgs.namePropertyName)
    }
}