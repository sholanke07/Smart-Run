package com.lateef.runningapp.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.lateef.runningapp.R
import com.lateef.runningapp.other.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment: Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFieldsFromSharedPref()

        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if (success){
                Snackbar.make(view, "Saved Changes", Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(view, "Please fill out all fields", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    private fun loadFieldsFromSharedPref(){
        val name = sharedPreferences.getString(Constants.KEY_NAME, "")
        val weight = sharedPreferences.getFloat(Constants.KEY_WEIGHT, 80f)

        etName.setText(name)
        etWeight.setText(weight.toString())
    }

    private fun applyChangesToSharedPref(): Boolean{
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()
        if (nameText.isEmpty() || weightText.isEmpty()){
            return false
        }
        sharedPreferences.edit()
                .putString(Constants.KEY_NAME, nameText)
                .putFloat(Constants.KEY_WEIGHT, weightText.toFloat())
                .apply()
        val toolbarText = "Let's go $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }
}