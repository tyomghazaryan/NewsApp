class MainViewModel : ViewModel() {

    private val apiService = ApiService.create()
    private val _items = MutableLiveData<List<Item>>()

    val items: LiveData<List<Item>>
        get() = _items

    fun loadItems() {
        viewModelScope.launch {
            try {
                val response = apiService.getItems()
                if (response.isSuccessful) {
                    _items.value = response.body()
                }
            } catch (e: Exception) {
                // handle error
            }
        }
    }
}
