package jp.techacademy.kanako.takahashi.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager

/**
 * A simple [Fragment] subclass.
 */
class FragmentA : Fragment() {

    companion object {
        fun createInstance(): FragmentA {
            return FragmentA()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonnext = view.findViewById<Button>(R.id.buttonAnext)
        buttonnext.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.add(R.id.container, FragmentB.createInstance())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        val buttonprev = view.findViewById<Button>(R.id.buttonAprev)
        buttonprev.setOnClickListener {
            val entry = activity?.supportFragmentManager?.getBackStackEntryAt(0)
            entry?.id?.let { _entry ->
                activity?.supportFragmentManager?.popBackStack(_entry, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}