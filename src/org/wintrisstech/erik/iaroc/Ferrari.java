package org.wintrisstech.erik.iaroc;

import android.os.SystemClock;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.wintrisstech.irobot.ioio.IRobotCreateScript;
import org.wintrisstech.sensors.UltraSonicSensors;

/**
 * A Ferrari is an implementation of the IRobotCreateInterface.
 *
 * @author Erik
 */
public class Ferrari extends IRobotCreateAdapter implements Runnable
{
    private static final String TAG = "Ferrari";
    private final UltraSonicSensors ultraSonicSensors;
    private final Dashboard dashboard;

    public Ferrari(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard) throws ConnectionLostException
    {
        super(create);
        ultraSonicSensors = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    public void run()
    {
        dashboard.log("Running ...");
        //goForward(-100, 100);
        try
        {
            while (true)
            {
                readSensors(SENSORS_GROUP_ID6);
                if (getInfraredByte() == 242)
                {
                    driveDirect(-100, 100);
                }
                dashboard.log("I see the beacon...");
            }
            //where is the beacon
            //turn to the beacon
            //move to the beacon

        } catch (ConnectionLostException ex)
        {
            Logger.getLogger(Ferrari.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//    private void stop()
//    {
//        
//        try
//        {
//            driveDirect(0, 0);
//        } catch (ConnectionLostException ex)
//        {
//        }
//    }
//
//    private void goForward(int leftWheelSpeed, int rightWheelSpeed)
//    {
//        try
//        {
//            driveDirect(rightWheelSpeed, leftWheelSpeed);
//        } catch (ConnectionLostException ex)
//        {
//        }
//    }
//
//    private void goBackward(int leftWheelSpeed, int rightWheelSpeed)
//    {
//        try
//        {
//            driveDirect(-rightWheelSpeed, -leftWheelSpeed);
//        } catch (ConnectionLostException ex)
//        {
//        }
//    }
//
//    private void crashRight()
//    {
//        if (isBumpRight())
//        {
//            goBackward(100, 200);
//            SystemClock.sleep(2000);
//            goForward(500, 500);
//            SystemClock.sleep(5000);
//        }
//    }
//
//    private void crashLeft()
//    {
//        if (isBumpLeft())
//        {
//            goBackward(200, 100);
//            SystemClock.sleep(2000);
//            goForward(500, 500);
//            SystemClock.sleep(5000);
//        }
//    }

    boolean isRunning()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    int getLeftDistance()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    int getFrontDistance()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    int getRightDistance()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
