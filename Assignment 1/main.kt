class Fraction(var numerator: Int, denominator_param: Int) {
    var denominator = denominator_param
            set(value) {
                if (value != 0) field = value
            }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    fun reduce() {
        val gcd = GCD(numerator, denominator)
        numerator /= gcd
        denominator /= gcd
    }

    // ევკლიდეს ალგორითმი ორი რიცხვის უდიდესი საერთო გამყოფის მოსაძებნად
    fun GCD(a: Int, b: Int): Int {
        if (b == 0) return a;
        else {
            return GCD(b, a % b)
        }
    }

    fun multiply(frac: Fraction): Fraction {
        val newNumerator = numerator * frac.numerator
        val newDenominator = denominator * frac.denominator
        return Fraction(newNumerator, newDenominator)
    }

}

fun main() {

    var myFraction = Fraction(6, 45)

    myFraction.reduce()

    println(myFraction.toString())

    val newFraction = myFraction.multiply(Fraction(4, 5))

    println(newFraction.toString())

}

