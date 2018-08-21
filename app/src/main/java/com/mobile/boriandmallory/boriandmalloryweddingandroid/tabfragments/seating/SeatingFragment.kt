package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.*
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import kotlinx.android.synthetic.main.fragment_seating.*

/**
 * The fragment for showing the third tab of information.  This will show the seating chart for
 * the tables at the reception.
 */
class SeatingFragment : Fragment(), SeatingContract.View {

    private val presenter = SeatingPresenter()
    private var adapter: SeatingAdapter? = null
    private var searchView: SearchView? = null
    private var currentQuery: String? = null

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [SeatingFragment]
         */
        fun newInstance(args: Bundle? = null): SeatingFragment {
            val fragment = SeatingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_seating, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.search_menu, menu)

        // set up search view
        val searchManager = context?.getSystemService(Context.SEARCH_SERVICE) as? SearchManager
        searchView = menu?.findItem(R.id.action_search)?.actionView as? SearchView
        searchView?.setSearchableInfo(searchManager?.getSearchableInfo(activity?.componentName))
        searchView?.maxWidth = Integer.MAX_VALUE
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                currentQuery = query
                adapter?.filter?.filter(query)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                currentQuery = query
                adapter?.filter?.filter(query)
                return false
            }
        })

        searchView?.setQuery(currentQuery, true)

        if (currentQuery.isNullOrEmpty()) {
            searchView?.isIconified = true
            searchView?.clearFocus()
        } else {
            searchView?.isIconified = false
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.action_search -> true
        else -> super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.bind(this)
        presenter.getSeating()

        seating_recycler_view.layoutManager = LinearLayoutManager(context)
        seating_recycler_view.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        searchView?.isIconified = true
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun setupSeating(seating: List<Seating>) {
        adapter = SeatingAdapter(seating)
        seating_recycler_view.adapter = adapter
    }

    override fun showProgress(show: Boolean) {
        seating_progress.visibility = if (show) View.VISIBLE else View.GONE
        seating_recycler_view.visibility = if (show) View.GONE else View.VISIBLE
    }
}
