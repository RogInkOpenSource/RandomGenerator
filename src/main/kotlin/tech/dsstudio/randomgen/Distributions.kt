package tech.dsstudio.randomgen

import java.util.LinkedList
import kotlin.math.pow

abstract class Distribution {
	abstract fun next(): Double
}

data class NormalDistribution(val mean: Double, val variance: Double): Distribution() {
	private val deque = LinkedList<Double>()
	private val sampleSize = 32

	init {
		repeat(sampleSize) {
			deque.add(Math.random())
		}
	}

	override fun next(): Double {
		val result = deque.reduce { acc, d -> acc + d } - sampleSize / 2
		deque.poll()
		deque.add(Math.random())
		return (result) * variance + mean
	}
}

data class PoissonDistribution(val lambda: Int): Distribution() {
	override fun next(): Double {
		val l = Math.E.pow(-lambda)
		var k = 0
		var p = 1.0
		do {
			k += 1
			p *= Math.random()
		} while (p > l)
		return (k - 1).toDouble()
	}
}
