class Controller {

    private val model: DonationModel

    init {
        model = DonationModel()
    }

    // Llama al modelo para ingresar dinero
    fun deposit(amount: String): Boolean {
        return model.deposit(amount)
    }

    // Llama al modelo para retirar dinero
    fun withdraw(amount: String): Boolean {
        return model.withdraw(amount)
    }

    // Llama al modelo para obtener el saldo
    fun getBalance(): Int {
        return model.getBalance()
    }
}
