package sbaier.datanet.core

import java.util.UUID

class DataNet(val iD: UUID)
{
    private var iDToNode: HashMap<UUID, Node> = hashMapOf()
    val count: Int
        get()
        {
            return iDToNode.count()
        }

    public fun add(node: Node)
    {
        if(iDToNode.containsKey(node.iD))
            throw IllegalArgumentException("Adding node $node failed. " +
                    "There already has been a node with iD ${node.iD} added to this data net.")
        iDToNode[node.iD] = node
    }

    public fun remove(node: Node)
    {
        if(!iDToNode.containsKey(node.iD))
            throw IllegalArgumentException("Removing node $node failed. " +
                    "There has been no node with iD ${node.iD} added to this data net.")
        iDToNode.remove(node.iD)
    }

    public fun get(iD: UUID): Node
    {
        return iDToNode[iD] ?: throw IllegalArgumentException("Validation of node failed. " +
                "There has been no node with iD $iD added to this data net.")
    }

    public fun contains(node: Node): Boolean
    {
        return iDToNode.containsKey(node.iD)
    }
}