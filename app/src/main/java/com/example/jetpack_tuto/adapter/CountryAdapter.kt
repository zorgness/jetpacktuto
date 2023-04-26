package com.example.jetpack_tuto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_tuto.dataclass.CountryDto
import com.example.jetpack_tuto.*
import com.example.jetpack_tuto.databinding.ActivityRecyclerCountryBinding
import com.example.jetpack_tuto.databinding.ItemRvCountryBinding
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import androidx.recyclerview.widget.ListAdapter


class MyDiffUtil: DiffUtil.ItemCallback<CountryDto>() {
    override fun areItemsTheSame(oldItem: CountryDto, newItem: CountryDto): Boolean {
       return oldItem.idPays == newItem.idPays
    }

    override fun areContentsTheSame(oldItem: CountryDto, newItem: CountryDto): Boolean {
        return oldItem == newItem
    }

}

class CountryAdapter() : ListAdapter<CountryDto, CountryAdapter.CountryViewHolder>(MyDiffUtil()){

    //SEUL METHODE INVOKE
    private var countries: MutableList<CountryDto> = mutableListOf()
   /* var onUpdateItemCallback: ((CountryDto) -> Unit)? = null
    var onDeleteItemCallback: ((CountryDto) -> Unit)? = null*/

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryAdapter.CountryViewHolder {
       /* LayoutInflater.from(parent.context).inflate(R.layout.item_rv_country, parent, false).let {
            return CountryViewHolder(it)
        }*/
        return LayoutInflater.from(parent.context).inflate(R.layout.item_rv_country, parent, false).run {
            CountryViewHolder( this)
        }

    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {

        //OBLIGATION D UTILLISER UNE DATA CLASS
            val country: CountryDto = getItem(position)

            with(holder.binding) {
                tvNameItemRvCountry.text = country.nom
                Picasso.get()
                    .load(country.url).error(R.drawable.ic_launcher_background)
                    .resize(300, 300)
                    .into(civImageItemRvCountry)

              /*  //DELETE COUNTRY
                ivTrash.setOnClickListener {
                    onDeleteItemCallback?.invoke(country)
                }

                //UPDATE COUNTRY
                tvName.setOnClickListener {
                    onUpdateItemCallback?.invoke(country)
                }*/

        }
    }

  /*  fun setCountries(list: List<CountryDto>) {
        countries.clear()
        countries.addAll(list)
        notifyDataSetChanged()
    }*/

  /*  override fun getItemCount(): Int {
        return countries.size
    }*/

  /*  inner class CountryViewHolder(private val binding: ItemRvCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        *//*val tvName: TextView = itemView.findViewById(R.id.tv_name_item_rv_country)
        val civImage: CircleImageView = itemView.findViewById(R.id.civ_image_item_rv_country)
        val ivTrash: ImageView = itemView.findViewById(R.id.iv_delete_item_rv_country)*//*

        val tvName = binding.tvNameItemRvCountry
        val civImage = binding.civImageItemRvCountry
        val ivTrash = binding.ivDeleteItemRvCountry

    }*/

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val binding = ItemRvCountryBinding.bind(itemView)

    }

}