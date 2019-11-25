package sbaier.datanet.core

import java.util.*

class BasicTagNodeFactory() : TagNodeFactory()
{
    private var _defaultTagName = "TagName"

    constructor(defaultTagName: String) : this() {
        _defaultTagName = defaultTagName
    }

    //Todo UUID Generierung kapseln
    //Todo add create function with stringified iD Input
    override fun create(name: String): TagNode {
        return TagNode(name, UUID.randomUUID())
    }

    override fun create(): TagNode {
        val iD = UUID.randomUUID()
        return TagNode("${_defaultTagName}_${iD.toString()}", iD)
    }

}