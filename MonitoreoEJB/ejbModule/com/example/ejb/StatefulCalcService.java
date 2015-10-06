package com.example.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class StatefulCalcService
 */
@Stateful
@LocalBean
public class StatefulCalcService implements StatefulCalcServiceRemote, StatefulCalcServiceLocal {
	
	public int value = 0;
    public StatefulCalcService() { }
    public void add (int n){ value += n; }
    public void substract (int n) { value -= n; }
    public int getValue() { return value;} 

}
