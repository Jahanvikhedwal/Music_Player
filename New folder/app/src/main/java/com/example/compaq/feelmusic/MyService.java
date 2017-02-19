package com.example.compaq.feelmusic;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/**
 * Created by compaq on 22-03-2016.
 */
public class MyService extends Service {
    public MyService() {
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        String cmd = intent.getStringExtra("cmd");
        if("prv".equalsIgnoreCase(cmd)){
            Main2Activity.ctrls.playPre(MyService.this);
        }
        else if("nxt".equalsIgnoreCase(cmd)){
            Main2Activity.ctrls.playNext(MyService.this);
        }
        else if("pause".equalsIgnoreCase(cmd)){
            Main2Activity.ctrls.playPause(MyService.this);
        }
        else if("close".equalsIgnoreCase(cmd)){
            final NotificationManager nm = (NotificationManager) getSystemService (NOTIFICATION_SERVICE);
            nm.cancel(0);
            Main2Activity.ctrls.stopSong();
        }
        MyService.this.stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

}

}
