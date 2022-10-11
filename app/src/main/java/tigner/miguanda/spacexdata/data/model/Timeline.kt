package tigner.miguanda.spacexdata.data.model

import com.google.gson.annotations.SerializedName

data class Timeline(
    val beco: Int,
    val center_core_boostback: Int,
    val center_core_entry_burn: Int,
    val center_core_landing: Int,
    val center_stage_sep: Int,
    val dragon_bay_door_deploy: Int,
    val dragon_separation: Int,
    val dragon_solar_deploy: Int,
    val engine_chill: Int,
    val fairing_deploy: Int,
    val first_stage_boostback_burn: Int,
    val first_stage_entry_burn: Int,
    val first_stage_landing: Int,
    val first_stage_landing_burn: Int,
    val go_for_launch: Int,
    val go_for_prop_loading: Int,
    val ignition: Int,
    val liftoff: Int,
    val maxq: Int,
    val meco: Int,
    val payload_deploy: Int,
    val payload_deploy_1: Int,
    val payload_deploy_2: Int,
    val prelaunch_checks: Int,
    val propellant_pressurization: Int,
    val rp1_loading: Int,
    @SerializedName("seco-1")
    val seco_1: Int,
    @SerializedName("seco-2")
    val seco_2: Int,
    @SerializedName("seco-3")
    val seco_3: Int,
    @SerializedName("seco-4")
    val seco_4: Int,
    val second_stage_ignition: Int,
    val second_stage_restart: Int,
    val side_core_boostback: Int,
    val side_core_entry_burn: Int,
    val side_core_landing: Int,
    val side_core_sep: Int,
    val stage1_lox_loading: Int,
    val stage1_rp1_loading: Int,
    val stage2_lox_loading: Int,
    val stage2_rp1_loading: Int,
    val stage_sep: Int,
    val webcast_launch: Int,
    val webcast_liftoff: Int
)