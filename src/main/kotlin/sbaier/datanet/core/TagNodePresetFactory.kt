package sbaier.datanet.core

class TagNodePresetFactory()
{
    private val _presetName = "Tag"
    private val _namePropertyName = "Tag Name"
    private val _nameValue = "New Tag"

    fun create(): NodePreset
    {
        val componentTypes = listOf(NodeComponentType.Name)
        val nameArgs: NodeComponentConstructArgs = NameComponentConstructArgs(_namePropertyName, _nameValue)
        val args = hashMapOf(NodeComponentType.Name to nameArgs)
        return NodePreset(_presetName, componentTypes, args)
    }
}