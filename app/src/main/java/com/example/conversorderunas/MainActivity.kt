package com.example.conversorderunas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val ELDER_FUTHARK: Map<String, String> = mapOf(
        "a" to "ᚨ", "b" to "ᛒ", "c" to "ᚲ",
        "d" to "ᛞ", "e" to "ᛖ", "f" to "ᚠ",
        "g" to "ᚷ", "h" to "ᚺ", "i" to "ᛁ",
        "j" to "ᛃ", "k" to "ᚲ", "l" to "ᛚ",
        "m" to "ᛗ", "n" to "ᚾ", "o" to "ᛟ",
        "p" to "ᛈ", "q" to "ᚲ", "r" to "ᚱ",
        "s" to "ᛋ", "t" to "ᛏ", "u" to "ᚢ",
        "v" to "ᚹ", "w" to "ᚹ", "x" to "ᛋ",
        "y" to "ᛋ", "z" to "ᛉ", " " to " ",
        "th" to "ᚦ"
    )

    private lateinit var etTexto: EditText
    private lateinit var btnConverter: Button
    private lateinit var tvResultado: TextView
    private lateinit var ivImage: ImageView
    private lateinit var btnClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTexto = findViewById(R.id.et_texto)
        btnConverter = findViewById(R.id.btn_converter)
        tvResultado = findViewById(R.id.tv_resultado)
        ivImage = findViewById(R.id.iv_image)
        btnClear = findViewById(R.id.btn_clear)

        btnConverter.setOnClickListener {
            converterParaElderFuthark()
        }

        btnClear.setOnClickListener {
            limparDados()
        }
    }

    private fun converterParaElderFuthark() {
        val textoOriginal = etTexto.text.toString()
        val textoEmElderFuthark = textoParaElderFuthark(textoOriginal, ELDER_FUTHARK)
        tvResultado.text = " $textoEmElderFuthark"
    }
    private fun textoParaElderFuthark(texto: String, mapeamento: Map<String, String>): String {
        var runas = ""
        var i = 0

        while (i < texto.length) {
            // Verifica se a substring de duas letras é 'th'
            if (i < texto.length - 1 && texto.substring(i, i + 2).lowercase(Locale.ROOT) == "th") {
                runas += mapeamento["th"] ?: "th"
                i += 2
            } else if (i < texto.length - 1 && mapeamento.containsKey(texto.substring(i, i + 2))) {
                runas += mapeamento[texto.substring(i, i + 2)]
                i += 2
            } else {
                runas += mapeamento[texto[i].toString().lowercase(Locale.ROOT)] ?: texto[i]
                i++
            }
        }

        return runas
    }

    private fun limparDados() {
        etTexto.text.clear()
        tvResultado.text = ""
    }

        }





