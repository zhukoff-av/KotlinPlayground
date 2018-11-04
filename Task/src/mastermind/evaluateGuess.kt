package mastermind

data class Evaluation(val positions: Int, val letters: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
//    var positions = 0
//    var letters = 0
//
//    for (i in 0 until 4) {
//        if (guess[i] == secret[i])
//            positions++
//        else if (guess[i] in secret)
//            letters++
//    }
//    return Evaluation(positions, letters)

    var positions = 0
    var letters = 0
    val firstMach = BooleanArray(4)
    val secondMach = BooleanArray(4)
    for (i in 0 until 4) {
        if (secret[i] == guess[i]) {
            firstMach[i] = true
            secondMach[i] = true
            positions++
        }
    }

    for (i in 0 until 4) {
        if (firstMach[i]) continue
        for (j in 0 until 4) {
            if (i == j || secondMach[j]) continue
            if (secret[i] == guess[j]) {
                secondMach[j] = true
                letters++
                break
            }
        }
    }
    return Evaluation(positions, letters)
}