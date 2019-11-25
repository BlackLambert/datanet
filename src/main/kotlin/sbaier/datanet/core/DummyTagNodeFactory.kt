package sbaier.datanet.core

import java.util.*

class DummyTagNodeFactory : TagNodeFactory()
{
    private val _defaultTagName = "TagName"

    override fun create(name: String): TagNode {
        return TagNode(name, UUID.randomUUID())
    }

    override fun create(): TagNode {
        val iD = UUID.randomUUID()
        return TagNode("${_defaultTagName}_${iD.toString()}", iD)
    }

}