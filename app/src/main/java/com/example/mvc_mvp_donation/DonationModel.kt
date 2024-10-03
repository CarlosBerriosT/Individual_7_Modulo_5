class DonationModel {
    private var totalAmount: Int = 0

    // Método para ingresar dinero
    fun deposit(amount: String): Boolean {
        val depositAmount = amount.toIntOrNull()
        return if (depositAmount != null && depositAmount > 0) {
            totalAmount += depositAmount
            true
        } else {
            false
        }
    }

    // Método para retirar dinero
    fun withdraw(amount: String): Boolean {
        val withdrawAmount = amount.toIntOrNull()
        return if (withdrawAmount != null && withdrawAmount > 0 && withdrawAmount <= totalAmount) {
            totalAmount -= withdrawAmount
            true
        } else {
            false
        }
    }

    // Método para obtener el saldo
    fun getBalance(): Int {
        return totalAmount
    }
}
