package sbaier.datanet.core.node

import sbaier.datanet.core.node.Node
import sbaier.datanet.core.node.NodeDataExtractor
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertSame

class NodeDataExtractorTest
{
    lateinit var firstNode: Node
    lateinit var extractor: NodeDataExtractor


    @BeforeTest
    fun setup()
    {
        firstNode = Node(UUID.randomUUID())
        extractor = NodeDataExtractor(firstNode)
    }

    @Test
    fun extract_DataIDAndNodeIDAreIdentical()
    {
        var data = extractor.extract()
        assertSame(data.iD, firstNode.iD, "Both the data id and the node id have to be identical" +
                "after extraction.")
    }
}