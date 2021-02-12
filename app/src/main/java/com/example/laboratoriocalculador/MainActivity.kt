package com.example.laboratoriocalculador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity: AppCompatActivity() {
    private var operador_global: String = ""
    private var reseteo: Boolean = true
    private var resultado: Double = 0.00;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btnSumar: Button = findViewById(R.id.btnSumar)
        val btnDividir: Button = findViewById(R.id.btnDividir)
        val btnRestar: Button = findViewById(R.id.btnRestar)
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicar)
        val btnC: Button = findViewById(R.id.btnC)
        val btnIgual: Button = findViewById(R.id.btnIgual)
        val btnMasMenos:Button= findViewById(R.id.btnMasMenos)
        val btnPunto:Button = findViewById(R.id.btnPunto)
        val btnParentesis1:Button = findViewById(R.id.btnParentesis1)
        val btnParentesis2:Button = findViewById(R.id.btnParentesis2)

        btn0.setOnClickListener { writeChar("0") }
        btn1.setOnClickListener { writeChar("1") }
        btn2.setOnClickListener { writeChar("2") }
        btn3.setOnClickListener { writeChar("3") }
        btn4.setOnClickListener { writeChar("4") }
        btn5.setOnClickListener { writeChar("5") }
        btn6.setOnClickListener { writeChar("6") }
        btn7.setOnClickListener { writeChar("7") }
        btn8.setOnClickListener { writeChar("8") }
        btn9.setOnClickListener { writeChar("9") }
        btnSumar.setOnClickListener { writeChar("+") }
        btnRestar.setOnClickListener { writeChar("-") }
        btnMultiplicar.setOnClickListener { writeChar("*") }
        btnDividir.setOnClickListener { writeChar("÷") }
        btnPunto.setOnClickListener { writeChar(".") }
        btnParentesis1.setOnClickListener { clear("CE") }
        btnParentesis2.setOnClickListener { clear("←") }
        btnIgual.setOnClickListener { writeChar("=") }
        btnMasMenos.setOnClickListener { writeChar("MASMENOS") }
        btnC.setOnClickListener { clear("C") }

    }

    private fun clear(borrar: String) {
        val txtValue: TextView = findViewById(R.id.txtValue)
        val txtValue1: TextView = findViewById(R.id.txtValue1)
        if(borrar == "C") {
            txtValue.text =""
            txtValue1.text = ""
            this.resultado = 0.00
            this.operador_global = ""
            this.reseteo = true
        } else if (borrar == "CE") {
            txtValue1.text = ""
            if(this.operador_global == "=")
                this.resultado = 0.00
        } else if(borrar == "←") {
            if("${txtValue1.text}".length > 0) {
                txtValue1.text = "${txtValue1.text}".dropLast(1)
                try {
                    this.resultado = "${txtValue1.text}".toDouble()
                } catch(e: Exception) {
                    this.resultado = 0.00
                }
            }
        }
    }

    private fun writeChar(numero: String) {
        val txtValue: TextView = findViewById(R.id.txtValue)
        val txtValue1: TextView = findViewById(R.id.txtValue1)
        if(numero == "MASMENOS"){
            var valor_actual: String = "${txtValue1.text}"
            if(valor_actual.length > 0) {
                if(valor_actual[0] == '-') {
                    txtValue1.text = valor_actual.replace("-", "")
                } else {
                    txtValue1.text = "-${valor_actual}"
                }
            }
        } else if (numero == "*" || numero == "÷" || numero == "-" || numero == "+" || numero == "=") {

            var valor_inicial: String = "${txtValue.text}${txtValue1.text}"
            var valor: String = "${txtValue.text}"
            if(valor.length > 1) {
                if(valor[valor.length - 2] == '=') {
                    valor_inicial= "${txtValue.text}${this.resultado} ${this.operador_global} ${txtValue1.text}"
                }
            }
            txtValue1.text = calculateAnswer()
            if(txtValue1.text == "") {
                txtValue1.text = valor_inicial
                txtValue.text = "${valor_inicial} $numero "
            } else if(txtValue1.text == "none") {
                txtValue1.text = "${this.resultado}"
            } else if(this.operador_global == "=" && "${txtValue1.text}".length > 0) {
                txtValue.text = "${txtValue1.text} $numero "
            } else {
                txtValue.text = "${valor_inicial} $numero "
            }
            this.reseteo = true
            this.operador_global = numero
        }  else {
            if(this.reseteo)
                txtValue1.text = numero
            else
                txtValue1.text = "${txtValue1.text}$numero"
            this.reseteo = false
        }
    }

    private fun calculateAnswer() : String {
        if(this.operador_global == "=") {
            return "none"
        }
        val txtValue: TextView = findViewById(R.id.txtValue)
        val txtValue1: TextView = findViewById(R.id.txtValue1)
        if(txtValue.text == "") {
            this.resultado = 0.00
            return ""
        } else {
            var valor_inicial: Double = "${txtValue.text}".split(" ")[0].toDouble()
            if(this.resultado != 0.00) {
                valor_inicial = this.resultado
            }
            return if(this.operador_global == "*") {
                this.resultado = valor_inicial * txtValue1.text.toString().toDouble()
                "${this.resultado}"
            } else if(this.operador_global == "÷") {
                this.resultado = valor_inicial / txtValue1.text.toString().toDouble()
                "${this.resultado}"
            } else if(this.operador_global == "-") {
                this.resultado = valor_inicial - txtValue1.text.toString().toDouble()
                "${this.resultado}"
            } else if(this.operador_global == "+") {
                this.resultado = valor_inicial + txtValue1.text.toString().toDouble()
                "${this.resultado}"
            } else {
                this.resultado = 0.00
                ""
            }
        }
    }
}