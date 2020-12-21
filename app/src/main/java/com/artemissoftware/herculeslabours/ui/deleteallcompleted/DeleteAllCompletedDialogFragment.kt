package com.artemissoftware.herculeslabours.ui.deleteallcompleted

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeleteAllCompletedDialogFragment :DialogFragment(){


    private val viewModel : DeleteAllCompletedViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Confirm deletion")
            .setMessage("Do you really wnat to delete all completed tasks?")
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->

                viewModel.onConfirmClick()
            }
            .create()
    }

}