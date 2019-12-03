package sbaier.datanet.core

import java.util.*

class DummyNameComponentFactory() : NameComponentFactory()
{
    override fun create(iD: UUID): NameComponent
    {
        return NameComponent(iD, NodeComponentType.Name, "Name")
    }
}