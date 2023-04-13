interface ApiService {

    @GET("items")
    suspend fun getItems(): Response<List<Item>>

    companion object {
        private const val BASE_URL = "https://example.com/api/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
