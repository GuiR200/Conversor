package br.com.guilhermerodrigues.comversordemoedas.repository

import android.content.Context
import android.util.Log
import br.com.guilhermerodrigues.comversordemoedas.model.IObservel
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RateAPI {
    fun getCurrency(
        context: Context,
        observer: IObservel
    ) {
        val url = "https://api.hgbrasil.com/finance?key=df1b1400"
        val queue = Volley.newRequestQueue(context)
        val stringReq = StringRequest(
            Request.Method.GET,
            url,


            {
                result->
                val jsonObject = JSONObject(result)
                val results = jsonObject.getJSONObject("results")
                val currencies = results.getJSONObject("currencies")
                val dollarValue = currencies.getJSONObject("USD").getDouble("buy")
                val euroValue = currencies.getJSONObject("EUR").getDouble("buy")

                val map = mutableMapOf<String,Any>()
                map["dollar"] = dollarValue
                map["euro"] = euroValue

                observer.upedateUI(map)

            },
            {
                Log.e("APPDEBUG", "Erro!!!")
            }
        )
        queue.add(stringReq)
        }
    }