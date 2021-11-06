package com.android.developer.layout.affirmations.data

import com.android.developer.layout.affirmations.R
import com.android.developer.layout.affirmations.model.Affirmation

/*
* Os dados exibidos no app podem vir de fontes diferentes
* (por exemplo, dentro do projeto do app ou de uma fonte externa que exija conexão com a Internet
* para fazer o download de dados).
* Como resultado, os dados podem não estar no formato exato que é preciso.
* O restante do app não precisa se preocupar com o local de origem dos dados ou o formato original deles.
* É ocultado essa preparação de dados em uma classe Datasource separada que prepare os dados para o app.
* */
class DataSource {
    /*
    * A função loadAffirmations() precisa retornar uma lista de Affirmations.
    * Para fazer isso, é criada uma lista e preenchida com uma instância Affirmation para cada string de recurso.
    * */
    fun loadAffirmations() : List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }
}