package sbaier.datanet.core

import java.util.*

abstract class NameComponentFactory
{
    abstract fun create(iD: UUID, constructArgs: NameComponentConstructArgs): NameComponent
}