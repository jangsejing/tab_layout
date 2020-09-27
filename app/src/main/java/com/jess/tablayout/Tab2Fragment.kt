package com.jess.tablayout

import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BulletSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.jess.tablayout.common.adapter.ViewUtils.dpToPx
import kotlinx.android.synthetic.main.main_tab2_fragment.*

class Tab2Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.main_tab2_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_test.text = Html.fromHtml(getString(R.string.html_message))


        val text =
            "Text with2222222Text with2222222Text with2222222Text with2222222Text with2222222Text with2222222Text with2222222Text with2222222Text with2222222"
        val string = SpannableString(text)
        string.setSpan(
            BulletSpan(
                6.dpToPx(requireContext()),
                ContextCompat.getColor(requireContext(), R.color.colorAccent)
            ),
            0,
            text.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_bullet.text = string
    }
}