package tech.dsstudio.randomgen

import java.util.LinkedList

data class NormalDistribution(val mean: Double, val variance: Double) {
    private val deque = LinkedList<Double>()
    private val sampleSize = 32

    init {
        repeat(sampleSize) {
            deque.add(Math.random())
        }
    }

    fun next(): Double {
        val result = deque.reduce { acc, d -> acc + d } - sampleSize / 2
        deque.poll()
        deque.add(Math.random())
        return (result) * variance + mean
    }
}
