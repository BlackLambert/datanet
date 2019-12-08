package sbaier.datanet.core.footage

import java.util.*

abstract class FootageAdministrator
{
    abstract fun register(input: Footage)
    abstract fun remove(footageID: UUID)
    abstract fun get(footageID: UUID)
}