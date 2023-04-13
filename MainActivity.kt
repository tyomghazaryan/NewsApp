class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ItemAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.items.observe(this, Observer {
            adapter.setItems(it)
        })

        viewModel.loadItems()
    }
}
