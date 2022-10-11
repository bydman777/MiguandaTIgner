package tigner.miguanda.spacexdata.detail

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tigner.miguanda.spacexdata.data.model.Launch
import tigner.miguanda.spacexdata.data.repository.Repository
import tigner.miguanda.spacexdata.data.repository.Response
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    private val _errorMessage: MutableLiveData<String> = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage
    private val _launch = MutableLiveData<Launch>()
    val launch: LiveData<Launch>
        get() = _launch

    fun getLaunchData(flightNumber: Int){
        viewModelScope.launch {
                with(repository.getLaunchByFlightNumber(flightNumber)) {
                    when (this) {
                        is Response.Success -> {
                            _launch.value = data as Launch
                        }
                        is Response.Error -> {
                            message?.let { _errorMessage.value = it }
                        }
                    }
            }
        }
    }

    fun messageShown(){
        _errorMessage.value = ""
    }
}