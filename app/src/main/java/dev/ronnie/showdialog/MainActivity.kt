package dev.ronnie.showdialog

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_layout.view.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView: View = View.inflate(this, R.layout.dialog_layout, null)
        dialogBuilder.setView(dialogView)

        val dialog = dialogBuilder.create()

        dialog.show()

        val displayRectangle = Rect()
        val window: Window = this.window

        window.decorView.getWindowVisibleDisplayFrame(displayRectangle)

        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT, (displayRectangle.height() * 0.5f).toInt()
        )
        dialog.window!!.setGravity(Gravity.CENTER)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogView.btn.setOnClickListener {
            Toast.makeText(this, "You agreed", Toast.LENGTH_SHORT).show()
        }
        dialogView.img.setOnClickListener {
            Toast.makeText(this, "You Canceled", Toast.LENGTH_SHORT).show()
            dialog.dismiss()

        }


    }
}