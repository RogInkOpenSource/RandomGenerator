package tech.dsstudio.randomgen

import java.util.LinkedList

data class LinearShiftFeedbackRegister(private val initialState: Collection<Boolean>, private val polynomial: List<Boolean>) {
	init {
		assert(initialState.size == polynomial.size)
		initialState.forEach {
			state.add(it)
		}
	}

	fun next(): Boolean {
		val next = state.zip(polynomial).fold(true) { acc, pair -> if (pair.second) { acc.xor(pair.first) } else { acc } }
		state.poll()
		state.add(next)
		return state.peek()
	}

	companion object {
		fun fromFeedbackPolynomial(str: String) {
			TODO()
		}
	}

	val order: Int
	get() = polynomial.size

	private val state: LinkedList<Boolean> = LinkedList()
}
