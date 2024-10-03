package com.example.mvc_mvp_donation

import DonationPresenter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc_mvp_donation.databinding.ActivityMainBinding

interface IViewPresenter {

}

class MainActivity : AppCompatActivity(), IViewPresenter {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: DonationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = DonationPresenter(this)

        binding.btnVerSaldo.setOnClickListener { presenter.viewBalance() }
        binding.btnIngresarDinero.setOnClickListener { depositMoney() }
        binding.btnSacarDinero.setOnClickListener { withdrawMoney() }
        binding.btnSalir.setOnClickListener { finish() }
    }

    private fun depositMoney() {
        val amount = binding.etAmount.text.toString()
        presenter.deposit(amount)
    }

    private fun withdrawMoney() {
        val amount = binding.etAmount.text.toString()
        presenter.withdraw(amount)
    }

    fun updateTotalDonation(totalAmount: Int) {
        binding.tvBalance.text = getString(R.string.balance, totalAmount.toString())
    }

    fun displayConfirmationMessage() {
        Toast.makeText(this, "Operación exitosa", Toast.LENGTH_SHORT).show()
    }

    fun displayErrorMessage() {
        Toast.makeText(this, "Operación fallida", Toast.LENGTH_SHORT).show()
    }
}
