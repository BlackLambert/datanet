package sbaier.identification

import java.util.*

class UUIDGenerator
{
    fun create(): UUID
    {
        return UUID.randomUUID()
    }

    fun create(stringID: String): UUID
    {
        return UUID.fromString(stringID)
    }
}