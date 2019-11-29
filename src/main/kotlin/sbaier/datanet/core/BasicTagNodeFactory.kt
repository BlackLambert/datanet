package sbaier.datanet.core

import sbaier.identification.UUIDGenerator

class BasicTagNodeFactory(private val _iDGenerator: UUIDGenerator) : TagNodeFactory()
{
    private var _defaultTagName = "TagName"

    constructor(defaultTagName: String, iDGenerator: UUIDGenerator) : this(iDGenerator) {
        _defaultTagName = defaultTagName
    }

    override fun create(name: String): TagNode {
        val iD = _iDGenerator.create()
        return TagNode(name, iD)
    }

    override fun create(): TagNode {
        val iD = _iDGenerator.create()
        return TagNode("${_defaultTagName}_${iD.toString()}", iD)
    }

}