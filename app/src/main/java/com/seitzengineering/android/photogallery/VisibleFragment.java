package com.seitzengineering.android.photogallery;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Kevin on 4/28/2016.
 */
public abstract class VisibleFragment extends Fragment {
    private static final String TAG = "VisibleFragment";

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(PollService.ACTION_SHOW_NOTIFICATION);
        getActivity().registerReceiver(m0nShowNotification, filter, PollService.PERM_PRIVATE, null);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(m0nShowNotification);
    }

    private BroadcastReceiver m0nShowNotification = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context,Intent intent) {
           Log.i(TAG, "cancelling notification");
           setResultCode(Activity.RESULT_CANCELED);
        }
    };
}
