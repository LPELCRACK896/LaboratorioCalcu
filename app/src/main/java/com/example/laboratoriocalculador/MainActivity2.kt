package com.example.laboratoriocalculador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
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
        btnDividir.setOnClickListener { writeChar("/") }
        btnPunto.setOnClickListener { writeChar(".") }
        btnParentesis1.setOnClickListener { writeChar("(") }
        btnParentesis2.setOnClickListener { writeChar(")") }
        //btnIgual.setOnClickListener { writeChar(".") }
        btnMasMenos.setOnClickListener { writeChar("MASMENOS") }
        btnC.setOnClickListener { writeChar("") }

    }

    fun writeChar(numero:String) {
        val txtValue:TextView = findViewById(R.id.txtValue)
        if(numero==""){
            txtValue.text =""
        }else if(numero=="MASMENOS"){
            //if(txtValue.text.inde=="+"){
            //Pendiente tratar un posible error
            //}
            txtValue.text ="-(${txtValue.text})"
        }else txtValue.text = "${txtValue.text}$numero"

    }
}
