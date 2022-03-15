package br.com.guilhermerodrigues.comversordemoedas.model

interface IObservel {
    fun upedateUI(data: MutableMap<String, Any>)
}