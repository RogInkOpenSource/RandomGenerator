package tech.dsstudio.randomgen

/**
 * A `n`-sided die.
 *
 * @param sides How many sides does this die have.
 */
open class Die (open val sides: Int) {
	/**
	 * Roll this dice.
	 *
	 * @return A value from 1 to `sides` (both sides included).
	 */
	open fun roll(): Int {
		return (1 .. sides).random()
	}
}

/**
 * A `n`-sided weighted die.
 *
 * @param sides How many sides does this die have.
 * @param weight An array representing the weight of each side, starting from 1 to `n`. The sum of the array shall be 1.
 * Use `WeightedDie::normalize` to normalize the array.
 */
@ExperimentalStdlibApi
data class WeightedDie(override val sides: Int, val weight: Collection<Double>) : Die(sides) {
	private val segments: SegmentList<Int>

	init {
		assert(weight.size == sides)
		assert(weight.reduce { acc, d -> acc + d } == 1.0)
		var acc = 0.0
		val list = buildList {
			weight.forEachIndexed { index, it ->
				add(Segment(acc, acc + it, index + 1))
				acc += it
			}
		}
		segments = SegmentList(list)
	}

	override fun roll(): Int {
		return segments.get(Math.random()) ?: 0
	}

	companion object {
		fun normalize(weight: Iterable<Double>): Collection<Double> {
			val sum = weight.reduce { acc, d -> acc + d }
			return weight.map { it / sum }
		}
	}
}

/**
 * A collection of dice.
 *
 * @param dice Dice
 */
data class DicePack(val dice: Collection<Die>) {
	init {
		assert(dice.isNotEmpty())
	}

	/**
	 * Get the sum of all dice.
	 */
	fun roll(): Int = dice.map { it.roll() }.sum()

	/**
	 * Get the maximum of all dice.
	 */
	fun rollMax(): Int = dice.map { it.roll() }.max() ?: 0

	/**
	 * Get the minimum of all dice.
	 */
	fun rollMin(): Int = dice.map { it.roll() }.min() ?: 0
}
