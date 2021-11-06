package com.android.developer.layout.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.layout.affirmations.R
import com.android.developer.layout.affirmations.databinding.ItemViewHolderBinding
import com.android.developer.layout.affirmations.model.Affirmation

/*
* É necessário adicionar um parâmetro ao construtor do ItemAdapter para que possa transmitir a lista de afirmações ao adaptador.
*
* O ItemAdapter precisa de informações sobre como resolver os recursos de string.
* Essa e outras informações sobre o app são armazenadas em uma instância de objeto Context
* que pode ser transmitida para uma instância ItemAdapter.
* */
class ItemAdapter(private val context : Context, private val dataSet : List<Affirmation>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /*
    * O método onCreateViewHolder() é chamado pelo gerenciador de layout para criar novos armazenadores de visualização para o RecyclerView
    * (quando não há armazenadores de visualização existentes que possam ser reutilizados).
    * Lembre-se de que um armazenador de visualização representa uma única visualização de item da lista.
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /*
        * Um parâmetro parent, que é a visualização em grupo a que a nova visualização de item da lista será anexada como filha.
        * O RecyclerView é a visualização mãe.
        *
        * Um parâmetro viewType que se torna importante quando há vários tipos de visualização de itens no mesmo RecyclerView.
        * Se houver diferentes layouts de item de lista sendo exibidos no RecyclerView, há diferentes tipos de visualização de itens.
        * Só é possível reciclar visualizações com o mesmo tipo de visualização de item. Nesse caso, há somente um layout de item de lista
        * e um tipo de visualização de item, portanto, não precisa se preocupar com esse parâmetro.
        * */

        /*
        * Acesse uma instância do LayoutInflater com o contexto fornecido (context do parent).
        * O inflador de layout sabe como inflar um layout XML em uma hierarquia de objetos de visualização.
        * Quando você tiver uma instância de objeto LayoutInflater, adicione um ponto seguido por outra chamada de método para inflar a visualização real
        * do item da lista. Transmita o ID do recurso de layout XML R.layout.list_item e a visualização em grupo parent.
        * O terceiro argumento booleano será attachToRoot.
        * Esse argumento precisa ser false, porque o RecyclerView adicionará esse item à hierarquia de visualização no momento certo.
        * */
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_view_holder, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /*
    * Esse método é chamado pelo gerenciador de layout para substituir o conteúdo de uma visualização de item de lista.
    * O método onBindViewHolder() tem dois parâmetros, um ItemViewHolder criado anteriormente pelo método onCreateViewHolder()
    * e um Int que representa a position do item atual na lista.
    * Neste método, você encontrará o objeto Affirmation correto do conjunto de dados com base na posição.
    * */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /*
    * O método getItemCount() precisa retornar o tamanho do conjunto de dados.
    * Os dados do app estão na propriedade dataset que está sendo transmitido ao construtor do ItemAdapter,
    * e poderá acessar o tamanho usando size.
    * */
    override fun getItemCount() = dataSet.size

    /*
    * O RecyclerView não interage diretamente com as visualizações de itens, mas lida com ViewHolders.
    * Um ViewHolder representa uma única visualização de item de lista em um RecyclerView e pode ser reutilizado sempre que possível.
    * Uma instância ViewHolder contém referências às visualizações individuais em um layout de item de lista.
    * Daí o nome "view holder", que significa armazenador de visualizações.
    * Isso facilita a atualização da visualização de itens da lista com novos dados.
    * Os armazenadores de visualização também adicionam informações que o RecyclerView usa para mover as visualizações pela tela de maneira eficiente.
    * */
    inner class ItemViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.item_title)
        val imageView : ImageView = view.findViewById(R.id.item_image)

    }
}