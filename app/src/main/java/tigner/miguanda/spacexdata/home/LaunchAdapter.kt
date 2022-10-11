package tigner.miguanda.spacexdata.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tigner.miguanda.spacexdata.R
import tigner.miguanda.spacexdata.data.model.Launch
import tigner.miguanda.spacexdata.databinding.ItemListContentBinding

/**
 * List adapter for Launch Items
 * @param onClick This function will be invoked on an item click
 */
class LaunchAdapter(private val onClick: (flightNumber:Int) -> Unit)  :
    RecyclerView.Adapter<LaunchAdapter.LaunchViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Launch>() {
        override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem.flight_number == newItem.flight_number
        }

        override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var items: List<Launch>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun getItemCount() = items.size

    /**
     * Holds the position of the last selected item
     */
    var selectedPos = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(
            ItemListContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class LaunchViewHolder(private val binding: ItemListContentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(launch: Launch) {
            with(binding){
                Glide
                    .with(launchImg)
                    .load(launch.links.mission_patch_small)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launch_patch_placeholder)
                    .into(launchImg);
                missionText.text = launch.mission_name
                rocketNameText.text = launch.rocket.rocket_name
                siteNameText.text = launch.launch_site.site_name
                dateText.text = launch.launch_date_utc
                launchImg.contentDescription = launch.mission_name

                binding.root.setOnClickListener { itemView ->
                    onClick(launch.flight_number)
                    val oldSelected= selectedPos
                    selectedPos = absoluteAdapterPosition
                    notifyItemChanged(oldSelected)
                    notifyItemChanged(selectedPos)
                }

                with(binding.root.context) {
                    if (selectedPos == absoluteAdapterPosition)
                        binding.root.setBackgroundColor(
                            ContextCompat.getColor(this, R.color.teal_200)
                        )
                    else
                        binding.root.setBackgroundColor(
                            ContextCompat.getColor(this, R.color.white)
                        )
                }
            }
        }
    }

}