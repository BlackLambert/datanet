package sbaier.datanet.core.node

class TagNodePresetFactory()
{
    private val _presetName = "Tag"
    private val _namePropertyName = "Tag Label"
    private val _nameValue = "New Tag"

    fun create(): NodePreset
    {
        val componentTypes = listOf(NodeComponentType.Label)
        val nameArgs: NodeComponentConstructArgs = LabelComponentConstructArgs(_namePropertyName, _nameValue)
        val args = hashMapOf(NodeComponentType.Label to nameArgs)
        return NodePreset(_presetName, componentTypes, args)
    }
}