/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasockets;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author psistemas
 */
public class InactivityListener implements ActionListener,AWTEventListener {
    
    public final static long KEY_EVENTS = AWTEvent.KEY_EVENT_MASK;
    
    public final static long MOUSE_EVENTS = AWTEvent.MOUSE_MOTION_EVENT_MASK 
            
                                            + AWTEvent.MOUSE_EVENT_MASK;
    
    public final static long USER_EVENTS = KEY_EVENTS + MOUSE_EVENTS;
    
    private Window window;
    
    private Action action;
    
    private int interval;
    
    private long eventMask;
    
    private Timer timer = new Timer(0,this);
    
    public InactivityListener(Window window,Action action,int minutes,
                              long eventMask) {
        
        this.window = window;
        
        setAction( action );
        
	setInterval( minutes );
        
	setEventMask( eventMask );
    }
    
    public void setAction(Action action) {
        
        this.action = action;
    }
    
    public void setInterval(int minutes) {
        
        setIntervalInMillis(minutes*60000);
    }
    
    public void setIntervalInMillis(int interval) {
        
        this.interval  = interval;
        
        timer.setInitialDelay(interval);
    }
    
    public void setEventMask(long eventMask) {
        
        this.eventMask = eventMask;
    }
    
    /*
     * Start listening for events
     */
    public void start() {
        
	timer.setInitialDelay(interval);
        
	timer.setRepeats(false);
        
	timer.start();
                       
	Toolkit.getDefaultToolkit().addAWTEventListener(this,eventMask);
    }
	/*
	 *  Stop listening for events
	 */
    public void stop() {
        
        Toolkit.getDefaultToolkit().removeAWTEventListener(this);
        
        timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ActionEvent ae = new ActionEvent(window,ActionEvent.ACTION_PERFORMED,"");
        
        action.actionPerformed(ae);
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        
        if(timer.isRunning())
            
            timer.restart();
    }
    
}
