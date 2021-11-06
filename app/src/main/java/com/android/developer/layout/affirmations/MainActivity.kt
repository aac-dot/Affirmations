package com.android.developer.layout.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.layout.affirmations.adapter.ItemAdapter
import com.android.developer.layout.affirmations.data.DataSource
import com.android.developer.layout.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // É necessário usar as classes Datasource e ItemAdapter para criar e exibir itens no RecyclerView.
        val myDataSet = DataSource().loadAffirmations()
        val recyclerView : RecyclerView = binding.recyclerView

        /*
        * Para instruir o recyclerView a usar a classe ItemAdapter, é criado uma nova instância ItemAdapter.
        * O ItemAdapter espera dois parâmetros: o contexto (this) da atividade e as afirmações em myDataset.
        * */
        recyclerView.adapter = ItemAdapter(this, myDataSet)

        /*
        * Como o tamanho do layout do RecyclerView é fixo no layout da atividade, é possível definir o parâmetro setHasFixedSize do RecyclerView como true.
        * Essa configuração só é necessária para melhorar o desempenho.
        * */
        recyclerView.setHasFixedSize(true)

        setContentView(binding.root)
    }
}