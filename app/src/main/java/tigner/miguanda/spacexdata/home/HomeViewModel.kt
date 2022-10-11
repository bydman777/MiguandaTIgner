package tigner.miguanda.spacexdata.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tigner.miguanda.spacexdata.data.model.Launch
import tigner.miguanda.spacexdata.data.repository.Repository
import tigner.miguanda.spacexdata.data.repository.Response
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    private val _errorMessage: MutableLiveData<String> = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage


    private val _launchList = MutableLiveData<List<Launch>>()
    val launchList: LiveData<List<Launch>>
        get() = _launchList

    init {
        viewModelScope.launch {
            with(repository.getAllLaunches()) {
                when (this) {
                    is Response.Success -> {
                        _launchList.value = data as List<Launch>
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