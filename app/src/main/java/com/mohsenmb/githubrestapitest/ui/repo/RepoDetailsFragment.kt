package com.mohsenmb.githubrestapitest.ui.repo

import android.net.Uri
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import com.mohsenmb.arch.domain.Repo
import com.mohsenmb.githubrestapitest.KEY_DATA
import com.mohsenmb.githubrestapitest.R
import com.mohsenmb.githubrestapitest.ui.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_repo_details.*
import java.text.SimpleDateFormat
import java.util.*

class RepoDetailsFragment : BaseFragment() {

    companion object {
        fun newInstance(repoBundle: Bundle?): RepoDetailsFragment {
            val fragment = RepoDetailsFragment()
            fragment.arguments = repoBundle
            return fragment
        }
    }

    override fun onViewReady(view: View, savedInstanceState: Bundle?) {
        arguments?.getParcelable<Repo>(KEY_DATA)?.let { repo ->
            Picasso
                    .get()
                    .load(Uri.parse(repo.owner.avatar))
                    .placeholder(R.drawable.ic_octoface)
                    .error(R.drawable.ic_octoface)
                    .centerCrop()
                    .fit()
                    .into(image_repo_owner)
            text_repo_title.text = repo.name
            text_author.text = "@${repo.owner.username}"
            text_repo_description.text = repo.repoDescription
            text_stars.text = repo.stars.toString()
            text_forks.text = repo.forks.toString()

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val updatedAt: Date = dateFormat.parse(repo.updatedAt)

            val text = DateUtils.getRelativeDateTimeString(context, updatedAt.time, DateUtils.SECOND_IN_MILLIS,
                    DateUtils.YEAR_IN_MILLIS, 0)
            text_updated_at.text = "${getString(R.string.prefix_updated)} $text"
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_repo_details
}