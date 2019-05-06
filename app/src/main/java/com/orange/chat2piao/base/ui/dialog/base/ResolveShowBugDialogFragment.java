package com.orange.chat2piao.base.ui.dialog.base;


import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ResolveShowBugDialogFragment extends DialogFragment {

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            FragmentTransaction ft = manager.beginTransaction();
            if (isAdded()) {
                ft.add(this, tag).addToBackStack(null);
            } else {
                ft.show(this);
            }
            ft.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
        }
    }

    boolean mIsStateAlreadySaved = false;
    boolean mPendingShowDialog = false;

    @Override
    public void onResume() {
        onResumeFragments();
        super.onResume();
    }

    public void onResumeFragments() {
        mIsStateAlreadySaved = false;
        if (mPendingShowDialog) {
            mPendingShowDialog = false;
            showSnoozeDialog();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mIsStateAlreadySaved = true;
    }

    private void showSnoozeDialog() {
        if (mIsStateAlreadySaved) {
            mPendingShowDialog = true;
        } else {
            FragmentManager fm = getFragmentManager();
            ResolveShowBugDialogFragment snoozeDialog = new ResolveShowBugDialogFragment();
            snoozeDialog.show(fm, "BaseDialogFragment");
        }
    }

    public void dismissDialog() {
        super.dismiss();
    }
}
