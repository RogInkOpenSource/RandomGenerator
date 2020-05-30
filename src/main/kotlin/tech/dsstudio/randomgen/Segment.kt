package tech.dsstudio.randomgen

data class Segment<ValueType>(val leftBound: Double, val rightBound: Double, val value: ValueType)

data class SegmentList<ValueType>(val list: List<Segment<ValueType>>) {
    fun get(value: Double): ValueType? = list.find { it.leftBound <= value && it.rightBound > value }?.value
}
