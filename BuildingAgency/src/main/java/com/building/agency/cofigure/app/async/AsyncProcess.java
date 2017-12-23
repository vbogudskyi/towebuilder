/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.building.agency.cofigure.app.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Declares an asynchronous operation
 * @author vbohudskyi
 * @param <E> - an arguments type
 * @param <R> - a result type
 * @version 1.0
 */
public abstract class AsyncProcess<E, R> {

    private ExecutorService service = null; //java concurrent executor is stored here    
    
    /**
     * Default constructor of async process
     * @version 1.0
     */
    public AsyncProcess()
    {
       service = Executors.newCachedThreadPool(); // a cached thead pool is created here 
    }
    
    /**
     * Method calls in UI and prepares a background process to be started
     * @version 1.0
     */
    protected abstract void onPreExecute();
    
    /**
     * Method calls in background and starts an asynchronous process
     * @param parameters - parameters of asynchronous process
     * @return result
     * @version 1.0
     */
    protected abstract R doInBackground(E... parameters);
    
    /**
     * Method call in UI and provides a result of a background process
     * @param result - a result of a background process
     * @version 1.0
     */
    protected abstract void onPostExecute(R result);
    
    /**
     * Method starts a background process
     * @param parameters - parameters of background process
     * @version 1.0
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    public void start(E... parameters) throws InterruptedException, ExecutionException
    {
        onPreExecute(); // preparation method calls
        Future<R> future = service.submit(new BackgroundTask(parameters)); // background process is started
        if(future != null && !future.isCancelled()) // if background process is valid and not cancelled
        {
            R result = future.get(); // request a result of a background process
            onPostExecute(result); // run post execute method with a final result
        }
    }
    
    /**
     *  Declares an asynchronous operation
     *  @author vbohudskyi
     *  @version 1.0
     */
    private final class BackgroundTask implements Callable<R>
    { 
        private E[] parameters = null; // background process parameters are stored here
        
        /**
         * Default constructor of background task
         * @param parameters - parameters of background process
         * @version 1.0
         */
        public BackgroundTask(E... parameters)
        {
            this.parameters = parameters; // background process parameters assigned
        }
        
        @Override
        public R call() throws Exception {
            return doInBackground(parameters); // background method calls here
        }
        
    }
}
