package com.yn_1.demo2_volleyproject;

import android.app.Application;


import com.android.volley.RequestQueue;
import com.android.volley.Network;
import com.android.volley.Cache;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Application class for creating and configuring volley requests.<br>
 * This classes' code will be executed first, before the main activity. <br>
 *
 * @author Roba Abbajabal
 */
public class AppController extends Application {

    // Variable to hold AppController instance
    private AppController instance;

    // Variable for the request queue
    private RequestQueue requestQueue;

    // Variable for the HTTP network
    private Network network;

    // Variable for setting up the cache of the network
    private Cache cache;

    /**
     * Creates an instance of the Application class.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createRequestQueue();
    }

    /**
     * Gets the instance of AppController, without thread interference.
     * @return Instance of AppController class.
     */
    public static synchronized AppController getInstance() {
        return getInstance();
    }

    /**
     * Creates the cache and the network to be used for volley requests.
     * Creates the request queue after the cache and the network are instantiated.
     */
    private void createRequestQueue() {
        cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
    }

    /**
     * Starts the request queue.
     */
    public void startRequestQueue() {
        requestQueue.start();
    }

    /**
     * Ends the request queue.
     */
    public void endRequestQueue() {
        requestQueue.stop();
    }
}
