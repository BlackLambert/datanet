package sbaier.datanet.core.net

import sbaier.datanet.core.node.Node
import java.util.UUID

class DataNet(val iD: UUID)
{
    private var iDToNode: HashMap<UUID, Node> = hashMapOf()
    val nodeCount: Int
        get()
        {
            return iDToNode.count()
        }

    fun add(node: Node)
    {
        if(iDToNode.containsKey(node.iD))
            throw IllegalArgumentException("Adding node $node failed. " +
                    "There already has been a node with iD ${node.iD} added to this data net.")
        iDToNode[node.iD] = node
    }

    fun remove(node: Node)
    {
        if(!iDToNode.containsKey(node.iD))
            throw IllegalArgumentException("Removing node $node failed. " +
                    "There has been no node with iD ${node.iD} added to this data net.")
        iDToNode.remove(node.iD)
    }

    fun get(iD: UUID): Node
    {
        return iDToNode[iD] ?: throw IllegalArgumentException("Validation of node failed. " +
                "There has been no node with iD $iD added to this data net.")
    }

    fun contains(node: Node): Boolean
    {
        return iDToNode.containsKey(node.iD)
    }
}