# RandomGenerator

Kotlin/Java library for generating random numbers with 
dice and distributions.

See JavaDoc for details.

## Quick Start

### Rolling a die

```kotlin
val die = Die(6) // Six-sided die
println(die.roll()) // Roll a die
```

### Rolling a weighted die
```kotlin
val weightedDie = WeightedDie(2, listOf(0.1, 0.9))
println(weightedDie.roll()) // More likely to get a 2 than 1
```

### Rolling a pack of dice

```kotlin
val dice = DicePack(listOf(Die(20), Die(6), Die(10)))
println(dice.roll()) // Sum of all points
```

### Pick a random number from N(mean, variance)

```kotlin
val norm = NormalDistribution(0.0, 1.0)
println(norm.next())
```

### Pick a random number from P(lambda)

```kotlin
val poisson = PoissonDistribution(5)
println(poisson.next())
```
