package br.edu.mouralacerda.ml23dm03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class CadastroNomes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_nomes)

        val spinner = findViewById<Spinner>(R.id.spinnerAlterar)

        val options = arrayOf("GTI", "ADS")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        spinner.adapter = adapter

        val botaoSalvar = findViewById<Button>(R.id.btnUpdate)
        val nome = findViewById<EditText>(R.id.edtNomeAlterar)
        val idade = findViewById<EditText>(R.id.edtIdadeAlterar)

        botaoSalvar.setOnClickListener {

            val p = Pessoa(nome.text.toString(), idade.inputType, spinner.selectedItem.toString())

            Database.getInstance(this)!!.pessoaDAO().salvar(p)

            finish()
            
        }

    }
}