package com.jess.tablayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.cursor_activity.*
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CursorActivity : AppCompatActivity(), CoroutineScope {

    private var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cursor_activity)
        val count = 1

        CoroutineScope(coroutineContext).launch {
            Log.d("jess", "run $count++")
            while (true) {
                delay(1000)
                v_cursor.run {
                    visibility = if (tag == View.GONE) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                    tag = visibility
                }
            }
        }

        et_password.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                addPasswordDot(count)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    /**
     * 패스워드 입력 후 •로 변환
     */
    private fun addPasswordDot(count: Int) {
//        ll_password.removeAllViews()
//        val view = layoutInflater.inflate(R.layout.cursor_password_dot, null)

        ll_password.removeAllViews()
        val params = LinearLayout.LayoutParams(10, 10)
        params.rightMargin = 50

        for (i in 0 until count) {
            val view = View(this).apply {
                setBackgroundResource(R.drawable.shp_oval_black)
            }
            ll_password.addView(view, params)
        }
        ll_password.requestLayout()
    }
}

