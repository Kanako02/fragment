package jp.techacademy.kanako.takahashi.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class FragmentB : Fragment() {

    companion object {
        fun createInstance(): FragmentB {
            return FragmentB()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonnext = view.findViewById<Button>(R.id.buttonBnext)
        buttonnext.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.add(R.id.container, FragmentC.createInstance())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        val buttonprev = view.findViewById<Button>(R.id.buttonBprev)
        buttonprev.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}