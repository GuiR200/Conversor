package br.com.guilhermerodrigues.comversordemoedas.model

import androidx.databinding.ObservableDouble

class Price {
    private var value = ObservableDouble()

    fun getValue() = this.value

    fun setValeue(value:Double){
        this.value.set(value)
    }
}