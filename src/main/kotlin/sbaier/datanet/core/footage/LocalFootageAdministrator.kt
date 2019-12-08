package sbaier.datanet.core.footage

import sbaier.datanet.Root
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

class LocalFootageAdministrator(private val _root: Root,
                                private val _subPath: String): FootageAdministrator(), Root
{
    override fun register(input: Footage)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(footageID: UUID)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(footageID: UUID)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override val completePath: Path
        get() {return Paths.get(_root.toString(), _subPath)}
}