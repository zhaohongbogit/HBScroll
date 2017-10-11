package tk.zhzephi.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        request("http://api5-dev.huangbaoche.com/trade/v1.0/e/order/getServicingCount")

        goDraw.onClick { startActivity<DrawHookActivity>() }
    }

    //一个专为 Android 开发量身打造的库，名为 anko
    fun request(url: String) {
        doAsync {
            val response = URL(url).readText()
            uiThread {
                main_msg.text = response
            }
        }
    }

    /**
     * 执行初始化
     */
    fun init() {
        var t: Int = 2;
        main_msg.text = "$t Hello world !"
    }
}
