package kg.example.lovecalculator.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.lovecalculator.R
import kg.example.lovecalculator.databinding.BoardBinding

class BoardAdapter(private val click: () -> Unit) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    private val titles = arrayListOf("Привет", " Hello", "Bonjur", "Салам")
    private val descreptions = arrayListOf("Бул тиркеме суйуу жонундо", "", "", "")
    private val images =
        arrayListOf(R.drawable.serdca, R.drawable.tree, R.drawable.serdca, R.drawable.tree)

    inner class ViewHolder(private val binding: BoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvTitle.text = titles[position]
            binding.tvDescreption.text = descreptions[position]
            binding.imageBoard.setImageResource(images[position])
            binding.btnStart.setOnClickListener {
                click()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BoardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}