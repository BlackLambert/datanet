package sbaier.datanet.core

import java.util.*

class BasicNameComponentFactory : NameComponentFactory()
{
    private val _defaultName = "Node (%s)"

    override fun create(iD: UUID): NameComponent
    {
        return NameComponent(iD, NodeComponentType.Name, _defaultName.format(iD.toString()))
    }
}