package tech.dsstudio.randomgen.tests

import org.junit.Test
import tech.dsstudio.randomgen.WeightedDie

import org.junit.Assert.*
import tech.dsstudio.randomgen.NormalDistribution
import tech.dsstudio.randomgen.Segment
import tech.dsstudio.randomgen.SegmentList
import kotlin.math.abs

class Tests {
    @ExperimentalStdlibApi
    @Test
    fun normalizingArrays() {
        val list = listOf(20.0, 30.0, 40.0, 10.0)
        val target = listOf(0.2, 0.3, 0.4, 0.1)
        assertEquals(target, WeightedDie.normalize(list))
    }

    @Test
    fun pickFromSegments() {
        val seg = listOf(Segment(.0, 0.2, 1), Segment(0.2, 0.5, 2))
        val segment = SegmentList(seg)
        assertNull(segment.get(0.5))
        assertEquals(1, segment.get(0.1))
    }

    @ExperimentalStdlibApi
    @Test
    fun normalDist() {
        val sampleSize = 50000
        val tolerance = 0.1
        val mean = 0.0
        val variance = 2.0
        val dist = NormalDistribution(mean, variance)
        val list = buildList(sampleSize) { repeat(sampleSize) { add(dist.next()) } }
        val actualMean = list.reduce { acc, d -> acc + d } / sampleSize.toDouble()
        assertTrue("Mean = ${mean}, Actual mean = $actualMean", abs(actualMean - mean) < tolerance)
    }
}
