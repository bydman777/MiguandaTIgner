package tigner.miguanda.spacexdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import dagger.hilt.android.AndroidEntryPoint
import tigner.miguanda.spacexdata.databinding.ActivityItemDetailBinding
//TODO Read this!
/**
 * A couple of notes
 * First of all, thank for for the interview and the follow up sample project, interviews take so much
 * time so it means so much that you've put your time for me
 * Secondly, I apologize for the delay, I explained to Ivy that I might not have time this weekend
 * still my responsibility as I had to be more clear
 * Now as for the project:
 * No Testing whatsoever!!! The reason being the moment before I was going to upload the project
 * all tests failed with the message "test events were not received" and I'm just too tired at this
 * time to try to fix them (psst, I did try but it did not work so had to just abort the mission)
 * After that, there are a lot of things that I would change here, we need an action bar , we need animation
 * , hopefully we need compose we need directions instead of bundles, but again due to the shortage
 * of time I had to use the Android studio gallery project and build on top of it, again it's my
 * fault and I had to put more time into but but I couldn't so there's that
 *
 * Last but not least, Good luck!
 *
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_item_detail) as NavHostFragment
//        val navController = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_item_detail)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}