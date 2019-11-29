package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
import java.util.*

class BasicTagNodeFactory(private val iDGenerator: UUIDGenerator) : TagNodeFactory()
{
    private var _defaultTagName = "TagName"

    constructor(defaultTagName: String) : this() {
        _defaultTagName = defaultTagName
    }

    override fun create(name: String): TagNode {
        return TagNode(name, UUID.randomUUID())
    }

    override fun create(): TagNode {
        val iD = iDGenerator.create()
        return TagNode("${_defaultTagName}_${iD.toString()}", iD)
    }

}