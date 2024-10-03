import com.example.mvc_mvp_donation.MainActivity

class DonationPresenter(private val view: MainActivity) {

    private val model: DonationModel = DonationModel()

    // Llama al modelo para ingresar dinero
    fun deposit(amount: String) {
        if (model.deposit(amount)) {
            view.displayConfirmationMessage()
            view.updateTotalDonation(model.getBalance())
        } else {
            view.displayErrorMessage()
        }
    }

    // Llama al modelo para retirar dinero
    fun withdraw(amount: String) {
        if (model.withdraw(amount)) {
            view.displayConfirmationMessage()
            view.updateTotalDonation(model.getBalance())
        } else {
            view.displayErrorMessage()
        }
    }

    // Llama al modelo para ver el saldo
    fun viewBalance() {
        view.updateTotalDonation(model.getBalance())
    }
}
