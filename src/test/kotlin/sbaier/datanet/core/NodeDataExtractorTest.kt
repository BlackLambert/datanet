package sbaier.datanet.core

import sbaier.identification.UUIDGenerator
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