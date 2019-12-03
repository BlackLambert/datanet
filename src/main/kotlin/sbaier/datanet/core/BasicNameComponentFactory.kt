package sbaier.datanet.core

import java.util.*

class BasicNameComponentFactory : NameComponentFactory()
{
    override fun create(iD: UUID, constructArgs: NameComponentConstructArgs): NameComponent
    {
        return NameComponent(iD, NodeComponentType.Name, constructArgs.defaultName, constructArgs.namePropertyName)
    }
}