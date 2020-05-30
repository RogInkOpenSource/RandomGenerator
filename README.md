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

### Pick an element from a collection
```kotlin
val list = listOf(1, 2, 3, 4)
val picker = Picker(list)
println(picker.pickOne())
```

### Pick a subset
```kotlin
val list = listOf(1, 2, 4, 8)
val picker = Picker(list)
println(picker.pickSomeNonRepeating(3))
```

### Shuffle a deck of cards
```kotlin
val cards = listOf( /* ... */ )
val shuffler = Shuffler(cards)
println(shuffler.shuffle())
```

## They could be extensions

Yes, it would be nice if they were extensions to List<T>. 
While for the sake of Java compatibility, I figured it could be nice to 
just make them standalone classes.
