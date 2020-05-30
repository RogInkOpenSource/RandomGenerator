package tech.dsstudio.randomgen

import kotlin.random.Random

private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
	val tmp = this[index1]
	this[index1] = this[index2]
	this[index2] = tmp
}

data class Shuffler<T>(private val list: List<T>) {
	fun shuffle(): List<T> {
		val out = list.toMutableList()
		(0 until out.size).reversed().forEach {
			out.swap(Random.nextInt(it), it)
		}
		return out
	}
}
