package mastermind

data class Evaluation(val positions: Int, val letters: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var positions = 0
    var letters = 0

    for (i in 0 until 4) {
        if (guess[i] == secret[i])
            positions++
        else if (guess[i] in secret)
            letters++
    }
    return Evaluation(positions, letters)
}