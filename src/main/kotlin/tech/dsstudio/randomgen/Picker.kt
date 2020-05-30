package tech.dsstudio.randomgen

import kotlin.random.Random

data class Picker<T>(private val items: List<T>) {
	fun pickOne(): T {
		return items[Random.nextInt(items.size)]
	}

	fun pickSomeNonRepeating(size: Int): List<T> {
		assert(size <= items.size && size > 0)
		val list = shuffler.shuffle()
		return list.subList(0, size)
	}

	@ExperimentalStdlibApi
	fun pickSome(size: Int): List<T> {
		return buildList {
			repeat(size) {
				add(items[Random.nextInt(items.size)])
			}
		}
	}

	private val shuffler = Shuffler(items)
}
